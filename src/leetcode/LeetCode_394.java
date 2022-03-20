package leetcode;

import javax.print.DocFlavor;
import java.util.Calendar;
import java.util.LinkedList;

/**
 * @Author: wky233
 * @Date: 2020/5/28 20:29
 * @Description:
 */
public class LeetCode_394 {

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        char[] array = s.toCharArray();
        LinkedList<Integer> numList = new LinkedList<>();
        LinkedList<String> resList = new LinkedList<>();
        int num = 0;
        for (int i = 0; i < array.length ; i++) {
            if (array[i] == '['){
                numList.addLast(num);
                resList.addLast(res.toString());
                num = 0;
                res = new StringBuilder();
            }
            else if (array[i] == ']'){
                Integer integer = numList.removeLast();
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < integer ; j++) {
                    temp.append(res);
                }
                res = new StringBuilder(resList.removeLast() + temp);
            }
            else if (Character.isDigit(array[i])){
                num = 10 * num + array[i] - '0';
            }else {
                res.append(array[i]);
            }
        }
        return res.toString();
    }

}
