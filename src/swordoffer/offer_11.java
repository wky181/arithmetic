package swordoffer;

/**
 * @Author: wky233
 * @Date: 2020/8/27 23:31
 * @Description:
 */
public class offer_11 {
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0){
            return 0;
        }
        int left = 0;
        int right = numbers.length-1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (numbers[mid] < numbers[right]){
                right = mid;
            }
            else if (numbers[mid] > numbers[right]){
                left = mid + 1;
            }else {
                right--;
            }
        }
        return numbers[left];
    }
}
