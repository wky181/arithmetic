package LeetCodeSecond.sort;

/**
 * @Author: wky233
 * @Date: 2020/6/5 15:05
 * @Description:
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = Utils.getRandomArr(10, 1, 20);
        Utils.show(arr);
        new SelectionSort().selectionSort(arr,arr.length);
        Utils.show(arr);
    }
    // 选择排序，a表示数组，n表示数组大小
    public void  selectionSort(int[] a, int n) {
        if (n <= 1){
            return;
        }
        for (int i = 0; i < a.length ; i++) {
            int index = i;
            int min = a[i];
            for (int k = i+1; k < a.length ; k++) {
               if (a[k] < min){
                   index = k;
                   min = a[k];
               }
            }
            swap(i,index,a);
        }
    }
    public void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i]  = arr[j];
        arr[j] = temp;
    }
}
