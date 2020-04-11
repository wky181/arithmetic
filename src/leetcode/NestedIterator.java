package leetcode;

import java.util.*;

/**
 * @Author: wky233
 * @Date: 2020/2/19 22:54
 * @Description: java 队列 + 递归
 */
public class NestedIterator implements Iterator<Integer> {
    Queue<Integer> queue = new LinkedList<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        add(nestedList);
    }
    private void add (List<NestedInteger> nestedList){
        for (NestedInteger ne: nestedList) {
            if (ne.isInteger()){
                queue.offer(ne.getInteger());
            }else {
                add(ne.getList());
            }

        }
    }

    @Override
    public boolean hasNext() {
        return queue.isEmpty();
    }

    @Override
    public Integer next() {
        return queue.poll();
    }
}
