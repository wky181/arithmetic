package leetcode;

import sun.plugin.javascript.navig.Link;

import java.awt.*;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author: wky233
 * @Date: 2020/3/10 16:31
 * @Description:
 */
public class MaxQueue {
    public static void main(String[] args) {

    }

    LinkedList<Integer> link1;
    LinkedList<Integer> link2;

    public MaxQueue() {
        link1 = new LinkedList<>();
        //双端队列：获取最大值
        link2 = new LinkedList<>();
    }

    public int max_value() {
        return link2.isEmpty() ? -1 : link2.peek();
    }

    public void push_back(int value) {
       while (!link2.isEmpty() && value > link2.pollLast()){
           link2.pollLast();
       }
       link2.offerLast(value);
    }

    public int pop_front() {

        if (!link2.isEmpty() && link2.peek().equals(link1.peek())){
            link2.poll();
        }
        return link1.isEmpty() ? -1 : link1.poll();
    }
}
