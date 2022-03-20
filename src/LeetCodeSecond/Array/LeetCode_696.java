package LeetCodeSecond.Array;

import java.util.ArrayList;

/**
 * @Author: wky233
 * @Date: 2020/8/10 23:48
 * @Description:
 */
public class LeetCode_696 {
    public int countBinarySubstrings(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int per = 0;
        int len = s.length();
        while (per < len){
            int count = 0;
            char c = s.charAt(per);
            while (per < len && s.charAt(per) == c){
                count++;
                per++;
            }
            arrayList.add(count);
        }
        int res = 0;
        for (int i = 1; i < arrayList.size(); i++) {
            res += Math.min(arrayList.get(i-1),arrayList.get(i));
        }
        return res;
    }
}
