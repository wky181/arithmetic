package LeetCodeSecond.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: wky233
 * @Date: 2020/5/31 22:41
 * @Description: LeetCode_901
 */
public class StockSpanner {
    // 单调递减栈+同步栈
    Deque<Integer> prices;
    //用来记录prices中元素对应num
    Deque<Integer> caches;
    public StockSpanner() {
        prices = new ArrayDeque<>();
        caches = new ArrayDeque<>();
    }

    public int next(int price) {
        int num = 1;
        while (!prices.isEmpty() && price >= prices.peekLast()){
            prices.pollLast();
            num += caches.pollLast();
        }
        prices.addLast(price);
        caches.addLast(num);
        return num;
    }
}
