package leetcode;

import bluebridgecup_course.class_03.Util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/1/29 21:07
 * @Description:
 */
public class LeetCode_350 {
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        Util.print(new LeetCode_350().intersect1(nums1, nums2));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap1 = new HashMap<>();
        HashMap<Integer, Integer> hashMap2 = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            hashMap1.put(nums1[i], hashMap1.getOrDefault(nums1[i], 0) + 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (hashMap1.containsKey(nums2[i])) {
                int temp = hashMap1.get(nums2[i]);
                if (temp > 0) {
                    hashMap1.put(nums2[i], temp - 1);
                    list.add(nums2[i]);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    /**
     * 先使用快速排序，然后采用双指针法
      */
    public int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int indexNums1 = 0;
        int indexNums2 = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (indexNums1 < nums1.length && indexNums2 < nums2.length){
            if (nums1[indexNums1] == nums2[indexNums2]){
                arrayList.add(nums1[indexNums1]);
                indexNums1++;
                indexNums2++;
            }else if (nums1[indexNums1] > nums2[indexNums2] ){
                indexNums2++;
            }else {
                indexNums1++;
            }
        }
        int[] result = new int[arrayList.size()];
        for (int i = 0; i < result.length ; i++) {
            result[i] = arrayList.get(i);
        }
        return result;
    }
}
