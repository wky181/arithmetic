package LeetCodeSecond.offer;

/**
 * @Author: wky233
 * @Date: 2020/7/2 14:16
 * @Description:
 */
public class LeetCode_60 {
    public double[] twoSum(int n) {
        double pre[] = {1/6d, 1/6d, 1/6d, 1/6d, 1/6d, 1/6d};
        for (int i = 2; i <= n ; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < pre.length ; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += pre[j]/6;
                }
            }
            pre = tmp;
        }
        return pre;
    }
}
