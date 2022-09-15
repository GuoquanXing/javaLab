package com.example.lab.demo.datastructure.binarytree;

public class BinaryTree {

    private int depth, result;

    class TreeNode {
        TreeNode left, right;
        int value;
        public TreeNode(int value) {
            this.value = value;
        }

        
    }
    /**
     * 前序位置的代码只能从函数参数中获取父节点传递来的数据，而后序位置的代码不仅可以获取参数数据
     * 
     * @param root
     * @param level
     */
    public void getLevelPerNode(TreeNode root, int level){
        if(root == null) return;

        System.out.println("root: " + root.toString() + ",level:" + level);
        getLevelPerNode(root.left, level + 1);
        getLevelPerNode(root.right, level + 1);
    }

    /**
     * 
     * 前序位置的代码只能从函数参数中获取父节点传递来的数据，而后序位置的代码不仅可以获取参数数据
     * 一旦发现问题和子树有关，那大概率要给函数设置合理的定义和返回值，在后序位置写代码了
     * @param root
     * @return
     */
    public int countChildNodeNumber(TreeNode root){
        if(root == null) return 0;

        int leftCount = countChildNodeNumber(root.left);
        int rightCount = countChildNodeNumber(root.right);
        System.out.println("node:" + root.toString() + " have left childs:" + leftCount + ",right childs:" + rightCount);
        return leftCount + rightCount + 1;
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
