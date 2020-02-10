package leetcode;

import java.util.HashMap;

/**
 * @Author: wky233
 * @Date: 2020/1/31 14:58
 * @Description:
 */
public class LeetCode_1 {
    /**
     * 时间空间复杂度都为o(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            int numbers = target- nums[i];
            //通过这样做就可以使hashMap.put(nums[i],i),出现相同nums[i]值，覆盖i，不会影响正确结果
            //而且一次遍历就可得得出结果
            if (hashMap.containsKey(numbers)){
                res = new int[] {hashMap.get(numbers),i};
                return res;
            }else {
                hashMap.put(nums[i],i);
            }
        }
        return res;
    }
}
