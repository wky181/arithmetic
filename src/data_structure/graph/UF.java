package data_structure.graph;

/**
 * @Author: wky233
 * @Date: 2020/7/9 23:37
 * @Description:
 */
public class UF {
    private int[] parent;
    private int[] size;
    private int lenght;
    public UF(int length) {
        this.lenght = length;
        parent = new int[length];
        this.size = new int[length];
        // 初始化并查集
        for (int i = 0; i < parent.length ; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    private void isVaild(int p){
        if (p < 0 && p >= lenght){
            throw new IllegalArgumentException();
        }
    }
    private int find(int p){
        isVaild(p);
        while (parent[p] != p){
            // 压缩路径
            int grandFather =  parent[parent[p]];
            parent[p] = grandFather;
            p = grandFather;
        }
        return p;
    }
    public boolean isConnect(int p, int q){
        isVaild(p);
        isVaild(q);
        return find(p) == find(q);
    }

    public void UnionElements(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot){
            return;
        }
        int pSize = size[p];
        int qSize = size[q];
        if (pSize > qSize){
            parent[qRoot] = pRoot;
            size[pRoot] = pSize + qSize;
        }else {
            parent[pRoot] = qRoot;
            size[qRoot] = pSize + qSize;
        }
    }

    public static void main(String[] args) {
        UF uf  = new UF(6);
        uf.UnionElements(1,2);
        uf.UnionElements(3,4);
        uf.UnionElements(0,1);
        uf.UnionElements(0,5);
        uf.UnionElements(1,4);
        System.out.println(uf.isConnect(1,3));

    }
}
