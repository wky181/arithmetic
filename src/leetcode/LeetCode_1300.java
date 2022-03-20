package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/4/30 23:59
 * @Description:
 */
public class LeetCode_1300 {
    // 二分 + 枚举
    public int findBestValue(int[] arr, int target) {
        int max = arr[0];
        for (int num : arr) {
            max = Math.max(max, num);
        }
        int left = 0;
        int right = max;
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            int sums = getSums(arr, mid);
            // 此处判断是为了取接近阈值的下边界
            if (sums > target){
                right = mid -1;
            }else {
                left = mid;
            }

        }
        // 阈值的上边界为left + 1;
        int top = left + 1;
        int tops = Math.abs(target - getSums(arr,top));
        int ends = Math.abs(target - getSums(arr,left));
        return ends <= tops ? left : top;
    }
    public int  getSums(int[] arr, int num){
        int sums = 0;
        for (int n: arr) {
            if (n > num){
                sums += num;
            }else {
                sums += n;
            }
        }
        return sums;
    }
}
