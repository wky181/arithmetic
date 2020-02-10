package leetcode;

import bluebridgecup_course.class_03.Util;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author: wky233
 * @Date: 2020/2/6 22:16
 * @Description:
 */
public class LeetCode_219 {
    public static void main(String[] args) {
        int[] arr = {1,0,1,1};
        Util.print(arr);
        System.out.println(new LeetCode_219().containsNearbyDuplicate(arr, 1));

    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int l = 0;
        int r = 0;
        HashSet<Integer> windows = new HashSet<>();
        while (r < nums.length) {
            if (r - l <= k) {
                if (windows.contains(nums[r])) {
                    return true;
                } else {
                    windows.add(nums[r]);
                }
            }
            if(r - l == k){
                windows.remove(nums[l]);
                l++;
            }
            r++;
        }
        return false;
    }
}