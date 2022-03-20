package LeetCodeSecond.day;

/**
 * @Author: wky233
 * @Date: 2020/6/2 21:06
 * @Description:
 */
public class offer_64 {
    int res = 0;
    public int sumNums(int n) {
        boolean x = n > 1 && sumNums(n-1) > 0;
        res += n;
        return res;
    }
}
