package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @Author: wky233
 * @Date: 2020/3/30 23:34
 * @Description:
 */
public class LeetCode_mian62 {
    public static void main(String[] args) {

    }
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            arrayList.add(i);
        }
        int index = 0;
        while (n > 1){
            index = index+m-1;
            arrayList.remove((index)%n);
            n--;
        }
        return arrayList.get(0);
    }
    public int lastRemaining1(int n, int m) {
       int ans = 0;
        for (int i = 2; i <=n  ; i++) {
            ans = (ans+m)%i;
        }
        return ans;
    }
}
