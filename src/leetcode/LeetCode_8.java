package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/5/10 10:15
 * @Description:
 */
public class LeetCode_8 {
    public int myAtoi(String str) {
        char[] arrays = str.toCharArray();
        int index = 0;
        // 先去掉前导的空格
        while (index < arrays.length && arrays[index] == ' '){
            index++;
        }
        boolean mark = false;
        if (index == arrays.length){
            return 0;
        }
        if ( arrays[index] == '-'){
            mark = true;
            index++;
        }else if (arrays[index] == '+'){
            index++;
            // 如果第一个不是数字或正负号直接返回0，已经不符合要求了
        }else if (Character.isDigit(arrays[index])){
            return 0;
        }
        int res = 0;
        for (int i = index; i < arrays.length ; i++) {
            if (!Character.isDigit(arrays[i])){
                break;
            }
            int number = arrays[i] - '0';
            // 处理整型溢出问题,分两步,一步是res * 10会溢出, 还有一步就是+number
            if (res * 10 > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && number > 7) ){
                return mark ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + number;
        }
        return mark ? -res : res;
    }
}
