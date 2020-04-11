package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
//[0:03, 0:05, 0:06, 0:09, 0:10, 0:12, 0:17, 0:18, 0:20, 0:24, 0:33, 0:34, 0:36, 0:40, 0:48,  1:02, 1:04, 1:08, 1:16, 1:32, 2:01, 2:04, 2:08, 2:16, 2:32, 3:00, 4:01, 4:02, 4:08, 4:16, 4:32, 5:00, 6:00, 8:01, 8:02, 8:04, 8:16, 8:32, 9:00,10:00]
//["0:03","0:05","0:06","0:09","0:10","0:12","0:17","0:18","0:20","0:24","0:33","0:34","0:36","0:40","0:48","1:01","1:02","1:04","1:08","1:16","1:32","2:01","2:02","2:04","2:08","2:16","2:32","3:00","4:01","4:02","4:04","4:08","4:16","4:32","5:00","6:00","8:01","8:02","8:04","8:08","8:16","8:32","9:00","10:00"]
/**
 * @Author: wky233
 * @Date: 2020/4/10 15:49
 * @Description:
 */
public class LeetCode_401 {
    List<String> lists;
    boolean[] useHour ;
    boolean[] useMin;
    public static void main(String[] args) {
        List<String> list = new LeetCode_401().readBinaryWatch(2);
        Collections.sort(list);
        System.out.println(list.toString());
    }

    public List<String> readBinaryWatch(int num) {
        lists = new LinkedList<>();
        if (num < 0){
            return lists;
        }
            int[] hour = {1, 2, 4, 8};
        int[] minus = {1, 2, 4, 8, 16, 32};
        useHour = new boolean[hour.length];
        useMin = new boolean[minus.length];
        dfs(num, 0, 0, hour, minus);
        return lists;
    }

    public void dfs(int num, int hour, int min, int[] hours, int[] minus) {
        if (num == 0) {
            String minu = "" + min;
            if (min < 10) {
                minu = "0" + minu;
            }
            lists.add(hour + ":" + minu);
            return;
        }
        for (int i = 0; i < minus.length; i++) {
            if (!useMin[i]) {
                if (min + minus[i] > 59) {
                    break;
                }
                useMin[i] = true;
                dfs(num - 1, hour, min + minus[i], hours, minus);
                useMin[i] = false;
            }
        }
        for (int i = 0; i < hours.length; i++) {
            if (!useHour[i]) {
                if (hour + hours[i] > 11) {
                    break;
                }
                useHour[i] = true;
                dfs(num - 1, hour + hours[i], min, hours, minus);
                useHour[i] = false;
            }
        }
    }
}
