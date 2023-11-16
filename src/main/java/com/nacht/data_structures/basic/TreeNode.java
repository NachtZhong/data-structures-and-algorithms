package com.nacht.data_structures.basic;

import lombok.Data;

/**
 * 二叉树节点类
 * @author Nacht
 * Created on 2023/11/10 13:16
 */
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