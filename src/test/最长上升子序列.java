package test;

/**
 * @author 武凯焱
 * @date 2019/3/8 17:17
 * @Description:
 */
import java.util.*;


/* 22 55 33 44 11 77 66*/

public class 最长上升子序列 {
    public static final int N = (int)1e5 + 9;
    public static int n = 0;
    public static int[] f = new int[N];
    public static int[] a = new int[N];

    public static int find(int l, int r, int x) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (f[mid] < x) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
    public static int lis() {
        int len = 0;
        for (int i = 0; i < n; i++) {
            int k = find(0,i,a[i]);
            f[k] = a[i];
            if (k == len) {
                len++;
            }
        }
        return len;
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = cin.nextInt();
        }
        System.out.println(lis());
    }
}
