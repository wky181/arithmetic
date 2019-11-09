package leetcode;

/**
 * @author 武凯焱
 * @date 2019/8/3 15:41
 * @Description:
 */
public class 跳跃游戏 {
    public static void main(String[] args) {
        int nums[] = {1,0,1,0};
        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        if (nums.length==0){
            return false;
        }else if (nums[0]==0){
            return false;
        }
   /*     if (nums.length<=1){
            return true;
        }
        int n = nums.length-1;
        int perMax = nums[0];
        if (nums[0]==0){
            return false;
        }
        if (perMax>=n){
            return true;
        }*/
        int n = nums.length-1;
        int perMax = 0;
        for (int i = 0; i <nums.length-1 ; i++) {
            perMax = perMax-1 >nums[i] ? perMax-1 :nums[i];
            if (perMax>=n-i){
                return true;
            } else if (perMax==0) {
                return false;
            }
        }
        return false;
    }
}
