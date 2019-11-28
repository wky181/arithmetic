package leetcode;

import java.util.*;

public class LeetCode_791 {
    public static void main(String[] args) {
        System.out.println(customSortString("abcdefjhijklmn", "abcdgdgfsdhgfhjgsfkjkHSfsgsdvcxvxcvdadgvxvdfsdgsgssgsgdsgfgssg"));
    }

    public static String customSortString(String S, String T) {
        char[] ts = T.toCharArray();
        //将上面的字符型数组转为装箱过的数组
        Character[] chs = new Character[ts.length];
        for (int i = 0; i < chs.length; i++) {
            chs[i] = ts[i];
        }
        Arrays.sort(chs, new Comparator<Character>() {
            @Override
            public int compare(Character a, Character b) {
                int indexA = S.indexOf(a);
                int indexB = S.indexOf(b);
                if (indexA < 0 && indexB < 0) {
                    return 0;
                }
                if (indexA > 0 && indexB < 0) {
                    return 1;
                }
                if (indexA < 0 && indexB > 0) {
                    return -1;
                }
                if (indexA > indexB) {
                    return 1;
                }
                if (indexA == indexB) {
                    return 0;
                }
                if (indexA < indexB) {
                    return -1;
                }
                return indexA > indexB ? 1 : 0;
            }
        });
        for (int i = 0; i < chs.length; i++) {
            ts[i] = chs[i];
        }
        return new String(ts);
    }
}
