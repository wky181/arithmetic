package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/4/16 15:52
 * @Description:
 */
public class LeetCode_978 {
    public int maxTurbulenceSize(int[] A) {
        if (A.length < 2) {
            return A.length;
        }
        int up = 1;
        int down = 1;
        int ans = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                up = down + 1;
                down = 1;
            } else if (A[i - 1] > A[i]) {
                down = up + 1;
                up = 1;
            } else {
                down = 1;
                up = 1;
            }
            ans = Math.max(ans, Math.max(up, down));
        }
        return ans;
    }

    public int maxTurbulenceSize1(int[] A) {
        if (A.length < 2) {
            return A.length;
        }
        int mark = 0;
        int ans = 1;
        for (int i = 1; i < A.length; i++) {
            int c = Integer.compare( A[i - 1], A[i]);
            if (i == A.length - 1 || c * Integer.compare(A[i], A[i + 1]) != -1) {
                if (c != 0) {
                    ans = Math.max(ans, i - mark + 1);
                }
                mark = i;
            }
        }
        return ans;
    }
}
