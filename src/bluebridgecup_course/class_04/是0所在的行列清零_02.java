package bluebridgecup_course.class_04;

import bluebridgecup_course.class_03.Util;

/**
 * @author 武凯焱
 * @date 2019/2/23 17:40
 * @Description:
 */
public class 是0所在的行列清零_02 {
    public static void main(String[] args) {
        int [][] matrix = {
                {1, 2, 3, 4, 100},
                {5, 6, 7, 0, 0},
                {9, 0, 11, 12, 102},
                {13, 14, 15, 16, 103},
                {104, 105, 106, 107, 103},
        };
        solve(matrix);
        Util.printMatrix(matrix);
    }
    static void solve(int[][] matrix){
        int[] rowRecord  = new int[matrix.length];
        int[] colRecord  = new int[matrix[0].length];
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[i].length; j++) {
                if (matrix[i][j]==0){
                    rowRecord[i] = 1;
                    colRecord[j] = 1;
                }

            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix[i].length; j++) {
                if (rowRecord[i]==1 || colRecord[j]==1){
                    matrix[i][j]=0;
                }
            }
        }
    }
}
