package swordoffer;

/**
 * @Author: wky233
 * @Date: 2020/8/27 23:09
 * @Description:
 */
public class Offer_10_1 {
    public int numWays(int n) {
        int mod = (int)1e9 + 7;
        int w0 = 1;
        int w1 = 1;
        if(n == 0 || n == 1){
            return 1;
        }
        for(int i = 2; i <= n; i++){
            int temp = w1;
            w1 = (w0 + w1) % mod;
            w0 = temp;
        }
        return w1;
    }
}
