package leetcode.swordoffer;

/**
 * @Author: wky233
 * @Date: 2020/5/9 23:13
 * @Description:
 */
public class LeetCode_16 {
    public double myPow(double x, int n) {
        if (x == 0){
            return 0;
        }
        double res = pow(x, Math.abs(n));
        return n < 0 ? 1 / res : res;
    }
    public double pow(double x, long n) {
        if (n == 0 ){
            return 1;
        }else if (n % 2 != 0){
            return x * pow(x,n-1);
        }else {
            double num = pow(x,n/2);
            return num * num;
        }
    }
}
