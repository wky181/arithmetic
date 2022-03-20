package LeetCodeSecond.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/6/13 0:17
 * @Description:
 */
public class LeetCode_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length ; i++) {
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i+1; j < nums.length ; j++) {
                // 只要第一个小于零就可以了
               /* if (nums[j] > 0){
                    continue;
                }*/
                // 保证第二个数不重复
                if (j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int left = j+1;
                int right = nums.length-1;
                while (left  < right){
                    int sum = nums[i] + nums[j] + nums[left]  + nums[right];
                    if (sum == target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
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
        }
        return res;
    }
}
