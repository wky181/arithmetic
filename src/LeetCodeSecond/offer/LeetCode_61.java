package LeetCodeSecond.offer;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author: wky233
 * @Date: 2020/7/2 20:47
 * @Description:
 */
public class LeetCode_61 {
    public boolean isStraight(int[] nums) {
        if (nums == null || nums.length != 5){
            return false;
        }
        Arrays.sort(nums);
        int index = 0;
        int count = 0;
        while (nums[index] == 0){
            count++;
            index++;
        }
        // System.out.println(count);
        for (int i = index; i < nums.length-1 ; i++) {
            if(nums[i] == nums[i+1]){
                return false;
            }
            else if (nums[i] + 1 != nums[i+1]){
                int need = nums[i+1] - nums[i] - 1;
                //  System.out.println(count + " "+ need);
                if (count >= need){
                    count -= need;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isStraight1(int[] nums) {
        if (nums == null || nums.length != 5){
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        int min = 14;
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] == 0){
                continue;
            }
            if (set.contains(nums[i])){
                return false;
            }
            set.add(nums[i]);
            max = Math.max(max,nums[i]);
            min = Math.min(min, nums[i]);
        }
        return max - min <= 4;
    }
}
