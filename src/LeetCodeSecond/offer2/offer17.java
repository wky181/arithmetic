package LeetCodeSecond.offer2;

import java.util.ArrayList;

/**
 * @Author: wky233
 * @Date: 2020/9/11 22:38
 * @Description:
 */
public class offer17 {
    ArrayList<String> res;
    public int[] printNumbers(int n) {
        String[] numbers = {"0","1","2","3","4","5","6","7","8","9"};
        res = new ArrayList((int) Math.pow(10,n));
        StringBuilder sb = new StringBuilder();
        dfs(numbers,sb,n);
        int[] ints = new int[numbers.length-1];
        for (int i = 1; i < res.size() ; i++) {
            ints[i - 1] = Integer.parseInt(res.get(i));
        }
        return ints;
    }
    public void dfs(String[] numbers, StringBuilder path, int n){
        if (path.length() == n){
            String s = path.toString();
            res.add(remove(s));
        }
        for (String number: numbers) {
            path.append(number);
            dfs(numbers, path, n);
            path.deleteCharAt(path.length()-1);
        }
    }
    public String remove(String s){
        int i = 0;
        for (; i < s.length(); i++) {
            if (s.charAt(i) != '0'){
                break;
            }
        }
        return s.substring(i);
    }
}
