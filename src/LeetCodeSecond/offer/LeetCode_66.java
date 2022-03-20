package LeetCodeSecond.offer;

/**
 * @Author: wky233
 * @Date: 2020/7/2 22:48
 * @Description:
 */
public class LeetCode_66 {
    public int[] constructArr(int[] a) {
        if (a == null || a.length < 2) {
            return a;
        }
        int[] res = new int[a.length];
        int[] first = new int[a.length];
        int[] end = new int[a.length];
        first[0] = 1;
        for (int i = 1; i < a.length; i++) {
            first[i] = first[i-1] * a[i - 1];
        }
        end[a.length - 1] = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            end[i] = end[i + 1] * a[i + 1];
        }
        for (int i = 0; i < a.length; i++) {
            res[i] = first[i] * end[i];
        }
        return res;
    }
    public int[] constructArr1(int[] a) {
        if (a == null || a.length < 2) {
            return a;
        }
        int[] res = new int[a.length];
        res[0] = 1;
        // 前缀积
        for (int i = 1; i < a.length; i++) {
           res[i] = res[i-1] * a[i - 1];
        }
        // 后缀积
        int temp = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            temp = temp * a[i + 1];
            // 前缀积乘以后缀积
            res[i] *= temp;
        }
        return res;
    }
}
