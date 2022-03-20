package LeetCodeSecond.string;

/**
 * @Author: wky233
 * @Date: 2020/7/3 20:18
 * @Description:
 */
public class LeetCode_6 {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows < 2){
            return s;
        }
        StringBuilder[] res = new StringBuilder[numRows];
        for (int i = 0; i < numRows ; i++) {
            res[i] = new StringBuilder();
        }
        char[] array = s.toCharArray();
        int mark = 0;
        boolean isUp = false;
        for (int i = 0; i < s.length() ; i++) {
            if (!isUp){
                res[mark++].append(array[i]);
                if (mark == numRows - 1){
                    isUp = true;
                }
            }else {
                res[mark--].append(array[i]);
                if (mark == 0){
                    isUp = false;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb: res) {
            result.append(sb);
        }
        return result.toString();
    }
}
