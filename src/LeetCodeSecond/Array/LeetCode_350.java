package LeetCodeSecond.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/7/13 10:30
 * @Description:
 */
public class LeetCode_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int indexA = 0;
        int indexB = 0;
        List<Integer> list = new ArrayList<>(Math.min(nums1.length,nums2.length));
        while (indexA < nums1.length && indexB < nums2.length){
            if (nums1[indexA] == nums1[indexB]){
                list.add(nums1[indexA]);
                indexA++;
                indexB++;
            }
            else if (nums1[indexA] > nums2[indexB]){
                indexB++;
            }
            else {
                indexA++;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
