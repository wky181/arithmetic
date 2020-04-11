package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/4/6 14:16
 * @Description:
 */
public class LeetCode_77 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_77().combine(4,2));
    }

    List<List<Integer>> lists;

    public List<List<Integer>> combine(int n, int k) {
        lists = new LinkedList<>();
        backtrace(n,1,k,new LinkedList<>());
        return lists;
    }
    // 还有 k-path.size() 坑位,所以 i到n中至少要有  k-path.size() 个元素
    public void backtrace(int n, int index, int k, LinkedList<Integer> path) {
        if (k == path.size()) {
            lists.add(new LinkedList<>(path));
            return;
        }
        if (n < 0 || index > n){
            return;
        }
        for (int i = index; i <= n - (k - path.size())+1; i++) {
            path.addLast(i);
            backtrace(n, i + 1, k, path);
            path.removeLast();
        }
    }
}
