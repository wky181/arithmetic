package leetcode;

import java.util.Random;

/**
 * @author 武凯焱
 * @date 2019/7/22 15:07
 * @Description:
 */

public class Utils {
    /**
     *  生成一个指定长度的随机数组
     * @param length 长度
     * @param min
     * @param max
     * @return
     */
    public static int[] getRandomArr(int length,int min ,int max ){
        int arr[] = new int[length];
        for (int i = 0; i <length ; i++) {
            arr[i] = new Random().nextInt(max-min+1)+min;
        }
        return arr;
    }
    public static void show(int[] arr){
        String str = "";
        for (int i = 0; i <arr.length; i++) {
            str+=arr[i]+",";
        }
        System.out.println( str.substring(0,str.length()-1));
    }
}
