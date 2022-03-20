package LeetCodeSecond.hash;

/**
 * @Author: wky233
 * @Date: 2020/7/22 22:47
 * @Description:
 */
public class LeetCode_409 {
    public static void main(String[] args) {
        System.out.println(122 - 65 + 1);
    }
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        char[] array = s.toCharArray();
        int[] count = new int[58];
        for (int i = 0; i < array.length ; i++) {
            count[array[i] - 'A']++;
        }
        int res = 0;
        boolean mark = false;
        for (int i = 0; i < count.length ; i++) {
            if ((count[i] & 1) == 1 ){
                res += count[i] - 1;
                mark = true;
            }else {
                res += count[i];
            }
        }
        return mark ? res + 1 : res ;
    }
}
