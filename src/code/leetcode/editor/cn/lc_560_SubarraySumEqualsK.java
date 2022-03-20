//给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
//
// 示例 1 : 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
// 
//
// 说明 : 
//
// 
// 数组的长度为 [1, 20,000]。 
// 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。 
// 
// Related Topics 数组 哈希表
package code.leetcode.editor.cn;

import java.util.HashMap;

public class lc_560_SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new lc_560_SubarraySumEqualsK().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int[] perNums = new int[nums.length + 1];
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                perNums[i + 1] = perNums[i] + nums[i];
                map.put(perNums[i + 1], map.getOrDefault(perNums[i + 1], 0) + 1);
            }
            int count = 0;
            for (int i = 1; i <= nums.length; i++) {
                /*for (int j = 0; j < i ; j++) {
                    int num = perNums[i] - perNums[j];
                    if (num == k){
                        count++;
                    }
                }*/
                if (map.containsKey(perNums[i] - k)) {
                    count += map.get(perNums[i] - k);
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}