package leetcode;

import java.util.Arrays;

/**
 * @author 武凯焱
 * @date 2019/7/20 15:09
 * @Description:
 */
public class 三角形的最大周长 {
    public static void main(String[] args) {
        int[] a = {3,6,2,3};
        System.out.println(largestPerimeter(a));
    }
    public static int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int n = A.length-1;
        int a = n-2;
        int b= n-1;
        int c = n;
        while (a>=0){
            if (A[a]+A[b]>A[c]){
                return A[a]+A[b]+A[c];
            }
            a--;
            b--;
            c--;
        }
        return 0;
    }
}
