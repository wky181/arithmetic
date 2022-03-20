package data_structure.graph;


import java.util.*;

/**
 * @Author: wky233
 * @Date: 2020/7/8 21:01
 * @Description:
 */
public class WaterPuzzle {
    private int end = -1;
    private int[] pre;
    public WaterPuzzle(int x, int y, int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        pre = new int[100];
        Arrays.fill(pre,-1);
        pre[0] = 0;
        while (!queue.isEmpty()){
            Integer top = queue.poll();
            int a = top / 10;
            int b = top % 10;
            ArrayList<Integer> nexts = new ArrayList<>();
            int next;
            // 将a桶倒满 b不动
            next =  x * 10 + b;
            nexts.add(next);
            // 将b桶倒满 a不动
            next =  a * 10 + y;
            nexts.add(next);
            // 将a桶水倒掉
            next = b;
            nexts.add(next);
            // 将b桶水倒掉
            next = a * 10;
            nexts.add(next);
            // 将a桶中的水倒入b
            // 求出b还有几升水可倒入
            int num = y - b;
            // 比较一下保证逻辑正确
            num = Math.min(a, num);
            next = (a - num) * 10 + b + num;
            nexts.add(next);
            // 将b桶中的水倒入a
            // 求出a还有几升水可倒入
            num = x - a;
            num = Math.min(num, b);
            next = (a + num) * 10 + b - num;
            nexts.add(next);
            for (int w : nexts) {
                if (pre[w] == -1){
                  //  System.out.println(w);
                    queue.offer(w);
                    pre[w] = top;
                   // System.out.println(top);
                    if (w / 10 == target || w % 10 == target ){
                        end = w;
                        return;
                    }
                }
            }
        }
    }
    public Iterable<Integer> path(){
        ArrayList<Integer> res = new ArrayList<>();
        if (end == -1){
            return res;
        }
        int cur = end;
        while (cur != 0){
           // System.out.println(cur);
            res.add(cur);
            cur = pre[cur];
        }
        res.add(0);
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        WaterPuzzle waterPuzzle = new WaterPuzzle(4,1,3);
        for (int number : waterPuzzle.path()) {
            System.out.println(String.format("x:%d y:%d ",number/10, number %10));
        }
    }
}
