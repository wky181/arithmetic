package LeetCodeSecond.binarysearch;

/**
 * @Author: wky233
 * @Date: 2020/6/20 22:56
 * @Description:
 */
public class LeetCode_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length;
        int n = nums2.length;

        // 两个数组分割线左边的所有元素的个数
        int totalLeft = (m + n + 1) / 2;
        // 在nums1区间中找到适当的分界线
        // 使得 nums1[i-1] <= nums2[j] && nums2[j-1] <= nums1[i]
        int left = 0;
        int right = m;
        while (left < right){
            int i = left + (right - left + 1) / 2;
            int j = totalLeft - i;
            if (nums1[i - 1] > nums2[j]){
                right = i-1;
            }else {
                left = i;
            }
        }
        int i = left;
        int j = totalLeft - i;
        int nums1leftMax = i == 0 ? Integer.MAX_VALUE : nums1[i-1];
        return 0;
    }
}
