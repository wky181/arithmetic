package leetcode;

import bluebridgecup_course.class_03.Util;

/**
 * @Author: wky233
 * @Date: 2020/1/22 19:49
 * @Description:
 */
public class LeetCode_88 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        new LeetCode_88().merge(nums1,3,nums2,3);
        Util.print(nums1);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m + n];
        int p = 0;
        int v = 0;
        int i = 0;
        while (p < m &&  v < n){
            if (nums1[p] < nums2[v]){
                nums[i++] = nums1[p++];
            }else {
                nums[i++] = nums2[v++];
            }
        }
        if (p == m){
            for (int j = i; j < nums.length ; j++) {
                nums[j] = nums2[v++];
            }
        }else {
            for (int j = i; j < nums.length ; j++) {
                nums[j] = nums1[p++];
            }
        }
        for (int j = 0; j < nums.length; j++) {
            nums1[j] = nums[j];
        }
    }
    /**
     * 算法优化，空间复杂度降为O(1)，时间复杂度仍为O(m+n),从后往前排
     */

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
            int p = m-1;
            int v = n-1;
            int i = nums1.length-1;
            while (p >= 0 &&  v >= 0){
                if (nums1[p] > nums2[v]){
                    nums1[i--] = nums1[p--];
                }else {
                    nums1[i--] = nums2[v--];
                }
            }
            if (p < 0){
                for (int j = i; j >=0 ; j--) {
                    nums1[j] = nums2[v--];
                }
            }else {
                for (int j = i; j >=0 ; j--) {
                    nums1[j] = nums1[p--];
                }
            }

    }
}
