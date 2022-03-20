package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/5/2 22:33
 * @Description:
 */
public class LeetCode_5384 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        for (int i: candies) {
            max = Math.max(max,i);
        }
        List<Boolean> list = new ArrayList<>(candies.length);
        for (int num : candies) {
            if (num + extraCandies >= max){
                list.add(true);
            }else {
                list.add(false);
            }
        }
        return list;
    }
}
