package 真题;

/**
 * @author 武凯焱
 * @date 2019/3/23 11:02
 * @Description:
 */
public class 垒骰子_15 {
    static int n=2;
    static int count;
    static int[] d;
    static {
        d = new int[7];
        d[1] = 4;
        d[4] = 1;
        d[6] = 3;
        d[3] = 6;
        d[2] = 5;
        d[5] = 2;
    }
    public static void main(String[] args) {
    }
    public static void dp(){
        boolean[][] conflict = new boolean[7][7];
        conflict[1][2] = true;
        int[][] dp = new int[2][7];
        for (int i = 0; i <6 ; i++) {
            dp[0][i] = 1;
        }
        for (int levle = 1; levle <dp.length ; levle++) {
            for (int j = 1; j <=6 ; j++) {
                for (int i = 1; i <=6 ; i++) {
                    if (conflict[i][d[j]]) continue;
                    dp[levle][j] += dp[levle-1][i];
                }
            }
        }

    }
}
