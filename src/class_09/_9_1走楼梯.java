package class_09;

/**
 * @author 武凯焱
 * @date 2019/3/5 10:39
 * @Description:
 */
public class _9_1走楼梯 {
    public static void main(String[] args) {
        System.out.println(solve(8));
        System.out.println(solve1(8));
    }
    public static int solve(int n){
        if (n<0){
            return 0;
        }
        else if (n==0 || n==1){
            return  1;
        }
        else if (n==2){
            return 2;
        }
        else {
            return solve(n-1)+solve(n-2)+solve(n-3);
        }
    }
    public static int solve1(int n){
        if (n<0){
            return 0;
        }
        else if (n==0 || n==1){
            return  1;
        }
        else if (n==2){
            return 2;
        }
        int x1 = 1;
        int x2 = 1;
        int x3 = 2;
        for (int i = 3; i <= n ; i++) {
            int temp3 = x3;
            x3 = x1 + x2 + x3;
            x1 = x2;
            x2 = temp3;
        }
        return x3;
    }
}
