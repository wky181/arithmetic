package LeetCodeSecond.classic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/9/21 21:41
 * @Description:
 */
public class LeetCode_6 {
    public String convert(String s, int numRows) {
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int flag = -1;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder builder = list.get(index);
            builder.append(s.charAt(i));
            if (index == 0 || index == numRows - 1){
                flag = -flag;
            }
            index += flag;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder stringBuilder: list) {
            sb.append(stringBuilder);
        }
        return sb.toString();
    }
}
