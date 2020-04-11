package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/3/21 10:52
 * @Description:
 */
public class LeetCode_443 {
    public int compress(char[] chars) {
        if(chars == null || chars.length == 0){
            return 0;
        }
        int top = 1;
        int count = 1;
        for(int i = 1; i < chars.length; i++){
            if(chars[i-1] != chars[i]){
                if (count > 1) {
                    for (char ch : String.valueOf(count).toCharArray()) {
                        chars[top++] = ch;
                    }
                }
                chars[top++] = chars[i];
                count = 0;
            }
            count++;
        }
        if (count > 1) {
            for (char ch : String.valueOf(count).toCharArray()) {
                chars[top++] = ch;
            }
        }
        return top;
    }
}
