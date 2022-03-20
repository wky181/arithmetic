package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/4/19 11:21
 * @Description:
 */
public class LeetCode_5390 {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int index = 0;
        char cur = 'c';
        int end = 0;
        int res = 0;
        while (true){
            int i = croakOfFrogs.indexOf(cur,index);
            if (i == -1){
                return -1;
            }
            if (cur == 'k'){
                
            }
            index = 1;
            cur = next(cur);
        }

    }
    public char next (char ch) {
        String string = "croak";
        int index = string.indexOf(ch) +1;
       return index == string.length() ? 'c' : string.charAt(index);
    }
}
