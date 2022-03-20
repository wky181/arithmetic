package Interview.yuanfudao;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: wky233
 * @Date: 2020/8/8 22:39
 * @Description:
 */
public class T4 {
        public boolean canConvertString(String s, String t, int k) {
            if (s.length() != t.length()){
                return false;
            }
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < s.length() ; i++) {
                if (s.charAt(i) != t.charAt(i)){
                    int i1 = count(s.charAt(i), t.charAt(i));
                    while (set.contains(i1) && i1 < k){
                        i1 += 26;
                    }
                    if (i1 <= k){
                        set.add(i1);
                    }else {
                        return false;
                    }
                }
            }
            return true;
        }
    public int count(char from, char to){
        int count = 0;
        while (from != to){
            if (from == 'z'){
                from = 'a';
            }else {
                from++;
            }
            count++;
        }
        return count;
    }
}
