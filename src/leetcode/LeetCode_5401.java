package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/5/3 10:41
 * @Description:
 */
public class LeetCode_5401 {
    public boolean kLengthApart(int[] nums, int k) {
       int count = 0;
       boolean isfindOne = false;
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] == 1){
                if (isfindOne){
                    if (count < k){
                        return false;
                    }
                    count = 0;
                }else {
                    isfindOne = true;
                }
            }else {
                if (isfindOne){
                    count++;
                }
            }
        }
        return true;
    }
}
