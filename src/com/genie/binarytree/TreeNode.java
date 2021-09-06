package com.genie.binarytree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode _left, TreeNode _right) {
        this.val = val;
        this.left = _left;
        this.right = _right;
    }
}