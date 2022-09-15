package com.example.lab.demo.datastructure.binarytree;

import java.util.LinkedList;

import com.example.lab.demo.datastructure.binarytree.BinaryTree.TreeNode;

public class BinaryTreeSerializer {
    private static final String SEPARATOR = ",";
    private static final String NULLNODE = "#";
    StringBuffer sb = new StringBuffer();

    public static void main(String[] args) {
        TreeNode root = new BinaryTree().new TreeNode(1);
        TreeNode node1 = new BinaryTree().new TreeNode(2);
        TreeNode node2 = new BinaryTree().new TreeNode(3);
        TreeNode node3 = new BinaryTree().new TreeNode(4);

        root.left = node1;
        root.right = node2;
        node1.right = node3;
        BinaryTreeSerializer btSerializer = new BinaryTreeSerializer();
        String data = btSerializer.serialize(root);
        System.out.println(data);

        btSerializer.printBinaryTreePreOrder(btSerializer.deserialize(data));
    }

    public String serialize(TreeNode root){
        // 前序遍历二叉树并将节点的值存入StringBuffer里
        traverse(root);
        return sb.toString();
    }

    public TreeNode deserialize(String data){
        LinkedList<String> nodes = new LinkedList<>();
        for(String s : data.split(SEPARATOR)){
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    private TreeNode deserialize(LinkedList<String> nodes){
        if(nodes.isEmpty()){
            return null;
        }

        TreeNode root;
        // the first node in the list would be the root node
        String first = nodes.removeFirst();
        if(!first.equals(NULLNODE)){
            root = new BinaryTree().new TreeNode(Integer.parseInt(first));
        }else{
            return null;
        }
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }

    public void printBinaryTreePreOrder(TreeNode root){
        if(root == null){
            System.out.println(NULLNODE);
            return;
        }
        System.out.println(root.value);

        printBinaryTreePreOrder(root.left);
        printBinaryTreePreOrder(root.right);
    }

    private void traverse(TreeNode root){
        // Base Case
        if(root == null ){
            sb.append(NULLNODE).append(SEPARATOR);
            return;
        };

        sb.append(String.valueOf(root.value)).append(SEPARATOR);
        traverse(root.left);
        traverse(root.right);
    }
    
}
