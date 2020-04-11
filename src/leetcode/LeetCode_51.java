package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/4/1 12:57
 * @Description:
 */
public class LeetCode_51 {
    public static void main(String[] args) {

    }
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new LinkedList<List<String>>();
        char[][] chars = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(chars[i],'.');
        }
        backtrace(chars,0);
        return res;
    }
    public void backtrace(char[][] chars, int row){
        if (row == chars.length ){
            List<String> list = charArrayToString(chars);
            res.add(list);
            return;
        }
        for (int i = 0; i < chars[row].length ; i++) {
            if(!isvalid(chars,row,i)){
                continue;
            }
            chars[row][i] = 'Q';
            backtrace(chars,row+1);
            chars[row][i] = '.';
        }
    }
    public List<String> charArrayToString(char[][] array ){
        List<String> list = new LinkedList<>();
        for (char[] ch: array) {
            list.add(String.valueOf(ch));
        }
        return list;
    }
    public boolean isvalid(char[][] arrays ,int r, int c){
        //检查当前列
        for (char[] ch : arrays) {
            if (ch[c] == 'Q'){
                return false;
            }
        }
        // 检查左上角
        for (int i = r-1, j = c-1;  i >=0 && j >=0  ; i-- , j--) {
            if (arrays[i][j] == 'Q'){
                return false;
            }
        }
        // 检查右上角
        for (int i = r-1, j = c+1; i>=0 &&  j< arrays[0].length ; i--, j++) {
            if (arrays[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
}
