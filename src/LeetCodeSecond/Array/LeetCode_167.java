package LeetCodeSecond.Array;

/**
 * @Author: wky233
 * @Date: 2020/7/20 21:08
 * @Description:
 */
public class LeetCode_167 {
    public int[] twoSum(int[] numbers, int target) {
        int first = 0;
        int end = numbers.length - 1;
        while (first < end){
            int num = numbers[first] + numbers[end];
            if (num == target){
                return new int[]{first, end};
            }else if (num > target){
                end--;
            }else {
                first++;
            }
        }
        return new int[]{};
    }
}
