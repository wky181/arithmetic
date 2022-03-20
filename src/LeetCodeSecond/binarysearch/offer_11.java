package LeetCodeSecond.binarysearch;

/**
 * @Author: wky233
 * @Date: 2020/7/22 13:56
 * @Description:
 */
public class offer_11 {
    public int minArray(int[] numbers){
        int left = 0;
        int right = numbers.length-1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (numbers[mid] < numbers[right]){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return numbers[left];
    }
}
