package leetcode;

public class LeetCode_62 {
    public static void main(String[] args) {
        System.out.print(uniquePaths(7,3));
    }
    public static int uniquePaths(int m, int n){
        int[][] unique = new int[m][n];
        for (int i = 0; i <m ; i++) {
            unique[i][0] = 1;
        }
        for (int i = 0; i <n ; i++) {
            unique[0][i] = 1;
        }
        int result = 0;
        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                unique[i][j]=unique[i-1][j]+unique[i][j-1];
            }
        }
        return unique[m-1][n-1];
    }

}
