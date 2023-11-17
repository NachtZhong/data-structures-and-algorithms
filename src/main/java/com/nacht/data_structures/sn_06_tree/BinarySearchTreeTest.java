package com.nacht.data_structures.sn_06_tree;

import com.nacht.data_structures.basic.TreeNode;
import com.nacht.util.PrettyPrintUtil;

import java.util.ArrayList;

import static com.nacht.util.PrettyPrintUtil.printBinaryTree;

/**
 * @author Nacht
 * Created on 2023/11/17 16:45
 */
public class BinarySearchTreeTest {
    public static void main(String[] args) {
        /*
         * init the binary search tree
         *                       ---
         *                        8
         *           <------------|----------->
         *            4                      12
         *     <------|----->          <------|----->
         *      2           6          10          14
         *  <---|-->    <---|-->    <---|-->    <---|-->
         *   1     3     5     7     9    11    13    15
         *
         */
        TreeNode root = new TreeNode(8);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(10);
        TreeNode node7 = new TreeNode(14);
        TreeNode node8 = new TreeNode(1);
        TreeNode node9 = new TreeNode(3);
        TreeNode node10 = new TreeNode(5);
        TreeNode node11 = new TreeNode(7);
        TreeNode node12 = new TreeNode(9);
        TreeNode node13 = new TreeNode(11);
        TreeNode node14 = new TreeNode(13);
        TreeNode node15 = new TreeNode(15);
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        node4.setLeft(node8);
        node4.setRight(node9);
        node5.setLeft(node10);
        node5.setRight(node11);
        node6.setLeft(node12);
        node6.setRight(node13);
        node7.setLeft(node14);
        node7.setRight(node15);
        printBinaryTree(root);

        /*---------------------------- 搜索测试 ------------------------------*/
        System.out.println(search(root, 1)); // TreeNode(val=1, left=null, right=null)
        System.out.println(search(root, 2)); // TreeNode(val=2, left=TreeNode(val=1, left=null, right=null), right=TreeNode(val=3, left=null, right=null))
        System.out.println(search(root, 14)); // TreeNode(val=14, left=TreeNode(val=13, left=null, right=null), right=TreeNode(val=15, left=null, right=null))
        System.out.println(search(root, 19)); // null
        System.out.println(search(root, -1)); // null
        /*---------------------------- 添加测试 ------------------------------*/
        System.out.println(add(root, 20));
        System.out.println(add(root, 19));
        System.out.println(add(root, 21));
        printBinaryTree(root);
        System.out.println(search(root, 19));

    }

    /**
     * 二叉树搜索
     * @param root 根节点
     * @param value 搜索值
     * @return TreeNode 匹配节点, 如果没有匹配到返回null
     */
    private static TreeNode search(TreeNode root, int value){
        if(root == null){
            return null;
        }
        if(root.getVal() == value){
            // 当前节点相同, 返回结果
            return root;
        }else if(value < root.getVal()){
            //小于当前节点, 搜索左子树
            return search(root.getLeft(), value);
        }else{
            //大于当前节点, 搜索右子树
            return search(root.getRight(), value);
        }
    }

    /**
     * 添加节点
     * @param root 树的根节点
     * @param value 要添加的节点值
     */
    private static TreeNode add(TreeNode root, int value){
        if(root.getVal() == value){
            // 树中已经存在这个节点, 直接返回
            return root;
        }else if(value < root.getVal()){
            // 小于当前节点, 如果左子树不存在, 添加到左节点, 如果存在, 添加到左子树中
            if(root.getLeft() == null){
                TreeNode node = new TreeNode(value);
                root.setLeft(node);
                return node;
            }else{
                return add(root.getLeft(), value);
            }
        }else{
            // 大于当前节点, 如果右子树不存在, 添加到右节点, 如果存在, 添加到右子树中
            if(root.getRight() == null){
                TreeNode node = new TreeNode(value);
                root.setRight(node);
                return node;
            }else{
                return add(root.getRight(), value);
            }
        }
    }




}
