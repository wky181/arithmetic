package LeetCodeSecond.sort;

/**
 * @Author: wky233
 * @Date: 2020/6/6 21:05
 * @Description:
 */
public class CountingSort {
    // 计数排序，a是数组，n是数组大小。假设数组中存储的都是非负整数。
    public void countingSort(int[] a, int n) {
        if (n <= 1) return;
        // 确定最大数据范围
        int max = a[0];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, a[i]);
        }
        int[] c = new int[max];
        // 统计次数 并且只是为了统计次数
        for (int i = 0; i < n; i++) {
            c[a[i]]++;
        }
        // 累积求和确定大于等于该元素的有几个
        for (int i = 1; i <= max ; i++) {
            c[i] = c[i-1] + c[i];
        }
        int[] r = new int[n];
        // 倒序遍历a
        for (int i = n; i >= 0 ; i--) {
            int index = c[a[i]] - 1;
            r[index] = a[i];
            // 计数减一
            c[a[i]]--;
        }
        for (int i = 0; i < n ; i++) {
            a[i] = r[i];
        }
    }

}
