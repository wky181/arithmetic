package leetcode;

/**
 * @author 武凯焱
 * @date 2019/8/24 15:46
 * @Description:
 */
public class 整数拆分 {
    static int[] nums;

    public static void main(String[] args) {

    }
    //递归暴力破解
    public static int  baoli(int n){
        if (n==2){
            return 1;
        }
        int res = -1;
        for (int i = 1; i <=n-1 ; i++) {
            //暴力递归 Math.math(i*(n-i)) i = 1~n-1
            res =  Math.max(res,Math.max(i*(n-i),i*baoli(n-i)));
        }
        return res;
    }
    //记忆化搜索
    public static int memorySearch(int n){
        nums = new int[n+1];
        if (n==2){
            return 1;
        }
        int res = -1;
        if (nums[n]!=0){
            return nums[n];
        }
        for (int i = 1; i <=n-1 ; i++) {
                res = Math.max(res, Math.max(i * (n - i),i*memorySearch(n-i)));
        }
        nums[n] = res;
        return res;

    }
}
