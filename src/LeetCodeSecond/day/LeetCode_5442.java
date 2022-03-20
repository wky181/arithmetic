package LeetCodeSecond.day;

import java.util.*;

/**
 * @Author: wky233
 * @Date: 2020/6/21 11:09
 * @Description:
 */
public class LeetCode_5442 {
    public int[] avoidFlood(int[] rains) {
        // 用来缓存已经填过水的坑
        HashMap<Integer,Integer> map = new HashMap<>();
        // 主要用来存抽水下标
        List<Integer> list = new LinkedList<>();
        int[] res = new int[rains.length];
        for (int i = 0; i < rains.length ; i++) {
            int num = rains[i];
            if (num == 0){
               list.add(i);
            }else {
                // 如果缓存中有,说明此时需要先抽水
                if (map.containsKey(num)){
                    if (list.isEmpty()){
                        return new int[0];
                    }else {
                        // 获取第一次填水的坑的下标
                        int m = map.get(num);
                        int index = -1;
                        int j = 0;
                        // 从头到尾开始找合适的抽水天
                        for (; j < list.size(); j++) {
                            // 只有抽水天大于前面填水天数才可以抽水成功, 否则跳过
                            if (list.get(j) > m){
                                index = list.get(j);
                                break;
                            }
                        }
                        // 没有符合条件的直接返回
                        if (j == list.size()){
                            return new int[0];
                        }else {
                            res[index] = num;
                            //用过之后移除抽水天
                            list.remove(j);
                            // 更新现在num的下标这点很关键 可以看成移除了原来的,现在的变成第一个放入map的
                            map.put(num,i);
                            res[i] = -1;
                        }
                    }
                }else {
                    // 没有直接填水
                    map.put(num,i);
                    res[i] = -1;
                }
            }
        }
       for (int num : list){
           res[num] = 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] rains = {1,0,2,3,0,1,2};
        new LeetCode_5442().avoidFlood(rains);
    }
}
