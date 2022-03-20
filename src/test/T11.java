package test;

import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/9/13 20:14
 * @Description:
 */
public class T11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int n1 = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            UF uf = new UF(n1 + 1);
            for (int j = 0; j < m ; j++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                int value = sc.nextInt();
                if (value <= k){
                    uf.unionElements(from,to);
                }
            }
            if (uf.getCount() == 1){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }
    private static class UF {
        int count = 0;
        private int[] parent;
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
            count = size - 1;
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
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
