package Interview.yuanfudao;

/**
 * @Author: wky233
 * @Date: 2020/8/8 22:30
 * @Description:
 */
public class T3 {
    public int findKthPositive(int[] arr, int k) {
        int[] nums = new int[1000 + 1];
        for (int i = 0; i < arr.length ; i++) {
            nums[arr[i]] = 1;
        }
        int i = 1;
        for ( ; i < nums.length ; i++) {
            if (nums[i] == 0){
                k--;
                if (k == 0){
                    return i;
                }
            }
        }
        while (k > 0){
            i++;
            k--;
        }
        return i;
    }
}
