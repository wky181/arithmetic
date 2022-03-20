package test;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @Author: wky233
 * @Date: 2020/8/13 20:00
 * @Description:
 */
public class blibli3 {
    public int GetCoinCount (int N) {
        // write code here
        int n = 1024 - N;
        Deque<Integer> deque = new LinkedList<>();
        deque.add(n);
        HashSet<Integer> mark = new HashSet<>();
        int count = 0;
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size ; i++) {
                Integer poll = deque.poll();
                int a = poll - 64;
                int b = poll - 16;
                int c = poll - 4;
                int d = poll - 1;

                if (a == 0 || b == 0 || c == 0 || d == 0){
                    return count + 1;
                }else if (a > 0 && !mark.contains(a)){
                    deque.add(a);
                    mark.add(a);
                }
                if (b > 0  && !mark.contains(b)){
                    deque.add(b);
                    mark.add(b);
                }
                if (c > 0 && !mark.contains(c)){
                    deque.add(c);
                    mark.add(c);
                }
                if (d > 0 && !mark.contains(d)){
                    deque.add(d);
                    mark.add(d);
                }
            }
            count ++;
        }
        return 0;
    }
}
