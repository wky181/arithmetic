package leetcode;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: wky233
 * @Date: 2020/4/19 10:32
 * @Description:
 */
public class LeetCode_5388 {
    public String reformat(String s) {
        char[] array = s.toCharArray();
        Deque<Character> chars = new ArrayDeque<>();
        Deque<Character> numbers = new ArrayDeque<>();
        for (int i = 0; i < array.length ; i++) {
            if (Character.isDigit(array[i])){
                numbers.offer(array[i]);
            }else {
                chars.offer(array[i]);
            }
        }
        int cha = Math.abs(numbers.size() - chars.size());
        if (cha > 1){
            return "";
        }else {
            if (numbers.size() > chars.size()){
                StringBuilder stringBuilder = new StringBuilder();
                while (!chars.isEmpty()){
                    stringBuilder.append(numbers.poll());
                    stringBuilder.append(chars.poll());
                }
                stringBuilder.append(numbers.poll());
                return stringBuilder.toString();
            }else {
                StringBuilder stringBuilder = new StringBuilder();
                while (!numbers.isEmpty()){
                    stringBuilder.append(chars.poll());
                    stringBuilder.append(numbers.poll());

                }
                return numbers.size() == chars.size() ? stringBuilder.toString() : stringBuilder.append(chars.poll()).toString();
            }
        }
    }
}
