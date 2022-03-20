package LeetCodeSecond.offer;

/**
 * @Author: wky233
 * @Date: 2020/6/30 19:43
 * @Description:
 */
public class LeetCode_56_1 {
    public int singleNumber(int[] nums) {
        int cnt = 0;
        int res = 0;
        for (int i = 0; i < 32 ; i++) {
            int n = 1 << i;
            for (int num : nums) {
                if ((num & n) == n){
                    cnt++;
                }
            }
            if ((cnt % 3) == 1){
                res |= n;
            }
        }
        return res;
    }
}
