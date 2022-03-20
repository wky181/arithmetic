package LeetCodeSecond.offer;

import com.sun.prism.PresentableState;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/6/18 0:12
 * @Description:
 */
public class LeetCode_17 {
    List<String> result;
    public int[] printNumbers(int n) {
        String[] numbers = {"0","1","2","3","4","5","6","7","8","9"};
        result = new ArrayList((int)Math.pow(10,n) - 1);
        StringBuilder sb = new StringBuilder();
        dfs(sb,numbers,n);
        for (String s : result) {
            System.out.println(s);
        }
        int[] res = new int[result.size()];
        for (int i = 1; i < result.size(); i++) {
            res[i] = Integer.parseInt(result.get(i));
        }
        return res;
    }

    public void dfs(StringBuilder sb,String[] numbers,int n){
        if (sb.length() == n){
            result.add(removeZero(sb.toString()));
            return;
        }
        for (String number : numbers) {
            sb.append(number);
            dfs(sb, numbers, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public String removeZero(String str){
        int i = 0;
        for ( ; i < str.length()-1 ; i++) {
            if (str.charAt(i) != '0'){
                break;
            }
        }
        return str.substring(i);
    }

}
