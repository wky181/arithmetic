package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/1/28 19:16
 * @Description:
 */
public class LeetCode_209 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(new LeetCode_209().minSubArrayLen1(11,nums));
    }

    /**
     * 暴力破解，时间复杂度O(n3)
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int minLength = nums.length+1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length ; j++) {
                int value = sums(nums,i,j);
                if (value >= s){
                    minLength = Math.min((j-i)+1,minLength);
                }
            }
        }
        return minLength == nums.length+1 ? 0 : minLength;
    }
    public int sums(int[] nums,int l,int r){
        int res = 0;
        for (int i = l; i <= r ; i++) {
            res += nums[i];
        }
        return res;
    }

    /**
     * 采用滑动窗口解法，时间复杂度O(n)
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen1(int s, int[] nums) {
        int l = 0;
        int r = -1;
        int sum = 0;
        int minLength = nums.length+1;
        while (l < nums.length){
            if (r+1 < nums.length && sum < s){
                sum += nums[++r];
            }else {
                sum -= nums[l++];
            }
            if (sum >= s){
                minLength = Math.min(minLength,r-l+1);
            }
        }
        return minLength == nums.length+1 ? 0 : minLength;
    }
}
