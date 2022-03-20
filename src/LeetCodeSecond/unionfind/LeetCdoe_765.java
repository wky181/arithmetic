package LeetCodeSecond.unionfind;

/**
 * @Author: wky233
 * @Date: 2020/6/7 14:24
 * @Description:
 * 如果三对情侣做错了位置 A1+B2, B1+C2, C1+A2，他们之间形成了环。
 * 我们只需要交换两次
 * 如果是四对情侣互相做错了位置，形成了一个环，则至少要交换三次
 * 假设k对情侣形成一个环状的错误链，我们只需要交换k - 1次就可以将这k对情侣的位置排好。
 * 所以问题转化成N对情侣中，有几个这样的错误环。
 * 每次遍历相邻的两个位置，如果他们本来就是情侣，他们处于大小为1的错误环中，只需要交换0次。
 * 如果不是情侣，说明他们呢两对处在同一个错误环中，我们将他们合并（union），
 * 将所有的错坐情侣合并和后，答案就是情侣对 - 环个数。
 * 环的大小代表了情侣对数，交换次数 = 环的大小 -1
 * 所有环的长度加起来等于情侣对数，环与环不可能出现情侣对重复
 * */
public class LeetCdoe_765 {
    public int minSwapsCouples(int[] row) {
        int m = row.length / 2;
        UF uf = new UF(m);
        for (int i = 0; i < row.length ; i+=2) {
            uf.unionElements(row[i]/2,row[i+1]/2);
        }
        return m - uf.count;

    }
    private class UF {
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
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
            count = size;
        }

        // 查找元素p所属集合
        public int find(int p) {
            while (p != parent[p]) {
                // 压缩路径
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }

        public void unionElements(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) {
                return;
            }
            if (rank[pRoot] > rank[qRoot]) {
                parent[qRoot] = pRoot;

            } else if (rank[qRoot] > rank[pRoot]) {
                parent[pRoot] = qRoot;
            } else {
                parent[qRoot] = pRoot;
                rank[pRoot]++;
            }
            count--;
        }
    }
}
