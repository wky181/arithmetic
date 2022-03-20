package LeetCodeSecond.Array;

/**
 * @Author: wky233
 * @Date: 2020/8/3 20:28
 * @Description:
 */
public class LeetCode_415 {
    public String addStrings(String num1, String num2) {
        int indexA = num1.length()-1;
        int indexB = num2.length()-1;
        int carry = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (indexA >=0 || indexB >= 0){
            int a = indexA >= 0 ? num1.charAt(indexA) - '0' : 0;
            int b = indexB >= 0 ? num2.charAt(indexB) - '0' : 0;
            int num = a + b + carry;
            carry = num >= 10 ? 1 : 0;
            stringBuilder.insert(0,num % 10);
            indexA--;
            indexB--;
        }
        return stringBuilder.toString();
    }
}
