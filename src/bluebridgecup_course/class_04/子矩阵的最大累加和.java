package bluebridgecup_course.class_04;

import java.util.Arrays;

/**
 * @author 武凯焱
 * @date 2019/2/26 22:02
 * @Description:
 */
public class 子矩阵的最大累加和 {
    public static void main(String[] args) {
        int[][] matrix = {
                {-6, -4, 7},
                {106, -4, 6},
                {-8, -7, -6}
        };
        System.out.println(maxSum(matrix));
    }
    public static int maxSum(int[][] matrix){
        int beginRow = 0; //以它为起始行
        final int M  = matrix.length;
        final int N = matrix[0].length;
        int[] sums  = new  int[N];
        int max = 0; //历史最大矩阵和
        while (beginRow<M) {
            for (int i = beginRow; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    sums[j] += matrix[i][j];  //把当前列的元素值累加
                }
                int t = findMax(sums);  //求出最大值
                if (t > max) {
                    max = t;
                }
            }
            Arrays.fill(sums,0);
            beginRow++;
        }
        return max;
    }
    public static int  findMax(int[] arr){
        int sum = arr[0];
        int max = arr[0];
        for (int i = 1; i <arr.length ; i++) {
            if (sum>0){
                sum+=arr[i];
            }
            else {
                sum = arr[i];
            }
            if (sum>max){
                    max = sum;
            }
        }
        if (sum==0 ){
            return -1;
        }else {
            return sum;
        }

    }
}
