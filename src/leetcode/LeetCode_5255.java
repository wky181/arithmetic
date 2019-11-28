package leetcode;

public class LeetCode_5255 {
    public static void main(String[] args) {
        int[][] indeices = {
                {40,5}
        };
        System.out.println(oddCells(48,37,indeices));
    }

    public static int oddCells(int n, int m, int[][] indices) {
        int result = 0;
        int[][] nums = new int[n][m];
        int[] ri = new int[n];
        int[] ci = new int[m];
        for (int i = 0; i < indices.length; i++) {
            ri[indices[i][0]]++;
            ci[indices[i][1]]++;

        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                int res = ri[i] + ci[j];
                if ((res % 2 == 0)) {
                    continue;
                }else {
                    result++;
                }
            }

        }
        return result;
    }
}
