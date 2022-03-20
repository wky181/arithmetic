package LeetCodeSecond.offer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

/**
 * @Author: wky233
 * @Date: 2020/6/20 10:05
 * @Description:
 */
public class LeetCode_31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length){
            return false;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        HashSet<Integer> path = new HashSet<>();
        int index = 0;
        for (int i = 0; i < popped.length ; i++) {
            if (path.contains(popped[i])){
                if (deque.isEmpty() || deque.peekLast() != popped[i]){
                    return false;
                }else {
                    deque.pollLast();
                }
            }else {
                while (index < pushed.length && pushed[index] != popped[i] ){
                    deque.addLast(pushed[index]);
                    path.add(pushed[index++]);
                }
                index++;
            }
        }
        return deque.isEmpty();
    }
    public boolean validateStackSequences1(int[] pushed, int[] popped) {
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        for (int push: pushed) {
            deque.addLast(push);
            while (!deque.isEmpty() && deque.peekLast() == popped[index]){
                index++;
                deque.pollLast();
            }
        }
        return deque.isEmpty();
    }
}
