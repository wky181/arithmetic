package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/5/10 10:34
 * @Description:
 */
public class LeetCode_5404 {
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        int index = 0;
        for (int i = 1; i <= n ; i++) {
            if (i == target[index]){
                list.add("Push");
            }
            list.add("Push");
            list.add("Pop");
        }
        return list;
    }
}
