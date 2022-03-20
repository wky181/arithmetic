package Interview.jingdong;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/4/18 14:14
 * @Description:
 */
public class Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[] A = new int[m];
            int[] B = new int[n];
            for (int i = 0; i < m; i++) {
                A[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                B[i] = sc.nextInt();
            }
            slove(A, B);
            System.out.println();
        }
    }

    public static   void slove(int[] A, int[] B) {
        HashSet<Integer> hashSet = new HashSet<>(A.length + B.length);
        for (int a : A) {
            hashSet.add(a);
        }
        for (int b : B) {
            hashSet.add(b);
        }
        int[] res = new int[hashSet.size()];
        int index = 0;
        for (Integer integer : hashSet) {
            res[index++] = integer;
        }
        Arrays.sort(res);
        for (int num : res)  {
            System.out.print(num+" ");
        }
    }
}
