package LeetCodeSecond.string;

/**
 * @Author: wky233
 * @Date: 2020/9/20 10:08
 * @Description:
 */
public class LeetCode_151 {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        StringBuilder cur = new StringBuilder();
        boolean isFirst = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ( c != ' '){
                cur.append(c);
                isFirst = true;
            }else {
                if (isFirst){
                    cur.append(" ");
                    sb.append(cur);
                    cur = new StringBuilder();
                    isFirst = false;
                }
            }
        }
        sb.append(cur);
        String string = sb.toString();
        String[] strings = string.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            stringBuilder.append(strings[i]).append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
    public String reverseWords1(String s) {
        s = s.trim();
        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length-1; i >= 0 ; i--) {
            if (strings[i].length() == 0){
                continue;
            }
            sb.append(strings[i] + " ");
        }
        return sb.toString().trim();
    }
}
