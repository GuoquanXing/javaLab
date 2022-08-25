package com.example.lab.demo.searching;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeSearcher {

    class TreeNode<E> {
        TreeNode<E> left, right;
        E value;
    }

    public List<Integer> inOrderSearchWithRecursive(TreeNode<Integer> root) {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    private void inOrder(TreeNode<Integer> root, List<Integer> result) {
        if (root == null)
            return;
        inOrder(root.left, result);
        result.add(root.value);
        inOrder(root.right, result);
    }

    public List<Integer> inOrderSearchWithIteration(TreeNode<Integer> root) {
        List<Integer> result = new ArrayList<>();

        Deque<TreeNode<Integer>> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.value);
            root = root.right;
        }
        return result;
    }
}
