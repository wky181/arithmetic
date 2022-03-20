package LeetCodeSecond.classic;

/**
 * @Author: wky233
 * @Date: 2020/9/21 17:12
 * @Description:
 */
public class LeetCode_43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")){
            return "0";
        }
        String res = "0";
        for (int i = num2.length() - 1; i >= 0 ; i--) {
            StringBuilder temp = new StringBuilder();
            int carry = 0;
            // 补 0
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                temp.append("0");
            }
            int n2 = num2.charAt(i) - '0';
            for (int j = num1.length() - 1; j >= 0 ||carry != 0; j--) {
                int n1 = j < 0 ? 0 : num1.charAt(j) - '0';
                int product = (n1 * n2 + carry) % 10;
                carry = (n1 * n2 + carry) / 10;
                temp.append(product);
            }
            res =  addString(res,temp.reverse().toString());
        }
        return res;
    }

    private String addString(String nums1, String nums2) {
        StringBuilder builder  = new StringBuilder();
        int index1 = nums1.length() - 1;
        int index2 = nums2.length() - 1;
        int carry = 0;
        while (index1 >= 0 || index2 >= 0){
            int a = index1 < 0 ? 0 : nums1.charAt(index1--) - '0';
            int b = index2 < 0 ? 0 : nums2.charAt(index2--) - '0';
            int product = (a + b + carry) % 10;
            builder.append(product);
            carry = (a + b + carry) / 10;
        }
        if (carry != 0){
            builder.append(carry);
        }
        return builder.reverse().toString();
    }
}
