package leetcode;

/**
 * @author 武凯焱
 * @date 2019/7/27 14:57
 * @Description:
 */
public class 打家劫舍 {
    public static void main(String[] args) {

    }
    public int rob(int[] nums) {
        int per   = 0;
        int current= 0;

        for (int i = 0; i <nums.length ; i++) {
            int temp   = current;
            current = Math.max(per+nums[i],current);
            per = temp;
        }
        return current;
    }
}
