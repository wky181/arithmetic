package leetcode;

import java.util.*;

/**
 * @Author: wky233
 * @Date: 2020/4/2 23:09
 * @Description:
 */
public class LeetCode_17 {
    public static void main(String[] args) {
        LinkedList<String> list1 = (LinkedList<String>) new LeetCode_17().letterCombinations("23");
        System.out.println(list1.size());
        for (String s: list1) {
            System.out.println(s);
        }
    }
    char[][] numchar = {
            {' '},
            {},
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'},
    };
    public LinkedList<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return new LinkedList<>();
        }
        LinkedList<String> strings = new LinkedList<>();
        char[] chars = digits.toCharArray();
        slove(chars,0,"",strings);
        return strings;
    }
    public void slove(char[] digits, int index ,  String res , LinkedList<String> list){
        if (index == digits.length){
            list.add(res);
            return;
        }
       char ch = digits[index];
        for (int i = 0; i < numchar[ch - '0'].length ; i++) {
            slove(digits,index+1,res+numchar[ch - '0'][i],list);
        }
    }
}
