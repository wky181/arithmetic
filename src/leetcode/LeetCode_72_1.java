package leetcode;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/3/30 22:20
 * @Description:
 */
public class LeetCode_72_1 {
    public static void main(String[] args) {

    }
    int[][] memo ;
    //类似LCS问题
    public int minDistance(String word1, String word2) {
        char[] charsA = word1.toCharArray();
        char[] charsB = word2.toCharArray();
        memo = new int[charsA.length][charsB.length];
        for (int i = 0; i < memo.length ; i++) {
            Arrays.fill(memo[i],-1);
        }
        int res = slove(charsA,charsB,word1.length()-1,word2.length()-1);
        return res;
    }
    public int slove(char[] word1, char[] word2,int index1, int index2) {
        if (index1 < 0){
            return index2+1;
        }if (index2 < 0){
            return index1+1;
        }
        if (memo[index1][index2] != -1){
            return memo[index1][index2];
        }
        if (word1[index1] == word2[index2]){
            int res = slove(word1,word2,index1-1,index2-1);
            memo[index1][index2] = res;
            return res;
        }else {
            //s1插入一个值
            int a = slove(word1,word2,index1,index2-1)+1;
            //s1替换一个值
            int b = slove(word1,word2,index1-1,index2-1)+1;
            //s1删除一个值
            int c = slove(word1,word2,index1-1,index2)+1;
            int res = min(a,b,c);
            memo[index1][index2] = res;
            return res;
        }
    }
    public int min(int a, int b, int c){
        a = Math.min(a,b);
        return Math.min(c,a);
    }

}
