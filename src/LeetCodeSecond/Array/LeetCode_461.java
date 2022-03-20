package LeetCodeSecond.Array;

/**
 * @Author: wky233
 * @Date: 2020/6/1 14:42
 * @Description:
 */
public class LeetCode_461 {
    public int hammingDistance(int x, int y) {
        int ans = x ^ y;
        int count = 0;
        for (int i = 0; i < 31 ; i++) {
            if (((ans >> i) & 1) == 1 ){
                count++;
            }
        }
        return count;
    }
}
