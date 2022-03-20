package LeetCodeSecond.offer;

/**
 * @Author: wky233
 * @Date: 2020/6/26 10:46
 * @Description:
 */
public class LeetCode_43 {
    public int countDigitOne(int n) {
        // 高位的值
        int height = n / 10;
        // 低位的值
        int low = 0;
        // 当前的位的单位
        int digit = 1;
        // 当前位的值
        int cur = n % 10;
        int res = 0;
        while (low != n){
            // cur < 1 说明低位的变化不会影响当前位的1的个数，只有高位会影响
            if (cur < 1){
                res += height * digit;
                // cur == 1 说明低位的变化会影响当前位的1的个数，低位影响的总数就是0 ~ low = low +1
            }else if (cur == 1){
                res += height * digit + 1 + low;
                // cur >= 1 说明低位的变化会影响当前位的1的个数，低位影响的总数就是1 * digit
            }else {
                res += (height + 1) * digit;
            }
            System.out.println(low);
            low = cur * digit + low;
            digit *= 10;
            cur = height % 10;
            height /=  10;

        }
        return res;
    }
}
