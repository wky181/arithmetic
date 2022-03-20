package sort;

/**
 * @Author: wky233
 * @Date: 2020/9/5 14:05
 * @Description:
 */
public class Quick {
    public void QiickSort(int[] arr){
        if (arr == null || arr.length <= 1){
            return;
        }
    }
    public void sort(int[] arr,int l, int r){
        if (l < r){
            int p =partition(arr,l,r);
            sort(arr,l,p-1);
            sort(arr,p+1,r);
        }
    }
    public int partition(int[] arr, int l, int r){
        int mark = l;
        int povit = l;
        for (int i = l+1; i <= r ; i++) {
            if (arr[i] < arr[povit]){
                mark++;
                swap(arr,i, mark);
            }
        }
        swap(arr,povit,mark);
        return mark;
    }
    public void swap(int[] arr, int i, int j){
        if (arr[i] == arr[j]){
            return;
        }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
