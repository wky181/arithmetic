package LeetCodeSecond.weekrank;

import java.util.*;

/**
 * @Author: wky233
 * @Date: 2020/7/26 10:38
 * @Description:
 */
public class LeetCode_5473 {
    public int minFlips(String target) {
        char[] start = new char[target.length()];
        Arrays.fill(start,'0');
        Queue<String> deque = new LinkedList<>();
        String s = new String(start);
        if (target.equals(s)){
            return 0;
        }
        deque.offer(s);
        return bfs(deque,target);
    }
    HashSet<String> visited = new HashSet<>();
    public int bfs( Queue<String> deque, String taget){
        int count = 0;
        while (!deque.isEmpty()){
          int size = deque.size();
            for (int i = 0; i < size ; i++) {
                String str =  deque.poll();
                if (visited.contains(str)){
                    continue;
                }
                for (int j = 0; j < str.length() ; j++) {
                    String string = replace(str,j);
                    System.out.println(string);
                    if (string.equals(taget)){
                        return count + 1;
                    }else {
                        if (visited.contains(string)){
                            continue;
                        }
                        deque.offer(string);
                    }
                }
                visited.add(str);
            }
            count++;
        }
        return 0;
    }

    private String replace(String str, int i) {
        char[] array = str.toCharArray();
        for (int j = i; j < array.length ; j++) {
            if (array[j] == '1'){
                array[j] = '0';
            }else {
                array[j] = '1';
            }
        }
        return new String(array);
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_5473().minFlips("000101000001010101110010"));
    }
}
