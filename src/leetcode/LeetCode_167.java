package leetcode;

import bluebridgecup_course.class_03.Util;

/**
 * @Author: wky233
 * @Date: 2020/1/25 17:28
 * @Description:
 */
public class LeetCode_167 {
    public static void main(String[] args) {
        int[] nums = {2,3,4,6};
        int[] res = new LeetCode_167().twoSum1(nums,6);
        Util.print(res);
    }
    //利用二分法来求，时间复杂度为n*logn
    public int[] twoSum(int[] numbers, int target) {
        int[] nums = new int[2];
        for (int i = 0; i < numbers.length ; i++) {
            int value = target - numbers[i];
            int index =  binarySearch(0,numbers.length-1,numbers,value,i);
            if (index != -1 ){
                nums[0] = i;
                nums[1] = index;
                break;
            }
        }
        return nums;
    }
    public int binarySearch(int l,int r,int[] nums ,int value,int index){
        //防止整形溢出
        int mid = l + (r-l)/2;
        while (l <= r){

            if(nums[mid] == value && index!=mid){
                return mid;
            }else if (nums[mid] > value){
               return   binarySearch(l,mid-1,nums,value,index);
            }else {
               return  binarySearch(mid+1,r,nums,value,index);
            }
        }
        return -1;
    }
    /**
     * 优化,双指针碰撞，时间复杂度降为O(n)
     */
    public int[] twoSum1(int[] numbers, int target){
        int[] res = new int[2];
        int l = 0;
        int r = numbers.length-1;
        int value;
        while (l < r){
            value = numbers[l] + numbers[r];
            if (value == target){
                res[0] = l;
                res[1] = r;
                break;
            }else if (value > target){
                r--;
            }else {
                l++;
            }
        }
        return res;
    }
}
