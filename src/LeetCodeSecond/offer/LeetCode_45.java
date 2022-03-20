package LeetCodeSecond.offer;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/6/26 20:53
 * @Description:
 */
public class LeetCode_45 {
    public String minNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, (o1, o2) -> {
            return jundge(o1, o2);
        });
        int i = 0;
        while (strings[i].equals("0")) {
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for (int j = i; j < strings.length; j++) {
            sb.append(strings[j]);
        }
        return sb.toString();
    }

    public int jundge(String s1, String s2) {
        int i = 0;
        while (i < s1.length() || i < s2.length()) {
            int c1 = i < s1.length() ? s1.charAt(i) - '0' : s1.charAt(0);
            int c2 = i < s2.length() ? s2.charAt(i) - '0' : s2.charAt(0);
            if (c1 < c2) {
                return -1;
            } else if (c1 > c2) {
                return 1;
            }
            i++;
        }
        return s1.length() >= s2.length() ? -1 : 1;
    }

    public String minNumber1(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings,(s1, s2) -> {
            return  (s1 + s2).compareTo(s2 + s1);
        });
        StringBuilder sb = new StringBuilder();
        for (String s: strings) {
            sb.append(s);
        }
        return sb.toString();
    }
}
