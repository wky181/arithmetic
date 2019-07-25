package class_03;

import class_03.Util;

import java.util.Arrays;

/**
 * @author 武凯焱
 * @date 2019/2/19 8:17
 * @Description:
 */
public class 乱序中找第k大的数 {
    public static void main(String[] args) {
        int[] arr = Util.getRandomArr(30, 1, 100);
        Util.print(arr);
        System.out.println(quickSelcet(arr,0,arr.length-1,29));
        Arrays.sort(arr);
        Util.print(arr);
    }
    public static int quickSelcet(int[] arr,int p , int r,int k){
        int mid = (p+r)/2;
        int midValue = -1;
        if (arr[p]<=mid && arr[p]>=arr[r]){
            midValue = p;
        }
        else if (arr[r]>=arr[mid] && arr[r] <= arr[p]){
            midValue = r;
        }else{
            midValue = mid;
        }
        Util.swap(arr,p,midValue);
        int pviot = arr[p];
        int sp = p+1;
        int bigger = r;
        while (sp<=bigger){
            if (arr[sp]<=pviot){
                sp++;
            }else {
                Util.swap(arr,sp,bigger--);
            }
        }
        Util.swap(arr,p,bigger);
        if (bigger-p+1 == k){
            return arr[bigger];
        }else if (bigger-p+1 > k){
            return quickSelcet(arr,p,bigger-1,k);
        }else {
            return quickSelcet(arr,bigger+1,r,k-(bigger-p+1));
        }

    }
}
