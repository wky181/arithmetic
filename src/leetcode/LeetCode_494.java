package leetcode;

/**
 * @author 武凯焱
 * @date 2019/10/26 16:08
 * @Description: 目标和
 */
public class LeetCode_494 {
    static  int sum;
    public static void main(String[] args) {
        int[] nums = {
            1
        };
       BFS(nums,1,0,0);
        System.out.println(sum);
    }
    /**
     * 暴力递归
     * @param nums
     * @param s
     * @param temp
     * @param number
     */
    private static void BFS(int[] nums, int s,int temp,int number) {
        if (number == nums.length){
            sum = temp==s ? ++sum :  sum;
        }else {
            BFS(nums,s,temp + nums [number], number+1);
            BFS(nums, s, temp - nums [number], number+1);
        }
    }
}
