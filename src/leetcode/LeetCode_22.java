package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/4/9 23:33
 * @Description:
 */
public class LeetCode_22 {
    public static void main(String[] args) {
        List<String> list = new LeetCode_22().generateParenthesis(3);
        System.out.println(list.toString());
    }
    public List<String> generateParenthesis(int n) {
        res = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        dfs(n,n,builder);
        return res;
    }
    List<String> res;
    public void dfs(int left, int right, StringBuilder builder){
        if (left==0 && right == 0){
            res.add(builder.toString());
        }
        if (left > 0){
            builder.append("(");
            dfs(left-1,right,builder);
            builder.deleteCharAt(builder.length()-1);
        }
        if (right > left ){
            builder.append(")");
            dfs(left,right-1,builder);
            builder.deleteCharAt(builder.length()-1);
        }
    }
}
