package LeetCodeSecond.offer;

/**
 * @Author: wky233
 * @Date: 2020/6/15 21:03
 * @Description:
 */
public class LeetCode_15 {
    public static void main(String[] args) {
        System.out.println(hammingWeight(10));
    }
    public static int hammingWeight(int n) {
        int k = 1;
        int count = 0;
        for (int i = 0; i < 32 ; i++) {
            System.out.println(k << i);
            if ((n & (k << i)) == k << i){
                count++;
            }
        }
        return count;
    }
}
