package leetcode;
import	java.net.Socket;

/**
 * @author 武凯焱
 * @date 2019/10/26 15:27
 * @Description: 字符串相加
 */
public class LeetCode_415 {
    public static void main(String[] args) {
        System.out.println(addStrings("9","1"));
  /*      for (int i = 0; i <255 ; i++) {
            System.out.println(i+" "+(char)i);
            
        }*/

    }
    public static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int l1  = num1.length();
        int l2  = num2.length();
        StringBuilder sb = new StringBuilder();
        if (l1>l2){
            for (int i = 0; i <l1-l2 ; i++) {
                sb.append('0');
            }
            num2 = sb.toString()+num2;
        }else if (l1<l2) {
            for (int i = 0; i <l2-l1 ; i++) {
                sb.append('0');
            }
            num1 = sb.toString()+num1;
            }
            int jinwei = 0;
        for (int i = num1.length()-1; i >=0; i--) {
           int num =  num1.charAt(i)-48+(int)num2.charAt(i)-48+jinwei;
           result.append(num%10);
           jinwei = num/10;
        }
        if (jinwei==1){
            result.append(1);
        }
        return result.reverse().toString();
    }
}
