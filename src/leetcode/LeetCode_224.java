package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: wky233
 * @Date: 2020/4/22 16:53
 * @Description:
 */
public class LeetCode_224 {
    public static void main(String[] args) {
        String string = "(1+(4+5+2)-3)+(6+8)";
        Deque<Character> deque = new ArrayDeque<>(string.length());
        for (Character ch: string.toCharArray()) {
            deque.offer(ch);
        }
        double v = new LeetCode_224().sloveIt(deque);
        System.out.println(v);
    }
    public double calculate(String s) {
        char[] array = s.toCharArray();
        Deque<Double> deque = new ArrayDeque<>();
        char sign = '+';
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (Character.isDigit(c)){
                sum = sum * 10 + (array[i] - '0');
            }
            if ((!Character.isDigit(c) && c  != ' ') || i == array.length-1){
                switch (sign){
                    case '+':
                        deque.addLast(sum);
                        break;
                    case '-':
                        deque.addLast(-sum);
                        break;
                    case '*':
                        deque.addLast(deque.pollLast() * sum);
                        break;
                    case '/':
                        deque.addLast(deque.pollLast() / sum);
                    default:
                        break;
                }
                sign = c;
                sum = 0;
            }
        }
        double ans = 0;
        while (!deque.isEmpty()){
            ans += deque.poll();
        }
        return ans;
    }
    public double slove(Deque<Character> deque) {
        Deque<Double> array = new ArrayDeque<>();
        char sign = '+';
        double sum = 0;
        while (deque.size() > 0) {
            char c = deque.poll();
            if (Character.isDigit(c)) {
                sum = sum * 10 + (c - '0');
            }
            //将括号也看做是一个数字
            if (c == '(') {
                sum = slove(deque);
            }
            if ((!Character.isDigit(c) && c != ' ') || deque.size() == 0) {
                switch (sign) {
                    case '+':
                        array.addLast(sum);
                        break;
                    case '-':
                        array.addLast(-sum);
                        break;
                    case '*':
                        array.addLast(array.pollLast() * sum);
                        break;
                    case '/':
                        array.addLast(array.pollLast() / sum);

                    default:
                        break;
                }
                sign = c;
                sum = 0;
            }

            if (sign == ')'){
                break;
            }
        }
        double ans = 0;
        while (!array.isEmpty()){
            ans += array.poll();

        }
        return ans;
    }
    public int sloveIt(Deque<Character> deque) {
        Deque<Integer> array = new ArrayDeque<>();
        char sign = '+';
        int sum = 0;
        while (deque.size() > 0) {
            char c = deque.poll();
            if (Character.isDigit(c)) {
                sum = sum * 10 + (c - '0');
            }
            //将括号也看做是一个数字
            if (c == '(') {
                sum = sloveIt(deque);
            }
            if ((!Character.isDigit(c) && c != ' ') || deque.size() == 0) {
                switch (sign) {
                    case '+':
                        array.addLast(sum);
                        break;
                    case '-':
                        array.addLast(-sum);
                        break;
                    default:
                        break;
                }
                sign = c;
                sum = 0;
            }
            if (sign == ')'){
                break;
            }
        }
        Integer ans = 0;
        while (!array.isEmpty()){
            ans += array.poll();
        }
        return ans;
    }
}
