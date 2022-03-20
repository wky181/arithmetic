package leetcode;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/5/2 23:14
 * @Description:""
 * ""
 */
public class LeetCode_5386 {
    public static void main(String[] args) {
        System.out.println(checkIfCanBreak("yopumzgd","pamntyya"));
    }
    public static boolean checkIfCanBreak(String s1, String s2) {
        char[] array = s1.toCharArray();
        Arrays.sort(array);
        System.out.println(new String(array));
        char[] arr = s2.toCharArray();
        Arrays.sort(arr);
        System.out.println(new String(arr));
        boolean marks1 = false;
        boolean marks2 = false;
        for (int i = 0; i < arr.length ; i++) {
            if (array[i] > arr[i]){
                marks1 = true;
            }else if (array[i] < arr[i] ){
                System.out.println(arr[i]);
                marks2 = true;
            }
        }
        return marks1 ^ marks2;
    }
}
