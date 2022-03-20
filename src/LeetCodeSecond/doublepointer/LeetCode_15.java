package LeetCodeSecond.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/6/12 23:19
 * @Description:
 */
public class LeetCode_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 方便去重
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length ; i++) {
            if (i > 0 && nums[i-1] == nums[i] ){
                // 去重
                continue;
            }
            int target = -nums[i];
            if (nums[i] > 0){
                continue;
            }
            int left = i + 1;
            int right = nums.length-1;
            while (left < right){
                int sum =  nums[left] + nums[right];
                if (sum == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(-target);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    // 去重
                    while (left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    left++;
                    while (left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    right--;
                }
                else if (sum > target){
                    right--;
                }else {
                    left++;
                }
            }

        }
        return res;
    }
}
