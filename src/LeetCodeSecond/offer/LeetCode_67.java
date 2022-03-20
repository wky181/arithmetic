package LeetCodeSecond.offer;

/**
 * @Author: wky233
 * @Date: 2020/7/2 23:42
 * @Description:
 */
public class LeetCode_67 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
    public int strToInt(String str) {
        if (str == null || str.length() == 0){
            return 0;
        }
        int start = 0;
        int end = str.length()-1;
        while (start < str.length() && str.charAt(start) == ' '){
            start++;
        }
        while (end > 0 && str.charAt(end) == ' '){
            end--;
        }
        if(start > end){
            return 0;
        }
        char c = str.charAt(start);
        int num = 0;
        int  sign = 1;
        if (c == '-'){
            sign = -1;
            start++;
        }else if (c == '+') {
            start++;
        }else if (c < '0' || c > '9'){
            return 0;
        }
        int max  = Integer.MAX_VALUE / 10 ;
        for (int i = start; i <= end ; i++) {
            int number = str.charAt(i) - '0';
            if (number < 0 || number > 9){
                break;
            }
            if (num > max || (num == max && number > 7)){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }else {
                num = num * 10 + number;
            }
        }
        return sign * num;
    }
}
