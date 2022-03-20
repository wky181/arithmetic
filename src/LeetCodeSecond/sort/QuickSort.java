package LeetCodeSecond.sort;

/**
 * @Author: wky233
 * @Date: 2020/6/6 17:27
 * @Description:
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] randomArr = Utils.getRandomArr(10, 1, 10);
        Utils.show(randomArr);
        new QuickSort().sort(randomArr,randomArr.length);
        Utils.show(randomArr);
    }
    public void sort(int[] nums, int n){
        if (n <= 1){
            return;
        }
        quickSort(nums,0, n-1);
    }
    public void quickSort(int[] nums, int left, int right){
        if (left >= right){
            return;
        }
        int partition = partition(left, right, nums);
        quickSort(nums,left,partition-1);
        quickSort(nums, partition+1, right);
    }
    private int partition(int left, int right, int[] nums) {
       int p = nums[left];
       int mark = left;
        for (int i = left + 1; i <= right ; i++) {
            if (nums[i] < p){
                mark++;
                swap(nums, i, mark);
            }
        }
        nums[left] = nums[mark];
        nums[mark] = p;
        return mark;
    }
    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
