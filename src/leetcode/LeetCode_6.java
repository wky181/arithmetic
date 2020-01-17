package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/1/13 21:29
 * @Description:
 */
public class LeetCode_6 {

    public static void main(String[] args) {
        System.out.println( new LeetCode_6().convert1("PAYPALISHIRING",3));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        int direction = 1;
        int position = 1;
        HashMap<Integer, StringBuilder> hashMap = new HashMap<Integer, StringBuilder>();
        for (int i = 1; i <= numRows; i++) {
            hashMap.put(i,new StringBuilder());
        }
        for (int i = 0; i < s.length(); i++) {
            char str = s.charAt(i);
            if (position == 1) {
                direction = 1;
                put(hashMap,position++,str);
                continue;
            }
            if (position == numRows){
                direction = -1;
                put(hashMap,position--,str);
                continue;
            }
            put(hashMap,position,str);
            position = position + direction;

        }
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= numRows  ; i++) {
           result.append(hashMap.get(i).toString());
        }
        return result.toString();
    }
    public void put(HashMap<Integer,StringBuilder> hashMap,int postion,char string ){
        StringBuilder stringBuilder = hashMap.get(postion);
        hashMap.put(postion,stringBuilder.append(string));
}
    //优化
    public String convert1(String s, int numRows) {
            boolean isDown  = false;
            int currentRow = 0;
            if (numRows == 1){
                return s;
            }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i <  Math.min(numRows,s.length()) ; i++) {
            list.add(new StringBuilder());
        }
        for (int i = 0; i < s.length(); i++) {
            char str  = s.charAt(i);
            StringBuilder stringBuilder = list.get(currentRow);
            stringBuilder.append(str);
            if (currentRow == 0 || currentRow == numRows-1){
                isDown = !isDown;
            }
            currentRow = isDown ? currentRow+1 : currentRow-1;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder stringBuilder: list) {
            result.append(stringBuilder.toString());
        }
        return result.toString();
        }
}
