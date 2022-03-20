package LeetCodeSecond.graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: wky233
 * @Date: 2020/7/8 23:32
 * @Description:
 */
public class LeetCode_773 {
    private int R;
    private int C;
    // 四联通问题
    int[][] dirs = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };
    public int slidingPuzzle(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0){
            return 0;
        }
        R = board.length;
        C = board[0].length;
        String s = arrayToString(board);
        //   System.out.println(s);
        if (s.equals("123450")){
            return 0;
        }
        HashMap<String,Integer> visited = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        visited.put(s,0);
        while (!queue.isEmpty()){
            String top = queue.poll();
            ArrayList<String> nexts  = getNexts(top);
            for (String next : nexts) {
                if (!visited.containsKey(next)){
                    visited.put(next,visited.get(top)+1);
                    queue.offer(next);
                    if (next.equals("123450")){
                        return visited.get(next);
                    }
                }
            }
        }
        return -1;
    }

    private ArrayList<String> getNexts(String s) {
        ArrayList<String> arrayList = new ArrayList<>();
        int[][] array = stringToArray(s);
        //   System.out.println( array.length + " " + array[0].length);
        int zero = 0;
        for (int i = 0; i < R ; i++) {
            for (int j = 0; j < C; j++) {
                if (array[i][j] == 0){
                    zero = i * C + j;
                }
            }
        }
        int zx = zero / C;
        int zy = zero % C;
        for (int i = 0; i < 4 ; i++) {
            int nextX = zx + dirs[i][0];
            int nextY = zy + dirs[i][1];
            if (isVaild(nextX,nextY)){
                swap(array,zx,zy,nextX,nextY);
                arrayList.add(arrayToString(array));
                swap(array,zx,zy,nextX,nextY);
            }
        }
        return arrayList;
    }

    private void swap(int[][] array, int zx, int zy, int nextX, int nextY) {
        int temp = array[zx][zy];
        array[zx][zy] = array[nextX][nextY];
        array[nextX][nextY] = temp;
    }

    public boolean isVaild(int x, int y){
        return x >= 0 && x < R && y >= 0 && y < C;
    }
    public String arrayToString(int[][] grid){
        //  System.out.println(grid.length + " " + grid[0].length);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid[0].length ; j++) {
                sb.append(grid[i][j]);
            }
        }
        //  System.out.println(sb.toString());
        return sb.toString();
    }
    public int[][] stringToArray(String s){
        int[][] grid = new int[R][C];
        for (int i = 0; i < s.length() ; i++) {
            //        System.out.println(s.length() + " " + C);
            grid[i / C][i % C] = s.charAt(i) - '0';
        }
        return grid;
    }
}
