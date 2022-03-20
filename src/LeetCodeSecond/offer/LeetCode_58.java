package LeetCodeSecond.offer;

/**
 * @Author: wky233
 * @Date: 2020/6/30 20:27
 * @Description:
 */
public class LeetCode_58 {
    public String reverseWords(String s) {
        char[] array = s.toCharArray();
        StringBuilder res = new StringBuilder();
        StringBuilder word = new StringBuilder();
        boolean isBlack = false;
        for (int i = 0; i < array.length ; i++) {
            if (array[i] == ' '){
                if(isBlack){
                    continue;
                }
                isBlack = true;
                res.insert(0,word);
                res.insert(0,' ');
                word = new StringBuilder();
            }else {
                word.append(array[i]);
                isBlack = false;
            }
        }
        res.insert(0,word);
        String s1 = res.toString();
        int i = 0;
        int j = s1.length()-1;
        while (i < res.length() && s1.charAt(i) == ' ' ){
            i++;
        }
        while (j >= 0 && s1.charAt(j) == ' '){
            j--;
        }
        if ( j+1 >= i) {
            return s1.substring(i, j + 1);
        }else {
            return "";
        }
    }
    // 双指针
    public String reverseWords1(String s) {
        s = s.trim();
        int i  = s.length() - 1;
        int j = i;
        StringBuilder res = new StringBuilder();
        while (i >= 0){
            while (i >= 0 && s.charAt(i) != ' '){
                i--;
            }
            res.append(s.substring(i+1,j+1) + " ");
            // 去除多余空格
            while (i >= 0 && s.charAt(i) == ' '){
                i--;
            }
            j = i;
        }
        return res.toString().trim();
    }
}
