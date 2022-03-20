package LeetCodeSecond.unionfind;

/**
 * @Author: wky233
 * @Date: 2020/6/7 9:20
 * @Description: rank 优化
 */
public class UFDemo4 implements UF {
    private int[] parent;
    private int[] rank;
    @Override
    public int getSize() {
        return parent.length;
    }

    public UFDemo4(int size) {
        parent = new int[size];
        this.rank = new int[size];
        for (int i = 0; i < size ; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
    // 查找元素p所对应的编号
    public int find (int p){
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException();
        }
        while (p != parent[p]){
            p = parent[p];
        }
        return p;
    }

    @Override
    // 主要优化合并操作
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        // 如果本来就是一个集合 直接返回
        if (pRoot == qRoot){
            return;
        }
        if (rank[pRoot] > rank[qRoot]){
            parent[qRoot] = pRoot;
        }
        else if (rank[qRoot] > rank[pRoot]){
            parent[pRoot] = qRoot;
        }else {
            parent[qRoot] = pRoot;
            rank[pRoot]++;
        }

    }
}

