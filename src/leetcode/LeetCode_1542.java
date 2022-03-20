package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/5/8 13:49
 * @Description:
 */
public class LeetCode_1542 {
    public static void main(String[] args) {
        int i = add(2, 3);
        System.out.println(i);
    }
    public static   int add(int a, int b) {
        if ((a & b ) == 0){
            return a | b;
        }
        return add(a ^ b , (a & b) << 1);
    }
}
