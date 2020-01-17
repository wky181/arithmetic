/*
package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

*/
/**
 * @author 武凯焱
 * @date 2019/12/6 22:06
 * @Description:
 *//*

public class LeetCode_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return lists;
        }
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len-3 ; i++) {
            if (nums[i]+nums[i+1]+nums[i+2]+nums[3] > target){
                break;
            }
            if (i > 0 && nums[i-1] == nums[i] ){
                continue;
            }
            int max = nums[i] + nums[len-1]+nums[len-2]+nums[len-3];
            if (max<target){
                continue;
            }
            //第二层循环
            for (int j = i+1; j < len-2 ; j++) {
                //当j的值与前面的值相等时忽略
                if (nums[j] == nums[j-1]){
                    continue;
                }
                */
/*定义指针j指向i+1*//*

                int th=i+1;
                */
/*定义指针h指向数组末尾*//*

                int h=len-1;
                int min= nums[i] + nums[j]+nums[th]+nums[j+2];
                if (min > target){
                    continue;
                }
                if (nums[i] + nums[j]+ nums[h-1]+ nums[h] < target ){
                    continue;
                }
                while (th<h){
                    int curr=nums[i]+nums[j]+nums[th]+nums[h];
                    if(curr==target){lists.add(Arrays.asList(nums[i],nums[j],nums[th],nums[h]));
                        j++;
                }
                    h--;
            }

        }
    }
}*/
