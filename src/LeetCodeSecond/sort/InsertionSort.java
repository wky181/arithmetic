package LeetCodeSecond.sort;

/**
 * @Author: wky233
 * @Date: 2020/6/5 14:36
 * @Description:
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = Utils.getRandomArr(10, 1, 20);
        Utils.show(arr);
        new InsertionSort().insertionSort(arr,arr.length);
        Utils.show(arr);

    }
    // 插入排序，a表示数组，n表示数组大小
    public void insertionSort(int[] a, int n) {
        if (n <= 1){
            return;
        }
        for (int i = 1; i < n ; i++) {
            int value = a[i];
            int  j = i - 1;
            for (; j >= 0 ; j--) {
                if (a[j] > value){
                    a[j+1] = a[j];
                }else {
                    break;
                }
            }
            a[j+1] = value;
        }
    }
}
