package leetcode;

/**
 * @author 武凯焱
 * @date 2019/11/24 11:14
 * @Description:
 */
public class LeetCode_5272 {
    static int res = 0;

    public static void main(String[] args) {
        int[][] grid = {
                {1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}
        };
        System.out.println(countServers(grid));
    }
    public static int countServers(int[][] grid) {
            dfs(grid);
            return res;
    }

    public static void dfs(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && jundge(grid, i, j)) {
                    findDfs(grid, i, j);
                }
            }
        }
    }

    public static void findDfs(int[][] grid, int x, int y) {
        grid[x][y] = 0;
        res++;
        if (x - 1 > 0 && grid[x - 1][y] == 1) {
            findDfs(grid, x - 1, y);
        }
        if (x + 1 < grid.length && grid[x + 1][y] == 1) {
            findDfs(grid, x + 1, y);
        }
        if (y - 1 > 0 && grid[x][y - 1] == 1) {
            findDfs(grid, x, y - 1);
        }
        if (y + 1 < grid[0].length && grid[x][y + 1] == 1) {
            findDfs(grid, x, y + 1);
        }
    }

    public static boolean jundge(int[][] grid, int x, int y) {
        if (x - 1 > 0 && grid[x - 1][y] == 1) {
            return true;
        } else if (x + 1 < grid.length && grid[x + 1][y] == 1) {
            return true;
        } else if (x - 1 > 0 && grid[x - 1][y] == 1) {
            return true;
        } else if (y + 1 < grid[0].length && grid[x][y + 1] == 1) {
            return true;
        } else if (y - 1 > 0 && grid[x][y - 1] == 1) {
            return true;
        }
        return false;
    }
}
