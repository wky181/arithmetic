package leetcode;

import java.util.*;

/**
 * @author 武凯焱
 * @date 2019/7/28 8:22
 * @Description:
 */
public class MagicDictionary {
    public static void main(String[] args) {
        MagicDictionary magicDictionary  = new MagicDictionary();
        String[] strings = {};
        buildDict(strings);
        System.out.println(search("he22o"));
    }
   static   HashMap<Integer, List<String>> hashMap;

    public MagicDictionary() {
        hashMap = new HashMap<Integer, List<String>>();
    }

    /**
     * Build a dictionary through a list of words
     */
    public static void buildDict(String[] dict) {
        for (String str:dict){
            Integer length  =  str.length();
            List<String> list = hashMap.get(length);
            if (list!= null){
                list.add(str);
            }else {
                list = new ArrayList<>();
                list.add(str);
                hashMap.put(length,list);
            }
        }
    }

    /**
     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
     */
    public static boolean search(String word) {
        if (word==null || word.equals("")){
            return false;
        }
        Integer integer = word.length();
        List<String> list = hashMap.get(integer);
        if (list==null){
            return false;
        }
        for (String str : list
             ) {
            int mark = 0;
            for (int i = 0; i <str.length() ; i++) {
                if (word.charAt(i)!=str.charAt(i)){
                    mark++;
                }
            }
            if (mark==1){
                return true ;

            }
        }
        return false;
    }
}
