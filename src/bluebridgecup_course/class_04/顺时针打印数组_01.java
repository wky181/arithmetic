package bluebridgecup_course.class_04;

/**
 * @author 武凯焱
 * @date 2019/2/22 22:39
 * @Description:
 */
public class 顺时针打印数组_01 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,6,7},
                {7,9,10},
                {7,9,10},
};
        print(matrix);
    }
    static void print(int[][] matrix) {
        int leftUpRow = 0, leftUpCol = 0, rightDownRow = matrix.length - 1, rightDownCol = matrix[0].length - 1;
        while (leftUpRow < rightDownRow && leftUpCol < rightDownCol) {
            int lr = leftUpRow;
            int lc = leftUpCol;
            //上一条边
            while (lc <= rightDownCol) {
                System.out.print(matrix[lr][lc++] + " ");
            }
            lc = rightDownCol;
            lr++;
            //右一条边
            while (lr <= rightDownRow) {
                System.out.print(matrix[lr++][lc] + " ");
            }
            //下面一条边
            lc--;
            lr = rightDownRow;
            while (lc >= leftUpCol) {
                System.out.print(matrix[lr][lc--] + " ");
            }
            //左面一条边
            lc++;
            lr--;
            while (lr > leftUpRow) {
                System.out.print(matrix[lr--][lc] + " ");
            }
            leftUpCol++;
            leftUpRow++;
            rightDownCol--;
            rightDownRow--;
        }
        if (leftUpCol==rightDownCol && leftUpRow ==rightDownRow){
            System.out.println(matrix[leftUpCol][rightDownCol]);
        }else if (leftUpRow == rightDownRow ){
            while (leftUpCol<=rightDownCol){
                System.out.print(matrix[leftUpRow][leftUpCol++]+" ");
            }
        }else {

            while (leftUpRow<=rightDownRow){
                System.out.print(matrix[leftUpRow++][leftUpCol]+" ");
            }
        }

    }

}
