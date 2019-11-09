package bluebridgecup_course.class_04;

/**
 * @author 武凯焱
 * @date 2019/2/27 11:20
 * @Description:
 */
public class 矩阵的计算_09 {
    public static void main(String[] args) {
        int[][] matrix = {

        };

    }
    public static  int[][] multiply(int[][] A, int[][] B ){
        int M = A.length;
        int N = B[0].length;
        if (A[0].length!= B.length){
            return new  int[M][N];
        }
        int[][] AB = new int[M][N];
        for (int i = 0; i <M ; i++) {
            for (int j = 0; j <N ; j++) {
                for (int k = 0; k <A[0].length ; k++) {
                    AB[i][j] += A[i][k]*B[k][j];
                }
            }
        }
        return  AB;
    }
}
