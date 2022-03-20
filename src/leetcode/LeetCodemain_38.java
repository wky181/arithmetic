package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/5/9 10:40
 * @Description:
 */
public class LeetCodemain_38 {
    public static void main(String[] args) {

    }
    List<String> list = new ArrayList<>();
    public String[] permutation(String s) {
        boolean[] used = new boolean[s.length()];
        StringBuilder stringBuilder = new StringBuilder();
        char[] arrays = s.toCharArray();
        // 先进行排序，为了后面进行去重
        Arrays.sort(arrays);
        backTrance1(arrays,stringBuilder,used);
        return list.toArray(new String[0]);
    }
    // 递归回溯 没考虑字符串会有重复字母的可能性
    public void backTrance(char[] arrays, int index) {
        if (index == arrays.length){
            list.add(new String(arrays));
        }
        // 通过index确定每一位的可能值
        for (int i = index; i < arrays.length; i++) {
            swap(i,index,arrays);
            backTrance(arrays,index+1);
            swap(i,index,arrays);
        }
    }
    public void swap(int i, int j, char[] arrays){
        char temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }

    public void backTrance1(char[] arrays,StringBuilder path, boolean[] used) {
        if (path.length() == arrays.length){
            list.add(path.toString());
            return;
        }
        for (int i = 0; i < arrays.length ; i++) {
            if (used[i]) {
                continue;
            }
            // 剪枝 减去重复的结果
            if ( i > 0 && arrays[i] == arrays[i-1] && !used[i-1]){
                continue;
            }
            path.append(arrays[i]);
            used[i] = true;
            backTrance1(arrays,path,used);
            used[i] = false;
            path.deleteCharAt(path.length()-1);
        }
    }
}
