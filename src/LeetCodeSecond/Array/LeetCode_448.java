package LeetCodeSecond.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/7/14 23:42
 * @Description:
 */
public class LeetCode_448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] != i+1){
                while (nums[i] != i+1 && nums[i] != nums[nums[i]-1]){
                    swap(nums,i,nums[i] - 1);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] != i+1){
                res.add(i+1);
            }
        }
        return res;
    }
    private void swap(int[] nums, int a, int b){
        if (nums[a] == nums[b]){
            return;
        }
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }
}
