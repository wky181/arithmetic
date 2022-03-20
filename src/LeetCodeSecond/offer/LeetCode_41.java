package LeetCodeSecond.offer;

import bluebridgecup_course.class_03.最小可用id;
import javafx.scene.layout.Priority;

import java.util.PriorityQueue;

/**
 * @Author: wky233
 * @Date: 2020/7/3 12:12
 * @Description: 优先队列
 */
public class LeetCode_41 {
    /** initialize your data structure here. */
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    int size;
    public LeetCode_41() {
        // 小顶堆 存储的是 2/n 个较大元素
        minHeap = new PriorityQueue<>();
        // 大顶堆 存储的是 2/n 个较小元素
        maxHeap = new PriorityQueue<>((x, y) -> y.compareTo(x));
        size = 0;
    }

    public void addNum(int num) {
        size++;
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
        // 当前数量为偶数时需要将大顶堆的堆顶元素弹出加入小顶堆
        // 使两个堆的元素数量保持一致
        if ((size & 1) == 0){
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if ((size & 1) == 1){
            return (double)maxHeap.peek();
        }else {
            return (maxHeap.peek() + minHeap.peek()) / 2;
        }
    }
}
