package LeetCodeSecond.sort;


public class MergeSort{
    public static void main(String[] args) {
        int[] arr = Utils.getRandomArr(10, 1, 20);
        Utils.show(arr);
        new MergeSort().sort(arr,arr.length);
        Utils.show(arr);

    }
    int count;
    public void sort(int[] nums, int n){
        int[] temp = new int[n];
        if (n <= 1){
            return;
        }
        mergeSort(nums,0,n-1,temp);
    }

    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left >= right){
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums,left,mid, temp);
        mergeSort(nums, mid + 1, right, temp);
        if (nums[mid] > nums[mid+1]){
            merge(nums,left,mid,right,temp);
        }
    }
    private void merge(int[] nums, int left,int mid, int right, int[] temp) {
        for (int i = left; i <= right ; i++) {
            temp[i]  = nums[i];
        }
        int l = left;
        int r = mid + 1;
        for (int i = left; i <= right ; i++) {
            if (l == mid+1){
                nums[i] = temp[r++];
            }
            else if (r == right + 1){
                nums[i] = temp[l++];
            }
            else if (temp[l] <= temp[r]){
                nums[i] = temp[l++];
            }else {
                // 求逆序对
                count++;
                nums[i] = temp[r++];
            }
        }
    }
}