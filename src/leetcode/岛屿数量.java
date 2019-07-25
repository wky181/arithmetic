package leetcode;

/**
 * @author 武凯焱
 * @date 2019/7/20 16:20
 * @Description:
 */
public class 岛屿数量 {
    public static void main(String[] args) {

    }
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j <grid[0].length ; j++) {
                if (grid[i][j]=='1'){
                    if (check(grid,i,j)){
                        dfs(grid,i,j);
                    }
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid,int i,int j){
        grid[i][j]='0';
        for (int k = 1; k >=-1 ; k--){
            if (i+k>=0 && i+k<grid.length && grid[i+k][j]=='1'){
                dfs(grid,i+k,j);
            }
            if (j+k>=0 && j+k<grid[0].length && grid[i][j+k]=='1'){
                dfs(grid,i,j+k);
            }
        }
    }

    public static boolean check(char[][]grid, int i,int j){
        for (int k = 1; k >=-1 ; k--){
            if (i+k>=0 && i+k<grid.length && grid[i+k][j]=='1'){
                return true;
            }
            if (j+k>=0 && j+k<grid[0].length && grid[i][j+k]=='1'){
                return true;
            }
        }
        return false;
    }
}
