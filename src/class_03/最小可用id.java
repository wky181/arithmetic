package class_03;

import java.util.Arrays;

/**
 * @author 武凯焱
 * @date 2019/2/19 11:11
 * @Description:
 */
public class 最小可用id {
    public static void main(String[] args) {
        /*int[] arr = {1,2,3,4,5,7};*/
        int[] arr = new int[1000*100];
        for (int i = 0; i <arr.length ; i++) {
            if (i==900*10){
                arr[i] = arr.length+10;
            }
            else {
                arr[i] = i+1;
            }
        }
        System.out.println(minId(arr));
        System.out.println(midId1(arr));
        System.out.println(midId2(arr,0,arr.length-1));
    }

    // 时间复杂度 O(n logN)
    public static int minId(int[] arr) {
        Arrays.sort(arr);
        int i = 0;
        while (i < arr.length) {
            if (arr[i] != i + 1) {
                return i + 1;
            } else {
                i++;
            }
        }
        return i + 1;
    }

    //开辟辅助空间 时间复杂度 O(n)
    public static int midId1(int[] arr) {
        int[] helper = new int[arr.length+1];
        for (int i = 0; i <arr.length; i++) {
            if (arr[i]<= arr.length)
            helper[arr[i]] = 1;
        }
        for (int i = 1; i < helper.length ; i++) {
            if (helper[i]==0){
                return i ;
            }
        }
        return  helper.length;
    }
    // 递归方式 时间复杂度 O(n)
    public static int midId2(int[] arr,int p ,int r){
        if (p>r){
            return p + 1;
        }
            int q = partion(arr, p, r);
            if (arr[q]==q+1){
                return midId2(arr, q+1, r);
            }else {
                return midId2(arr,p ,q-1);
        }
    }
    public static int partion (int[] arr,int p ,int r){
        int mid = (p+r)/2;
        int pvation = arr[p];
        int sp = p+1;
        int bigger = r;
        while (sp<=bigger){
            if (arr[sp]<=pvation){
                sp++;
            }else {
                Util.swap(arr,sp,bigger--);
            }
        }
        Util.swap(arr,p,bigger);
        return bigger;

    }
}
