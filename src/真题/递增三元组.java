package 真题;

import java.util.Arrays;

/**
 * @author 武凯焱
 * @date 2019/3/17 10:27
 * @Description:
 */
public class 递增三元组 {
    static int count;

    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        int n = arr.length;
        int[] arr1 = {2, 0, 2};
        int[] arr2 = {3, 3, 3};
        Arrays.sort(arr);
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int[] f = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                if (arr1[j]>arr[i]){
                    f[i] = n-j;
                    break;
                }
            }
            if (f[i]!=0){
                for (int j = 0; j < n; j++) {
                    if (arr2[j]>arr1[i]){
                        end[i] = n-j;
                        break;
                    }
                }
                count+=f[i]*end[i];
            }
        }
        System.out.println(count);
    }


}