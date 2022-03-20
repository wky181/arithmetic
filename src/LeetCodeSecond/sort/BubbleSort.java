package LeetCodeSecond.sort;

/**
 * @Author: wky233
 * @Date: 2020/6/4 15:31
 * @Description:
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = Utils.getRandomArr(10, 1, 20);
        Utils.show(arr);
        new BubbleSort().bubbleSort(arr,arr.length);
        Utils.show(arr);
    }
    // 冒泡排序，a表示数组，n表示数组大小
    public void bubbleSort(int[] a, int n) {
        if(n <= 1){
            return;
        }
        for (int i = 0; i < n ; i++) {
            // 提前退出冒泡排序的标志位
            boolean flag = false;
            for (int j = 0; j < n-i-1; j++) {
                if (a[j] > a[j+1]){
                    swap(j,j+1,a);
                    flag = true;
                }
            }
            if (!flag){
                break;
            }
        }
    }
    public void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i]  = arr[j];
        arr[j] = temp;
    }
}
