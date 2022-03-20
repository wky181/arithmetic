package LeetCodeSecond.offer;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Author: wky233
 * @Date: 2020/6/27 15:34
 * @Description:
 */
public class LeetCode_49 {
    // dp dp[i] = Math.max(dp[p2] * 2, dp[p3] * 3 ,dp[p5] * 5)
    //dp[p2] * 2 表示当前以*2结尾的最小丑数
    public int nthUglyNumber(int n) {
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int [] res = new int[n];
        // 丑数 即 2^x + 3^y + 5^z
        // 赋初始值
        res[0] = 1;
        for (int i = 1; i < n ; i++) {
            res[i] = Math.min(res[p2] * 2, Math.min(res[p3] * 3 , res[p5] * 5));
            if (res[i] == res[p2] * 2){
                // 说明以res[p2]为最小基数*2已经被选中，需要把基数更新为下一个丑数
                // 继续寻找下一个*2的最小丑数
                p2++;
            }
            if (res[i] == res[p3] * 3){
                p3++;
            }
            if (res[i] == res[p5] * 5){
                p5++;
            }
        }
        return res[n-1];
    }
    // 优先级队列
    public int nthUglyNumber1(int n) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        //初始化，放进堆和set中
        long[] nums =new long[]{2,3,5};
        long num = 1;
        queue.offer(num);
        set.add(num);
        for (int i = 0; i < n ; i++) {
            num = queue.poll();
                for (int j = 0; j < nums.length ; j++) {
                    if (!set.contains(num * nums[j])){
                        set.add(num * nums[j]);
                        queue.offer(num * nums[j]);
                }
            }
        }
        return (int) num;
    }

}
