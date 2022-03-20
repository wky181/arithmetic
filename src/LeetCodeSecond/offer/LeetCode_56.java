package LeetCodeSecond.offer;

/**
 * @Author: wky233
 * @Date: 2020/6/30 18:53
 * @Description:
 */
public class LeetCode_56 {
    public int[] singleNumbers(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length ; i++) {
            num ^= nums[i];
        }
        int a = 0;
        int b = 0;
        int n = 1;
        while ((n & num ) == 0){
          n  = n << 1;
        }
        //找到num位是1对应的n，因为异或所以1代表了两个数在这个为分别为0或1
        // 可以以它为标准将数组分为两组，一组在这个位为0，一组在这个位为0
        for (int number : nums) {
            if ((n & number) == 1){
                a ^= number;
            }else {
                b ^= number;
            }
        }
        return new int[]{a,b};
    }
}
