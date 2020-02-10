package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/2/4 21:35
 * @Description:
 */
public class LeetCode_49 {
    /**
     * 时间复杂度O(NKlogK)，其中 NN 是 strs 的长度，
     * 而 KK 是 strs 中字符串的最大长度。当我们遍历每个字符串时，
     * 外部循环具有的复杂度为 O(N)O(N)。然后，我们在 O(K \log K)O(KlogK) 的时间内
     * 对每个字符串排序。
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<List<String>>();
        HashMap<String, List<String>> listHashMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String string = new String(chars);
            if (listHashMap.containsKey(string)) {
                listHashMap.get(string).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                listHashMap.put(string, list);
                lists.add(list);
            }
        }
        return lists;
    }

    /**
     * 利用计数排序，统计原数组每个字符串的字符出现次数，比如abc 111 就表示为1#1#1#0#0#...
     * cba 也是1#1#1#0#0#....
     * abd 1#1#0#1#....
     * 长度都为26，不再使用快排 时间复杂度O(NK)，适合大数据量
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> lists = new ArrayList<List<String>>();
        HashMap<String, List<String>> listHashMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int[] tongji = new int[26];
            char[] chars = strs[i].toCharArray();
            Arrays.fill(tongji, 0);
            for (char ch : chars) {
                tongji[ch - 'a']++;
            }
            StringBuilder string = new StringBuilder();
            for (int j = 0; j < tongji.length; j++) {
                string.append(tongji[j] + "#");
            }
            String str = string.toString();
            if (listHashMap.containsKey(str)) {
                listHashMap.get(str).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                listHashMap.put(str, list);
                lists.add(list);
            }
        }
        return lists;
    }


}
