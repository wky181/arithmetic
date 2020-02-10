package leetcode;

import java.util.HashMap;

/**
 * @Author: wky233
 * @Date: 2020/2/5 22:09
 * @Description:
 */
public class LeetCode_149 {
    public static void main(String[] args) {
        int[][] points = {
                {-4,-4},{-8,-582},{-3,3},{-9,-651},{9,591}
        };
        System.out.println(new LeetCode_149().maxPoints(points));
    }


    public int maxPoints(int[][] points) {
        if (points.length == 0){
            return 0;
        }
            int res = 1;
            for (int i = 0; i < points.length; i++) {
                HashMap<String, Integer> hashMap = new HashMap<>();
                //记录重复点个数
                int chongfu = 0;
                int max = 0;
                for (int j = i + 1; j < points.length; j++) {
                    if (i == j) {
                        continue;
                    } else if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                        chongfu++;
                        continue;
                    }
                    String slope = getSlope(points[i][0], points[i][1], points[j][0], points[j][1]);
                    //        System.out.println(slope);
                    if (hashMap.containsKey(slope)) {
                        int temp = hashMap.get(slope) + 1;
                        hashMap.put(slope, temp);
                        max = Math.max(max, temp);
                    } else {
                        max = Math.max(max, 2);
                        hashMap.put(slope,2);
                    }
                }
                if (hashMap.size() == 0) {
                    res = Math.max(res,chongfu+1);
                }else {
                    res = Math.max(res,chongfu+max);
                }
             //   System.out.println(res);
            }
            //        System.out.println("**************");
            return res;
        }

        public String getSlope(int x, int y, int i, int j) {
            double a = x - i;
            double b = y - j;
            if (x - i == 0) {
                return "Y" + y;
            } else if (y - j == 0) {
                return "X" + x;
            }
            return String.format("%.16f", a / b);
        }
}
