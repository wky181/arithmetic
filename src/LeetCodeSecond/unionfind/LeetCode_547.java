package LeetCodeSecond.unionfind;

/**
 * @Author: wky233
 * @Date: 2020/6/7 13:01
 * @Description:

 *
 *
 */
public class LeetCode_547 {
    public int findCircleNum(int[][] M) {
        UF uf = new UF(M.length);
        for (int i = 0; i < M.length ; i++) {
            for (int j = 0; j < M[i].length ; j++) {
                if (M[i][j] == 1){
                    uf.unionElements(i,j);
                }
            }
        }
        return uf.count;
    }
    private class UF{
        // 返回图中有多少个联通分量
        int count = 0;
        private int[] parent;
        // 记录树的排行(最大深度)
        private int[] rank;

        public int getCount() {
            return count;
        }

        public UF(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < parent.length ; i++) {
                parent[i] = i;
                rank[i]  = 1;
            }
            count = size;
        }
        // 查找元素p所属集合
        public int find(int p){
            while (p != parent[p]){
                // 压缩路径
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        public boolean isConnected(int p, int q){
            return find(p) == find(q);
        }
        public void unionElements(int p, int q){
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot){
                return;
            }
            if (rank[pRoot] > rank[qRoot]){
                parent[qRoot] = pRoot;

            }
            else if (rank[qRoot] > rank[pRoot] ){
                parent[pRoot] = qRoot;
            }else {
                parent[qRoot] = pRoot;
                rank[pRoot]++;
            }
            count--;
        }
    }
}
