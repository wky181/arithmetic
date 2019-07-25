package class_03;

import java.util.Arrays;

/**
 * @author 武凯焱
 * @date 2019/2/21 15:32
 * @Description:
 */
public class 计数排序 {
    public static void main(String[] args) {
        int[] arr = Util.getRandomArr(10,1,100);
        countSort(arr);
        Util.print(arr);
    }
    static void countSort(int[] arr){
        int[] helper = new int[Util.maxValue(arr)+1];
        for (int i = 0; i <arr.length ; i++) {
            helper[arr[i]]++;
        }
        int courent = 0;
        for (int i = 0; i <helper.length ; i++) {
            while (helper[i]>0){
                helper[i]--;
                arr[courent++] = i;
            }
        }
    }
}
