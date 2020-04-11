package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/4/6 0:38
 * @Description:
 */
public class LeetCode_46 {
    public static void main(String[] args) {

    }
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new LinkedList<>();
        backtrace(nums,0);
        return res;
    }
    public void backtrace(int[] nums, int index){
        if(index == nums.length){
            LinkedList<Integer> integers = new LinkedList<>();
            for (int num: nums) {
                integers.add(num);
            }
            res.add(integers);
        }
        for (int i = 0; i < nums.length ; i++) {
            swap(nums,i,index);
            backtrace(nums,index+1);
            swap(nums,i,index);
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
