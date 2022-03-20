package swordoffer;

/**
 * @Author: wky233
 * @Date: 2020/8/28 23:27
 * @Description:
 */
public class offer_13 {
    int m;
    int n;
    int[][] dir = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };
    int res = 0;
    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        boolean[][] visited  = new boolean[m][n];
        dfs(0,0,k,visited);
        return res;
    }
    public void dfs(int x, int y, int k, boolean[][] visited){
        for (int i = 0; i < 4 ; i++) {
            int newX = x + dir[i][0];
            int newY = y + dir[i][1];
           if (jundge(newX,newY, k) && !visited[newX][newY]){
                dfs(newX,newY,k,visited);
           }
        }
        visited[x][y] = true;
        res++;
    }

    private boolean jundge(int newX, int newY, int k) {
        if (newX  >= 0 && newX < m && newY >= 0 && newY < n){
            int numbers = 0;
            while (newX > 0){
                numbers += newX % 10;
                newX /= 10;
            }
            while (newY > 0){
                numbers += newY % 10;
                newY /= 10;
            }
            if (numbers < k){
                return true;
            }
        }
        return false;
    }

}
