package com.example.lab.demo.datastructure.graph;

public class UnionFind {

    private int count;
    private int[] parent;

    public UnionFind(int n) {

        this.count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ)
            return;

        parent[rootP] = rootQ;
        count--;
    }

    public int find(int i) {
        if (i != parent[i]) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public Boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    // 返回图中的连通分量个数
    public int count() {
        return count;
    }

}
