package com.nacht.util;

import com.nacht.data_structures.basic.Node;
import com.nacht.data_structures.basic.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 打印各种数据结构的
 * @author Nacht
 * Created on 2023/11/16 20:25
 */
public class PrettyPrintUtil {

    private static int MIN_WIDTH = 2;

    public static <T> void printArray(T[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static <T> void printLinkedList(Node<T> node) {
        StringBuilder listStr = new StringBuilder();
        listStr.append(node.getValue());
        Node<T> next = node.getNext();
        while (next != null) {
            listStr.append(" => ").append(next.getValue());
            next = next.getNext();
        }
        System.out.println(listStr);
    }

    private static class TreeNodeWidth {
        int value; //节点的值
        int spaceL;//节点左边的空格数
        int spaceR;//节点右边的空格数
        TreeNodeWidth left;//左孩子
        TreeNodeWidth right;//右孩子
        boolean isLeft;//标识该节点是否是父节点的左孩子
        boolean isRoot; //是否根节点

        public TreeNodeWidth(int value, int spaceL, int spaceR, TreeNodeWidth left, TreeNodeWidth right, boolean isLeft) {
            this.value = value;
            this.spaceL = spaceL;
            this.spaceR = spaceR;
            this.left = left;
            this.right = right;
            this.isLeft = isLeft;
        }

        public void setRoot(boolean root) {
            isRoot = root;
        }
    }

    private static <T> void breathFirstTraversalPrint(TreeNodeWidth nodeWidth) {
        //宽度优先遍历
        Queue<TreeNodeWidth> queue = new LinkedList<>();
        queue.add(nodeWidth);
        TreeNodeWidth currentEnd = nodeWidth;
        TreeNodeWidth nextEnd = null;
        TreeNodeWidth prev = null;
        TreeNodeWidth poll = null;
        HashMap<TreeNodeWidth, Integer> placeholder = new HashMap<>();
        int placeholderLength = 0;
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty() && poll != currentEnd) {
            poll = queue.poll();
            int value = poll.value;
            int valLen = String.valueOf(value).length();
            int length = valLen % 2 == 0 ? valLen : (valLen + 1);
            if (placeholder.containsKey(poll)) {
                String formatStr = String.format("%" + placeholder.get(poll) + "s", " ");
                sb.append(formatStr);
                if (prev != null && prev.isLeft && poll.isLeft) {
                    for (int i = 1; i < prev.spaceR; i++) {
                        System.out.print("-");
                    }
                    System.out.print("|");
                    formatStr = String.format("%" + (placeholder.get(poll) - prev.spaceR) + "s", " ");
                }
                System.out.print(formatStr);
                if (poll.left == null && poll.right == null) {
                    placeholderLength += placeholder.get(poll);
                } else if (poll.left != null) {
                    placeholder.put(poll.left, placeholder.get(poll));
                } else {
                    placeholder.put(poll.right, placeholder.get(poll));
                }
                placeholder.remove(poll);
            }
            TreeNodeWidth pr = poll.right;
            TreeNodeWidth pl = poll.left;
            int jumpLength = prev == null ? poll.spaceL : poll.spaceL + prev.spaceR;
            sb.append(String.format("%" + jumpLength + "s%" + length + "s", " ", value));
            if (!poll.isLeft) {
                int i = 0;
                int mid = poll.spaceR;
                if (prev != null && !prev.isLeft) {
                    System.out.printf("%" + prev.spaceR + "s", " ");
                    i = prev.spaceR;
                    mid = i;
                }
                if (prev == null) {
                    mid = 0;
                }
                for (; i < jumpLength; i++) {
                    if (i == mid) {
                        System.out.print("|");
                    } else {
                        System.out.print("-");
                    }
                }
                if (length > 2) {
                    for (int j = 2; j < length; j++) {
                        System.out.print("-");
                    }
                }
                System.out.print("->");
            } else {

                System.out.printf("%" + jumpLength + "s", " ");
                if (poll.isRoot){
                    System.out.print("---");
                }else{
                    System.out.print("<-");
                }
                if (length > 2) {
                    for (int j = 2; j < length; j++) {
                        System.out.print("-");
                    }
                }

            }
            if (pl != null) {
                nextEnd = pl;
                queue.add(pl);
            }
            if (pr != null) {
                nextEnd = pr;
                queue.add(pr);
            }
            if (pl != null ^ pr != null) {
                if (pr != null) {
                    int rsl = String.valueOf(poll.right.value).length();
                    rsl = rsl % 2 == 0 ? rsl : rsl + 1;
                    placeholderLength += poll.right.spaceL + poll.right.spaceR + rsl;
                }
            }
            if (pl == null && pr == null) {
                placeholderLength += poll.spaceL + poll.spaceR + length;
            } else if (placeholderLength > 0 && pl != null) {
                placeholder.put(poll.left, placeholderLength);
                placeholderLength = 0;
            } else if (placeholderLength > 0) {
                placeholder.put(poll.right, placeholderLength);
                placeholderLength = 0;
            }
            if (pl != null ^ pr != null) {
                if (pl != null) {
                    placeholderLength += poll.left.spaceL + poll.left.spaceR + String.valueOf(poll.left.value).length();
                }
            }
            prev = poll;
            if (currentEnd == poll) {
                currentEnd = nextEnd;
                placeholderLength = 0;
                System.out.println();
                prev = null;
                System.out.println(sb);
                sb = new StringBuilder();
            }
        }
    }


    private static TreeNodeWidth recursiveCalculateWidth(TreeNode node, boolean isLeft, boolean isRoot) {
        if (node == null) {
            return null;
        }
        TreeNodeWidth left = recursiveCalculateWidth(node.getLeft(), true, false);
        TreeNodeWidth right = recursiveCalculateWidth(node.getRight(), false, false);
        int spaceL = 0;
        int spaceR = 0;
        int plen = String.valueOf(node.getVal()).length();
        //将父节点的数值的宽度平摊到子节点上去
        plen = plen % 2 == 0 ? plen / 2 : (plen + 1) / 2;
        boolean lnn = left != null;
        if (lnn) {
            int length = String.valueOf(left.value).length();
            length = length % 2 == 0 ? length / 2 : (length + 1) / 2;
            spaceL += left.spaceL + length;
            spaceR += left.spaceR + length;
        }
        boolean rnn = right != null;
        if (rnn) {
            int length = String.valueOf(right.value).length();
            length = length % 2 == 0 ? length / 2 : (length + 1) / 2;
            spaceL += right.spaceL + length;
            spaceR += right.spaceR + length;
        }
        TreeNodeWidth result = new TreeNodeWidth(node.getVal(), Math.max(lnn && rnn ? spaceL - plen : (spaceL << 1) - plen, MIN_WIDTH), Math.max(lnn && rnn ? spaceR - plen : (spaceR << 1) - plen, MIN_WIDTH), left, right, isLeft);
        result.setRoot(isRoot);
        return result;
    }


    public static void printBinaryTree(TreeNode node) {
        //递归构造带宽度的二叉树结构，为下一步做准备
        TreeNodeWidth treeNodeWidth = recursiveCalculateWidth(node, true, true);
        breathFirstTraversalPrint(treeNodeWidth);
    }

    public static void main(String[] args) {

        Node<Integer> node = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        node.setNext(node2);
        printLinkedList(node);
        printArray(new Node[]{node, node});
    }

}
