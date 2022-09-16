package com.example.lab.demo.datastructure.binarytree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.example.lab.demo.datastructure.binarytree.BinaryTree.TreeNode;

public class NearestCommonAncestor {

    private TreeNode answer;

    /**
     * recusrive from bottom to root
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode find(TreeNode root, TreeNode p, TreeNode q){
        isSonNode(root, p, q);
        return answer;
    }

    private boolean isSonNode(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return false;

        boolean isLeftSon = isSonNode(root.left, p, q);
        boolean isRightSon = isSonNode(root.right, p, q);
        // 后续遍历 自底向上
        if(isLeftSon && isRightSon){
            answer = root;
        }

        if(root.value == p.value || root.value == q.value){
            if(isLeftSon || isRightSon){
                answer = root;
            }
        }
        return isLeftSon || isRightSon || root.value == p.value || root.value == q.value;
    }

    private Map<Integer, TreeNode> parent = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();

    public void dfs(TreeNode root){
        if(root == null) return;

        if(root.left != null){
            parent.put(root.left.value, root);
            dfs(root.left);
        }
        if(root.right != null){
            parent.put(root.right.value, root);
            dfs(root.right);
        }
    }
    /**
     * leverage parent hashmap to persist the parent for all node!
     * later use visited set to persist the parent of p nodes
     * check q nodes to see whether it shares the same parent, if yes then found!s
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);

        while(p != null){
            visited.add(p.value);
            p = parent.get(p.value);
        }

        while(q != null){
            if(visited.contains(q.value)){
                return q;
            }
            q = parent.get(q.value);
        }
        return null;
    }
}
