package LeetCodeSecond.SegmentTree;

/**
 * @Author: wky233
 * @Date: 2020/6/13 17:16
 * @Description:
 */
public interface Merger<E> {
    E merge(E a, E b);
}
