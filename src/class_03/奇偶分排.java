package class_03;

import class_03.Util;

/**
 * @author 武凯焱
 * @date 2019/2/18 15:25
 * @Description:
 */
public class 奇偶分排 {
    public static void main(String[] args) {
        int[] arr = Util.getRandomArr(30,1,20);
        sort(arr);
        Util.print(arr);

    }
    //快排思想
    public static void sort(int[] arr){
        int p = 0;
        int r = arr.length-1;
        while (p<=r){
            while (p<=r && (arr[p]%2)!=0){
                p++;
            }
            while (p<=r && (arr[r]%2)==0){
                r--;
            }
            if (p<r){
                Util.swap(arr,p,r);
            }
        }

    }
}
