package com.nacht.data_structures.basic;

import lombok.Data;

/* 二叉树节点类 */
@Data
public class TreeNode {
    /**
     * 节点值
     */
    private int val;
    /**
     * 左子节点引用
     */
    private TreeNode left;
    /**
     * 右子节点引用
     */
    private TreeNode right;

    public TreeNode(int x) {
        val = x;
    }
}