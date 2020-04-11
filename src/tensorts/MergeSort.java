package tensorts;

import bluebridgecup_course.class_03.Util;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/3/8 15:11
 * @Description:
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] randomArr = Util.getRandomArr(10, 1, 60);
        System.out.println(randomArr.length);
        new MergeSort().sort(randomArr, 0, randomArr.length - 1);
        Util.print(randomArr);
    }

    private void sort(int[] randomArr, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            sort(randomArr, l, mid);
            sort(randomArr, mid + 1, r);
            mergeSort(randomArr,l,mid,r);
        }
    }

    private void mergeSort(int[] arr, int l, int mid, int r) {
        int[] helper = new int[arr.length];
        System.arraycopy(arr, l, helper, l, r - l + 1);
        int left = l;
        int right = mid + 1;
        int current = l;
        while (left <= mid && right <= r) {
            if (helper[left] < helper[right]) {
                arr[current++] = helper[left++];
            } else {
                arr[current++] = helper[right++];
            }
        }
        while (left <= mid) {
            arr[current++] = helper[left++];
        }
    }


}
