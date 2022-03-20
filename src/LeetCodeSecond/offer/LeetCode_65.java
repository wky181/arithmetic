package LeetCodeSecond.offer;

/**
 * @Author: wky233
 * @Date: 2020/7/2 21:27
 * @Description:
 */
public class LeetCode_65 {
    public int add(int a, int b) {
        if ((a & b) == 0){
            return a | b;
        }else {
            return add(a ^ b, (a & b) << 1);
        }
    }
    public int add1(int a, int b) {
        while ((a & b) != 0){
            // 进位
            int c = (a & b) << 1;
            // 不进位和
            a = a ^ b;
            b = c;
        }
        return a | b;
    }
}
