package LeetCodeSecond.bfs;



import java.util.*;

/**
 * @Author: wky233
 * @Date: 2020/7/10 23:07
 * @Description:
 */
public class LeetCode_301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        set.add(s);
        while (!set.isEmpty()){
            for (String str: set) {
                if (isVaild(str)){
                    ans.add(str);
                }
            }
            if (ans.size() > 0){
                return ans;
            }
            HashSet<String> nextSet = new HashSet<>();
            for (String s1: set) {
                for (int i = 0; i < s1.length() ; i++) {
                    if(s1.charAt(i) == '(' || s1.charAt(i) == ')'){
                        nextSet.add(s1.substring(0,i) + s1.substring(i+1));
                    }
                }
            }
            set = nextSet;
        }
        return new ArrayList<>();
    }
    public boolean isVaild(String s){
        int cnts = 0;
        for (int i = 0; i < s.length() ; i++) {
            if (s.charAt(i) == '('){
                cnts++;
            }
            else if (s.charAt(i) == ')'){
                cnts--;
                if(cnts < 0){
                    return false;
                }
            }

        }
        return cnts == 0;
    }
}
