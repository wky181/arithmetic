package LeetCodeSecond.graph;

import java.util.*;

/**
 * @Author: wky233
 * @Date: 2020/7/8 19:13
 * @Description:
 */
public class LeetCode_752 {
    public int openLock(String[] deadends, String target) {
        if (deadends == null || deadends.length == 0){
            return 0;
        }
        HashSet<String> deadendSet  = new HashSet<>(deadends.length);
        HashMap<String,Integer>  distance = new HashMap<>();
        for (String deadend : deadends) {
            deadendSet.add(deadend);
        }
        if (deadendSet.contains("0000") || deadendSet.contains(target)){
            return -1;
        }
        if (target.equals("0000")){
            return 0;
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("0000");
        distance.put("0000",0);
        while (!queue.isEmpty()){
            String v = queue.poll();
            ArrayList<String> nexts = new ArrayList<>();
            // 获取下一个要访问的点
            char[] array = v.toCharArray();
            for (int i = 0; i < 4 ; i++) {
                char c = array[i];
                // 向下 + 1
                array[i] = (char) (((c - '0') + 1) % 10 + '0');
                nexts.add(new String(array));
                // 向上 - 1
                array[i] = (char) (((c - '0') + 9) % 10 + '0');
                nexts.add(new String(array));
                array[i] = c;
            }
            for (String w: nexts) {
                if (!deadendSet.contains(w) && !distance.containsKey(w)){
                    queue.offer(w);
                    int dis = distance.get(v);
                    if (w.equals(target)){
                        return dis + 1;
                    }
                    distance.put(w,dis+1);
                }
            }
        }
        return  -1;
    }
}
