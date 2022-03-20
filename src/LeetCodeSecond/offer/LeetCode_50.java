package LeetCodeSecond.offer;

/**
 * @Author: wky233
 * @Date: 2020/6/27 16:51
 * @Description:
 */
public class LeetCode_50 {
    public char firstUniqChar(String s) {
        int[] count = new int[26];
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length ; i++) {
            count[array[i] - 'a']++;
        }
        for (int i = 0; i < array.length; i++) {
            if (count[array[i] - 'a'] == 1){
                return array[i];
            }
        }
        return ' ';
    }
}
