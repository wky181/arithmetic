package leetcode;

/**
 * @Author: wky233
 * @Date: 2019/12/19 22:34
 * @Description: 寻找两个有序数组的中位数
 */
public class LeetCode_4 {
    public static void main(String[] args) {
        int[] num1 = {1, 2};
        int[] num2 = {3};
        System.out.println(findMedianSortedArrays1(num1,num2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int[] nums = new int[length];
        int indexA = 0;
        int indexB = 0;
        int index = 0;
        while (indexA < nums1.length && indexB < nums2.length ){
            if (nums1[indexA] < nums2[indexB] ){
                nums[index++] = nums1[indexA++];
            }else {
                nums[index++] = nums2[indexB++];
            }
        }
        while (indexA < nums1.length){
            nums[index++] = nums1[indexA++];
        }
        while (indexB < nums2.length){
            nums[index++] = nums2[indexB++];
        }
  /*      for (int i: nums) {
            System.out.println(i);
        }*/
        if (length == 0){
            return 0;
        }
        if (length%2 == 0){
            return (nums[length/2]+nums[(length/2)-1])/2.0;
        }else {
            return nums[length/2];
        }
    }
    //优化一，减少空间复杂度
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int zhongWei = length/2;
       // current 保存当前循环的结果，在每次循环前将 current 的值赋给 currentPer
        int currentPer = 0;
        int current = 0;
        int indexA = 0;
        int indexB = 0;
        int index = 0;
        while (indexA < nums1.length && indexB < nums2.length ){
            if (nums1[indexA] < nums2[indexB] ){
                current = nums1[indexA];
                if (index == zhongWei) {
                    if (zhongWei % 2 != 0) {
                        return current;
                    }else {
                        return (current+currentPer)/2.0;
                    }
                }
                index++;
                indexA++;
            }else {
                current = nums1[indexB];
                if (index == zhongWei) {
                    if (zhongWei % 2 != 0) {
                        return nums1[indexA];
                    }else {
                        return (current+currentPer)/2.0;
                    }
                }
                index++;
                indexB++;
            }
            currentPer = current;
        }
        while (indexA < nums1.length){
            if (index == zhongWei) {
                if (zhongWei % 2 != 0) {
                    return nums1[indexA];
                }else {
                    return (current+currentPer)/2.0;
                }
            }
           index++;
           indexA++;
        }
        while (indexB < nums2.length){
            if (index == zhongWei) {
                if (zhongWei % 2 != 0) {
                    return nums1[indexA];
                }else {
                    return (current+currentPer)/2.0;
                }
            }
            index++;
            indexB++;
        }
        if (length == 0){
            return 0;
        }
        return 0;
    }
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }
    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k){
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        // 让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) {
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        }
        if (len1 == 0){
                return nums2[start2 + k - 1];
            }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int i = start1 + Math.min(len1,k/2)-1;
        int j = start2 + Math.min(len2,k/2)-1;
        if (nums1[i]  > nums2[j]){
            return getKth(nums1,start1,end1,nums2,j+1,end2,k-(j+1-start2));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }
}
