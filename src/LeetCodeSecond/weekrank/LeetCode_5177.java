package LeetCodeSecond.weekrank;

import java.util.HashMap;

/**
 * @Author: wky233
 * @Date: 2020/7/11 22:32
 * @Description:
 */
public class LeetCode_5177 {
    public String reformatDate(String date) {
        HashMap<String,Integer> day = new HashMap<>();
        day.put("1st",1);
        day.put("2nd",2);
        day.put("3rd",3);
       // String[] pattern = new String[]{"st","nd",}
        for (int i = 4; i <= 20 ; i++) {
            day.put(i + "th",i);
        }
        for (int i = 20; i <= 30 ; i++) {
            day.put(i + "nd",i);
        }
        day.put("31st",31);
        String[] str  = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        HashMap<String,Integer> mouth = new HashMap<>();
        for (int i = 1; i <= 12 ; i++) {
            mouth.put(str[i-1],i);
        }
        String[] array = date.split(" ");
        int d = day.get(array[0]);
        int m = mouth.get(array[1]);
        String days = d >= 10  ? ""+ d : 0 +""+ d;
        String mouths = m >= 10 ? "" + m : 0 + "" +m;
        return array[2] + "-" + mouths + "-" + days;
    }
}
