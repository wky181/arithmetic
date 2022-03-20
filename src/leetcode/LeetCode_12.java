package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/5/12 12:59
 * @Description:
 */
public class LeetCode_12 {
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5 ,4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC","L", "XL", "X", "IX", "V","IV", "I"};
        int i = 0;
        StringBuilder builder = new StringBuilder();
        while (num > 0){
            if (num > nums[i]) {
                num -= nums[i];
                builder.append(strs[i]);
            }else {
                i++;
            }
        }
        return builder.toString();

    }
}
