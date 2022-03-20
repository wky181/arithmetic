package LeetCodeSecond.weekrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: wky233
 * @Date: 2020/6/29 17:55
 * @Description:
 */
public class LeetCode_1497 {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int item : arr) {
            int nums = (item % k + k) % k;
            Integer count = hashMap.getOrDefault(nums, 0);
            hashMap.put(nums, count + 1);
        }
        int count = hashMap.getOrDefault(0,0);
        if (count % 2 != 0){
            return false;
        }
        for (int i = 1; i < k ; i++) {
            Integer integer = hashMap.getOrDefault(i,0);
            Integer aDefault = hashMap.getOrDefault(k - 1, 0);
            if (!integer.equals(aDefault)){
                return false;
            }
        }
        return true;
    }
}
