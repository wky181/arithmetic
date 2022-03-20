package LeetCodeSecond.offer2;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @Author: wky233
 * @Date: 2020/9/16 9:10
 * @Description:
 */
public class offer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        for (int push: pushed) {
            deque.addLast(push);
            while (!deque.isEmpty() && popped[index] == deque.peekLast()){
                deque.pollLast();
                index++;
            }
        }
        return deque.isEmpty();
    }
}
