package Interview.meituan;

import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/8/15 16:16
 * @Description:
 */
public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] nums = new int[m][2];
        for (int i = 0; i < m ; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }
        UF uf = new UF(n);
        for (int[] num: nums) {
            uf.unionElements(num[0],num[1]);
        }
        boolean[] mark = new boolean[n+1];
        int count = uf.count;
        System.out.println(count);
        for (int i = 1; i <= n ; i++) {
            for (int j = i; j <= n ; j++) {
                if (uf.isConnected(i,j) && !mark[j]){
                    System.out.print(j + " ");
                    mark[j] = true;
                }
            }
            System.out.println();
        }


    }
    private static class UF{
        int[] parent;
        int[] sz;
        int count;
        public UF(int size) {
            parent = new int[size+1];
            sz = new int[size+1];
            count = size;
            for (int i = 1; i <= size; i++) {
                parent[i] = i;
                sz[i] = 1;
            }
        }
        // 查找元素对应的集合
        public int find(int p){
            while (p != parent[p]){
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        // 查找两个元素是否相连
        public boolean isConnected(int p, int  q){
            return find(p) == find(q);
        }
        // union两个元素
        public void unionElements(int p, int q){
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot){
                return;
            }
            if (sz[pRoot] < sz[qRoot]){
                parent[pRoot] = qRoot;
                sz[qRoot] += sz[pRoot];

            }
            else{
                parent[qRoot] = pRoot;
                sz[pRoot] += sz[qRoot] ;
            }
            count--;
        }
    }
}
