package leetcode;

/**
 * @author 武凯焱
 * @date 2019/4/13 8:12
 * @Description:
 */
public class 岛屿的个数 {
    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1'},
                        {'1','1','0','1','0'},
                        {'1','1','0','0','0'},
                        {'1','1','0','1','0'}};
        System.out.println(numIslands(grid));
    }
    public static int numIslands(char[][] grid) {
        if (grid.length<=0){
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int count =0 ;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                if (grid[i][j]=='1'){
                    if (check(i,j,grid)){
                        dfs(i,j,grid);
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public static void dfs(int i,int j,char[][] arr){
        arr[i][j] = '0';
        for (int k = -1; k <2 ; k++) {
            if (i+k>=0&& i+k<arr.length && arr[i+k][j]=='1'){
                dfs(i+k,j,arr);
            }
            if (j+k>=0 && j+k<arr[0].length && arr[i][j+k]=='1' ){
                dfs(i,j+k,arr);
            }
        }
    }
    public static boolean check(int i,int j ,char[][] arr){
        for (int k = -1; k < 2 ; k++) {
                if (i+k>=0&& i+k<arr.length && arr[i+k][j]=='1'){
                    return true;
                }
                if (j+k>=0 && j+k<arr[0].length && arr[i][j+k]=='1' ){
                    return true;
            }
        }
        return false;
    }
}
