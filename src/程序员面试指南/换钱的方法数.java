package 程序员面试指南;

/**
 * @author 武凯焱
 * @date 2019/3/21 19:16
 * @Description:
 */
public class 换钱的方法数 {
    public static void main(String[] args) {
        int[] arr = {5,10,25,1};
        System.out.println(solve(arr,0,15));
    }
    //暴力递归
    public static int solve(int[] arr,int k, int aim){
        int res = 0;
        if (k==arr.length){
            res = aim == 0 ? 1 : 0;
        }else {
            for (int i = 0; i * arr[k] <= aim; i++) {
                 res += solve(arr, k + 1, aim - i * arr[k]);
            }
        }
        return res;
    }
}
