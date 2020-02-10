package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author: wky233
 * @Date: 2020/1/30 17:23
 * @Description:
 */
public class LeetCode_290 {
    public static void main(String[] args) {
        boolean boo = new LeetCode_290().wordPattern("abba","dog dog dog dog");
        System.out.println(boo);
    }
    public boolean wordPattern(String pattern, String str) {
        //匹配map,让模式串的字符与单词相匹配。
        HashMap<Character,String> matchmap = new HashMap<>();
        //储存出现过并且也匹配过的单词
        HashSet<String> appear = new HashSet<>();
        String[] words = str.split(" ");
        if (pattern.length() != words.length){
            return false;
        }
        for (int i = 0; i < pattern.length() ; i++) {
            char ch = pattern.charAt(i);
            String string = matchmap.get(ch);
            //string为空，说明ch尚且无单词匹配，看相同位置str中的单词是否也未匹配就行了。
            if (string == null && appear.contains(words[i])){
                return false;
            }
            else if (string == null ){
                matchmap.put(ch,words[i]);
                appear.add(words[i]);
            }else {
                if (!string.equals(words[i])){
                    return false;
                }
            }
        }
        return true;
    }
}
