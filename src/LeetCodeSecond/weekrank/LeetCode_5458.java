package LeetCodeSecond.weekrank;

import java.util.HashSet;

/**
 * @Author: wky233
 * @Date: 2020/7/25 23:07
 * @Description:
 */
public class LeetCode_5458 {
    public int numSplits(String s) {
        char[] array = s.toCharArray();
        int[] counts = new int[26];
        HashSet<Character> set = new HashSet<>();
        HashSet<Character> left = new HashSet<>();
        for (int i = 0; i < s.length() ; i++) {
            counts[array[i] - 'a']++;
            set.add(array[i]);
        }
        int res = 0;
        int right = set.size();
        for (int i = 0; i < array.length ; i++) {
            counts[array[i] - 'a']--;
            if (counts[array[i] - 'a'] == 0){
                right--;
            }
            if (!left.contains(array[i])){
                left.add(array[i]);
            }
            if (left.size() == right){
                res++;
            }
        }
        return res;
    }
    public int count(int[] counts){
        int count = 0;
        for (int i = 0; i < counts.length ; i++) {
            if (counts[i] != 0){
                count++;
            }
        }
        return count;
    }
}
