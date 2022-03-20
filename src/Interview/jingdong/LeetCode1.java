package Interview.jingdong;

/**
 * @Author: wky233
 * @Date: 2020/4/18 15:03
 * @Description:
 */
public class LeetCode1 {
    public int minCount(int[] coins) {
        int res = 0;
        for (int i = 0; i < coins.length ; i++) {
            int count = coins[i] / 2 + coins[i] % 2;
            res += count;
        }
        return res;
    }
}
