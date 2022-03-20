package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/5/17 10:54
 * @Description:
 */
public class LeetCode_5414 {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("sd");
        set.add("s");
        HashSet<String> set1 = new HashSet<>();
        System.out.println(set.contains(set1));
    }
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> list = new ArrayList<>();
        HashSet<String>[] sets = new HashSet[favoriteCompanies.size()];
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            sets[i] = new HashSet<>();
            for (int j = 0; j < favoriteCompanies.get(i).size(); j++) {
                sets[i].add(favoriteCompanies.get(i).get(j));
            }
        }
        for (int i = 0; i < sets.length ; i++) {
            boolean mark = false;
            for (int j = 0; j < sets.length ; j++) {
                if (i != j){
                    if (jundge(sets[i], sets[j])){
                        mark = true;
                        break;
                    }
                }
            }
            if (mark){
                continue;
            }
            list.add(i);

        }
        return list;
    }
    public boolean jundge(HashSet<String> h1, HashSet<String> h2){
        for (String string: h1) {
            if (!h2.contains(string)){
                return false;
            }
        }
        return true;
    }
}
