package swordoffer;

/**
 * @Author: wky233
 * @Date: 2020/8/27 22:49
 * @Description:
 */
public class Offer_10 {
    public int fib(int n) {
        int f1 = 1;
        int f2 = 1;
        int mod = (int)1e9 + 7;
        if(n == 0 || n == 1){
            return n;
        }
        for(int i = 2; i <= n; i++){
            int temp = f2;
            f2 = (f1 + f2) % mod;
            f1 = temp;
        }
        return f1;
    }
}
