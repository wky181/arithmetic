package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_5256 {
    public static void main(String[] args) {
        int[] colsum = {

                        2,1,2,0,0,2
        };
        System.out.println(reconstructMatrix(1,4,colsum));
    }

    public static List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        int[][] array = new int[2][colsum.length];
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 2) {
                upper--;
                lower--;
                array[0][i] = 1;
                array[1][i] = 1;
            }
        }
        if (upper<0 || lower<0){
            return lists;
        }
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i]==1){
                if (upper>0){
                    array[0][i]=1;
                    upper--;
                }else if (lower>0){
                    array[1][i]=1;
                    lower--;
                }else {
                    return lists;
                }
            }
        }
        if (upper!=0 || lower!=0){
            return lists;
        }
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        for (int i = 0; i <colsum.length ; i++) {
            list1.add(array[0][i]);
            list2.add(array[1][i]);
        }
        lists.add(list1);
        lists.add(list2);
        return lists;
    }
}
