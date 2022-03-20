package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/5/24 10:32
 * @Description:
 */
public class LeetCode_5416 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] strs = sentence.split(" ");
        for (int i = 0; i < strs.length ; i++) {
            int i1 = strs[i].indexOf(searchWord);
            if (i1 == 0){
                return i+1;
            }
        }
        return -1;
    }
}
