package leetcode;

/**
 * @author 武凯焱
 * @date 2019/8/17 15:17
 * @Description:
 */
public class 二进制求和 {
    public static void main(String[] args) {
        System.out.println(addBinary("11","1"));
    }
    public static String addBinary(String a, String b) {
        StringBuffer stringBuffer = new StringBuffer();
        int carry = 0, i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {

            if (i >= 0) {
                carry += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                carry += b.charAt(j--) - '0';
            }
            stringBuffer.append(carry % 2);
            carry = carry / 2;
        }
        return stringBuffer.reverse().toString();
    }
}
