package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/4/11 15:52
 * @Description:
 */
public class LeetCode_417 {
    public static void main(String[] args) {

    }

    int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };
    boolean[][] taiVisited;
    boolean[][] xiVisited;
    List<List<Integer>> lists;
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        lists = new LinkedList<>();
        if (matrix.length == 0){
            return lists;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        taiVisited = new boolean[m][n];
        xiVisited = new boolean[m][n];

        for (int i = 0; i < n; i++) {
            // 太平洋
            dfs(matrix,taiVisited,0,i );
            //大西洋
            dfs(matrix,xiVisited,m-1,i);
        }
        for (int i = 0; i < m; i++) {
            // 太平洋
            dfs(matrix,taiVisited,i,0 );
            //大西洋
            dfs(matrix,xiVisited,i,n-1);
        }
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n ; j++) {
                if (xiVisited[i][j] && taiVisited[i][j]){
                    lists.add(Arrays.asList(i,j));
                }
            }
        }
        return lists;
    }

    public boolean inAear(int x, int y, int[][] matrix) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[x].length) {
            return false;
        }
        return true;
    }

    public void dfs(int[][] matrix, boolean[][] visted, int x, int y) {
        visted[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + dir[i][0];
            int newY = y + dir[i][1];
            if (inAear(newX, newY, matrix) && matrix[newX][newY] <= matrix[x][y] && !visted[newX][newY]) {
                dfs(matrix, visted, newX, newY);
            }
        }
    }
}
