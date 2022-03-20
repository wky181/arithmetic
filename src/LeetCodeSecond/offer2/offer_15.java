package LeetCodeSecond.offer2;

/**
 * @Author: wky233
 * @Date: 2020/9/10 10:42
 * @Description:
 */
public class offer_15 {
    public int hammingWeight(int n) {
        int count = 0;
       while (n != 0){
           n = n & (n - 1);
           count++;
       }
        return count;
    }
}
