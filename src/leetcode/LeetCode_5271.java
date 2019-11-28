package leetcode;

/**
 * @author 武凯焱
 * @date 2019/11/24 10:44
 * @Description:
 */
public class LeetCode_5271 {
    public static void main(String[] args) {
        int[][] points = {
                {1, 1},
                {3, 4},
                {-1, 0}
        };
        System.out.println(minTimeToVisitAllPoints(points));
    }

    public static int minTimeToVisitAllPoints(int[][] points) {
        if (points == null){
            return 0;
        }
        if (points.length == 1){
            return 1;
        }
        int result = 0;
        int preX = points[0][0];
        int preY = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int x = Math.abs(points[i][0] - preX);
            int y = Math.abs(points[i][1] - preY);
            preX = points[i][0];
            preY = points[i][1];
                    System.out.println(y > x ? y : x);
            result += y > x ? y : x;
        }
        return result;
    }
}
