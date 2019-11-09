package bluebridgecup_course.class_04;

/**
 * @author 武凯焱
 * @date 2019/2/23 22:06
 * @Description:
 */
public class 边界为1的最大矩阵 {
    public static void main(String[] args) {
        int[][] A = {
                {1, 1, 1, 0, 1},
                {1, 1, 0, 1, 1},
                {0, 1, 1, 1, 1},
                {0, 1, 1, 1, 0},
                {0, 1, 0, 1, 0}
        };
        System.out.println(solve(A));
    }

    private static int solve(int[][] A) {
        int N = A.length;
        int n = N;
        while (n > 0) {
            for (int i = 0; i < N; i++) {
                if ( i + n  > N) {
                    break;
                }
                l3:
                for (int j = 0; j < A[0].length; j++) {
                    // i j 代表当前位置的点 n代表要判断的阶数
                    int r = i, c = j;
                    if ( j + n  > N) {
                        break;
                    }
                    //检查四个边
                    //检查上边
                    while (c < j + n) {
                        if (A[r][c] == 0) {
                            continue l3;
                        } else {
                            c++;
                        }
                    }
                    c--;
                    //检查右边
                    while (r <  i+n) {
                        if (A[r][c] == 0) {
                            continue l3;
                        } else {
                            r++;
                        }
                    }
                    r--;
                    //检查下边
                    while (c >= j) {
                        if (A[r][c] == 0) {
                            continue l3;
                        } else {
                            c--;
                        }
                    }
                    c++;
                    //检查左边
                    while (r >= i) {
                        if (A[r][c] == 0) {
                            continue l3;
                        } else {
                            r--;
                        }
                    }
                    return n;
                }
            }
            n--;
        }
        return 0;
    }
}
