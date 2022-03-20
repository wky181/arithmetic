package LeetCodeSecond.weekrank;

/**
 * @Author: wky233
 * @Date: 2020/6/13 22:37
 * @Description:
 */
public class SubrectangleQueries {
    private int[][] rectangle;
    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        int left  = col1;
        int right = col2;
        int top = row1;
        int end = row2;
        for (int i = top; i <= end ; i++) {
            for (int j = left; j <= right ; j++) {
                rectangle[i][j] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return rectangle[row][col];
    }
}
