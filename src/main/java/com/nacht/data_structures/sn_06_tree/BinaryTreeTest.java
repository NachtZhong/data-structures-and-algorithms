package com.nacht.data_structures.sn_06_tree;

import com.nacht.data_structures.basic.TreeNode;

import java.util.*;

import static com.nacht.util.PrettyPrintUtil.printBinaryTree;

/**
 * @author Nacht
 * Created on 2023/11/14 14:35
 */
public class BinaryTreeTest {

    public static void main(String[] args) {
        /*init the binary tree*/
        /*
         *             1
         *           /   \
         *          2      3
         *        /   \   /  \
         *      4     5  6    7
         */
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        printBinaryTree(root);
        System.out.println(bfsTraverse(root));
        System.out.println(preOrderTraversal(root, new ArrayList<>()));
        System.out.println(inOrderTraversal(root, new ArrayList<>()));
        System.out.println(postOrderTraversal(root, new ArrayList<>()));
    }


    /**
     * 层序遍历
     */
    public static List<Integer> bfsTraverse(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> cache = new LinkedList<>();
        /*根节点入队*/
        cache.offer(root);
        while(!cache.isEmpty()){
            TreeNode node = cache.poll();
            result.add(node.getVal());
            /*左子节点如果存在则入队*/
            Optional.ofNullable(node.getLeft()).ifPresent(
                    cache::offer
            );
            /*右子节点如果存在则入队*/
            Optional.ofNullable(node.getRight()).ifPresent(
                    cache::offer
            );
        }
        return result;
    }

    /**
     * 前序遍历
     */
    public static List<Integer> preOrderTraversal(TreeNode node, List<Integer> result){
         /*首先把当前节点加到结果集*/
        result.add(node.getVal());
        /*如果有左子树, 前序遍历左子树*/
        Optional.ofNullable(node.getLeft()).ifPresent(
                treeNode -> preOrderTraversal(treeNode, result)
        );
        /*如果有右子树, 前序遍历右子树*/
        Optional.ofNullable(node.getRight()).ifPresent(
                treeNode -> preOrderTraversal(treeNode, result)
        );
        return result;
    }

    /**
     * 中序遍历
     */
    public static List<Integer> inOrderTraversal(TreeNode node, List<Integer> result){
        /*如果有左子树, 中序遍历左子树*/
        Optional.ofNullable(node.getLeft()).ifPresent(
                treeNode -> inOrderTraversal(treeNode, result)
        );
        /*把当前节点加到结果集*/
        result.add(node.getVal());
        /*如果有右子树, 中序遍历右子树*/
        Optional.ofNullable(node.getRight()).ifPresent(
                treeNode -> inOrderTraversal(treeNode, result)
        );
        return result;
    }

    /**
     * 中序遍历
     */
    public static List<Integer> postOrderTraversal(TreeNode node, List<Integer> result){
        /*如果有左子树, 中序遍历左子树*/
        Optional.ofNullable(node.getLeft()).ifPresent(
                treeNode -> inOrderTraversal(treeNode, result)
        );
        /*如果有右子树, 中序遍历右子树*/
        Optional.ofNullable(node.getRight()).ifPresent(
                treeNode -> inOrderTraversal(treeNode, result)
        );
        /*把当前节点加到结果集*/
        result.add(node.getVal());
        return result;
    }
}
