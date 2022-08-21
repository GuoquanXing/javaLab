package com.example.lab.demo.datastructure.binarytree;

public class BinaryTree {

    private int depth, result;

    class TreeNode {
        TreeNode left, right;
        int value;
    }

    public int getDepth(TreeNode root){
        traverse(root);
        return result;
    }

    public int getDepth2(TreeNode root){
        if(root == null) return 0;

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        //postOrder
        return Math.max(leftDepth, rightDepth) + 1;
    }

    private void traverse(TreeNode root) {
        if(root == null) return;
        //preOrder
        depth++;
        if(root.left == null && root.right == null){
            result = Math.max(result, depth);
        }
        traverse(root.left);
        traverse(root.right);
        depth--;
    }
    
}
