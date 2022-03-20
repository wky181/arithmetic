package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: wky233
 * @Date: 2020/5/3 10:35
 * @Description:
 */
public class LeetCode_5400 {
    public String destCity(List<List<String>> paths) {
        Set<String> from = new HashSet<>(paths.size());
        Set<String> to = new HashSet<>(paths.size());
        for (int i = 0; i < paths.size() ; i++) {
            List<String> list = paths.get(i);
            from.add(list.get(0));
            to.add(list.get(1));
        }
        for (int i = 0; i < paths.size() ; i++) {
            List<String> list = paths.get(i);
            if (!from.contains(list.get(1))){
                return list.get(1);
            }
        }
        return "";
    }
}
