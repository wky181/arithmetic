package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/4/12 10:33
 * @Description:
 */
public class LeetCode_5380 {
    public static void main(String[] args) {
        String[] words = {"leetcode","et","code"};
        List<String> list = new LeetCode_5380().stringMatching(words);
        System.out.println(list);
    }
    public List<String> stringMatching(String[] words) {

        List<String> list = new LinkedList<>();
        if (words.length == 0){
            return list;
        }
        boolean[] vistied = new boolean[words.length];
        for (int i = 0; i < words.length ; i++) {
            for (int j = 0; j < words.length ; j++) {
                if (!vistied[j] && i != j &&  words[i].contains(words[j]) ){
                    list.add(words[j]);
                    vistied[j] = true;
                }
            }
        }
        return list;
    }
}
