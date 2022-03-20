package LeetCodeSecond.queue;

/**
 * @Author: wky233
 * @Date: 2020/6/4 13:17
 * @Description:
 */
public class CircularQueue {
    private String[] items;
    private int n = 0;
    // head tail分别指向队首和队列的下标
    private int head;
    private int tail;

    // 申请数组空间
    public CircularQueue(int n) {
        this.items = new String[n];
        this.n = n;
    }
    // 入队
    public boolean enqueue(String item){
        if ((tail+1) % n == head){
            // 队列满了
            return false;
        }
        items[tail] = item;
        tail = (tail+1) % n;
        return true;
    }
    // 出队
    public String dequeue(){
        // 队空
        if (tail == head){
            return null;
        }
        String str = items[head];
        head = (head + 1) % n;
        return str;
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(10);
        for (int i = 0; i < 11 ; i++) {
            queue.enqueue(i+"");
        }
        String dequeue = queue.dequeue();
        System.out.println(dequeue);
    }

}
