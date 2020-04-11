package leetcode;

import java.util.*;

/**
 * @Author: wky233
 * @Date: 2020/4/3 13:36
 * @Description:
 */
public class LeetCode_131 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_131().partition("aaab").toString());
    }
    List<List<String>> lists;
    public List<List<String>> partition(String s) {
        lists = new LinkedList<>();
        Deque<String> path = new LinkedList<>();
        backtrance(0,path,s);
        return lists;
    }
    public void backtrance(int index, Deque<String> path , String s) {
        if (index == s.length()){
            lists.add(new ArrayList<>(path));
        }
        for (int i = index; i < s.length() ; i++) {
            if (checkPalindrome(s,index,i)){
                path.addLast(s.substring(index,i+1));
                backtrance(i+1,path,s);
                path.removeLast();
            }
        }
    }
    private boolean checkPalindrome(String str, int left, int right) {
            while (left < right){
                if (str.charAt(left) != str.charAt(right)){
                    return false;
                }
                left++;
                right--;
            }
            return true;
    }
}
