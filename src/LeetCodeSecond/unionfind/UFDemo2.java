package LeetCodeSecond.unionfind;

/**
 * @Author: wky233
 * @Date: 2020/6/7 0:16
 * @Description:
 */
public class UFDemo2 implements UF {
    private int[] parent;
    @Override
    public int getSize() {
        return parent.length;
    }

    public UFDemo2(int size) {
       parent = new int[size];
        for (int i = 0; i < size ; i++) {
            parent[i] = i;
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
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot){
            return;
        }
        parent[pRoot] = qRoot;
    }
}
