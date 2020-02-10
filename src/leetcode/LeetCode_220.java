package leetcode;

import java.util.TreeSet;

/**
 * @Author: wky233
 * @Date: 2020/2/7 22:58
 * @Description:
 */
public class LeetCode_220 {
    public static void main(String[] args) {
        int[] arr = {0,2147483647};
        boolean s =   new LeetCode_220().containsNearbyAlmostDuplicate(arr,1,2147483647);
        System.out.println(s);
  /*      1
        2147483647}*/
    }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int l = 0;
        int r = 0;
        TreeSet<Long> windows = new TreeSet<>();
        while (r < nums.length) {

                Long number = windows.ceiling((long)nums[r] - t);

            if (r - l <= k) {

                if (number!= null && number <= (long)nums[r] + t) {
                    return true;
                }
                    else {
                    windows.add((long)nums[r]);
                }
            }
            if(r - l == k){
                windows.remove((long)nums[l]);
                l++;
            }
            r++;
        }
        return false;
    }
}
