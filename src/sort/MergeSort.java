package sort;

/**
 * @Author: wky233
 * @Date: 2020/9/5 14:25
 * @Description:
 */
public class MergeSort {
    public void sort(int[] arr){
        int[] temp = new int[arr.length];
    }
    public void mergeSort(int[] arr, int l , int r, int[] help){
        if (l == r){
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(arr,l,mid,help);
        mergeSort(arr,mid+1,r,help);
        if (arr[mid] > arr[mid + 1]){
            merge(arr,l,mid,r,help);
        }
    }

    private void merge(int[] arr, int l,int mid, int r,int[] help) {
        for (int i = l; i <= r; i++) {
            help[i] = arr[i];
        }
        int left = l;
        int right = mid+1;
        for (int i = l; i <= r ; i++) {
            if (left == mid + 1 ){
                arr[i] = help[right++];
            }
            else if (right == r + 1){
                arr[i] = help[left++];
            }
            else if (arr[left] <= arr[right]){
                arr[i] = help[left];
                left++;
            }else {
                arr[i] = help[right];
                right++;
            }
        }
    }

}
