package leetcode;

import java.util.Arrays;

/**
 * @author 武凯焱
 * @date 2019/9/28 11:40
 * @Description:
 */
/*给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。*/
public class 组合总和 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        int[] memory = new int[target+1];
        Arrays.fill(memory,-1);
        int res = search(nums,target,memory);
        System.out.println(res);
    }

    public static int combinationSum4(int[] nums, int target) {
        return findTarget(nums, target);
    }

    //方法一、 递归
    public static int findTarget(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int res = 0;
        for (int number : nums) {
            if (target >= number) {
                res += findTarget(nums, target - number);
            }
        }
        return res;
    }

    //方法二、 记忆化搜索
    public static int search(int[] nums, int target, int[] memory) {
        if (memory[target] != -1) {
            return memory[target];
        }
        if (target == 0) {
            return 1;
        }
        int res = 0;
        for (int number : nums) {
            if (target >= number) {
                res += search(nums, target - number,memory);
            }
        }
        memory[target]=res;
        return memory[target];
    }
}