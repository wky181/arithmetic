package LeetCodeSecond.weekrank;

import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/7/31 14:44
 * @Description:
 *
 9
 25 84 21 47 15 27 68 35 20
 */
public class T2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        sort(nums,n);
    }

    public static void sort(int[] nums, int n){
        if (n <= 1){
            return;
        }
        quickSort(nums,0, n-1);
    }
    public static void quickSort(int[] nums, int left, int right){
        if (left >= right){
            return;
        }
        int partition = partition(left, right, nums);
        print(nums);
        quickSort(nums,left,partition-1);
        quickSort(nums, partition+1, right);
    }
    private static int partition(int left, int right, int[] nums) {
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
    public static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void print(int[] nums) {
        for (int num: nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
