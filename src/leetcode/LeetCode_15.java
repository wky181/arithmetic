package leetcode;

import java.util.*;

/**
 * @Author: wky233
 * @Date: 2020/1/31 15:43
 * @Description:
 */
public class LeetCode_15 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new LeetCode_15().threeSum(nums).toString());
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2  ; i++) {
            //  l = i+1 也是为了去重结果

            if ((i == 0 || (nums[i] != nums[i-1])) ){
                int l = i+1, r = nums.length-1; int num = -nums[i];
                if (nums[i] > 0){
                    continue;
                }
                while (l < r){
                    if (nums[l] + nums[r] == num){
                       lists.add(Arrays.asList(nums[l],nums[i],nums[r]));
                       l++;
                       r--;
                       //去重
                       while (l < r && nums[l] == nums[l-1]){
                           l++;
                       }
                       while (l < r && nums[r] == nums[r+1] ){
                           r--;
                       }
                    }
                    else if (nums[l] + nums[r] > num ){
                        r--;
                        while (l < r && nums[r] == nums[r+1] ){
                            r--;
                        }
                    }
                    else {
                        l++;
                        while (l < r && nums[l] == nums[l-1]){
                            l++;
                        }
                    }
                }

            }
        }
        return lists;
    }
}
