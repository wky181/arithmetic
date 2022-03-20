package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/4/26 10:39
 * @Description:
 */
public class LeetCode_5392 {
    public int maxScore(String s) {
        char[] array = s.toCharArray();
        int one = 0;
        for (char ch: array) {
            if (ch == '1'){
               one++;
            }
        }
        int left = 0;
        int res = 0;
        int zero = 0;
        while (left < array.length-1){
            if (array[left] == '1'){
                 one--;
            }else {
              zero++;
            }
            res = Math.max(res,zero + one);
            left++;
        }
        return res;
    }
}
