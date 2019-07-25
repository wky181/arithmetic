package 蓝桥杯;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author 武凯焱
 * @date 2019/3/15 21:45
 * @Description:
 */
public class 最小乘积 {
    public static void main(String[] args) {
            /*int[] arr = {1,2,3,4,5};
            int[] arr1 = {1,0,1,0,1};
        System.out.println(solve(arr,arr1));*/
    }
    public static int solve(int[] arr,int[] arr1){
        Arrays.sort(arr);
        Arrays.sort(arr1);
        int begin = 0;
        int end  = arr.length-1;
        int sum = 0;
        for (int i = 0; i <arr.length-1 ; i++) {
            int temp;
            if (arr[i]<=0){
                temp = arr[i]*arr1[end];
                sum+= temp;
                end--;
            }
            else {
                temp = arr[i]*arr[begin];
                sum+= temp;
                begin++;
            }
        }
        return sum;
    }
    public static void count(int cuont){
        cuont +=1;
    }
}
