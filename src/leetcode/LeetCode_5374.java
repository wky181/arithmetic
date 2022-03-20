package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/4/18 23:18
 * @Description:
 */
public class LeetCode_5374 {
    public static void main(String[] args) {
        String string = new LeetCode_5374().getHappyString(2, 7);
        System.out.println(string);
    }
    public String getHappyString(int n, int k) {
        list = new ArrayList<>();
        String[] select = {"a","b","c"};
        backtrace(n,select,new StringBuilder());
        return list.size() >= k ? list.get(k-1) : "";
    }
    List<String> list;
    public void backtrace (int n,String[] select,StringBuilder s) {
        if (s.length() == n){
            list.add(s.toString());
            return;
        }
        String last = s.length() > 0 ? s.substring(s.length()-1) : "";
        for (int i = 0; i < select.length; i++) {
            if (!last.equals(select[i])){
                s.append(select[i]);
                backtrace(n,select,s);
                s.deleteCharAt(s.length()-1);
            }
        }
    }
}
