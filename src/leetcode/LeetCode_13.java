package leetcode;

import java.util.HashMap;

/**
 * @Author: wky233
 * @Date: 2020/4/8 22:53
 * @Description:
 */
public class LeetCode_13 {
    public static void main(String[] args) {

    }
    public int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>(8);
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] array = s.toCharArray();
        int ans = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            int curNum =  map.get(array[i]);
            if ( i > 0 && array[i] != array[i - 1] && curNum > map.get(array[i - 1])){
                ans += curNum - map.get(array[i - 1]);
                i--;
            }else {
                ans += curNum;
            }
        }
        return ans;
    }
}
