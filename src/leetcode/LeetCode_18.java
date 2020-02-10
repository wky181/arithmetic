package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_18 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2  ; i++) {
            if ((i == 0 || (nums[i] != nums[i-1])) ){
                //  l = i+1 也是为了去重结果
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
