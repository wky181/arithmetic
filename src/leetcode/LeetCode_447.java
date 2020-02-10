package leetcode;

import java.util.HashMap;

/**
 * @Author: wky233
 * @Date: 2020/2/4 22:30
 * @Description:
 */
public class LeetCode_447 {
    public static void main(String[] args) {
        int[][] points = {
                {0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };
        System.out.println(new LeetCode_447().numberOfBoomerangs(points));
    }

    public int numberOfBoomerangs(int[][] points) {

        int res = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int dis = getDis(points[i][0], points[i][1], points[j][0], points[j][1]);
                if (hashMap.containsKey(dis)) {
                    res += hashMap.get(dis)*2;
                    hashMap.put(dis, hashMap.get(dis) + 1);

                } else {
                    // 统计i与其它点距离相同的次数
                    hashMap.put(dis, 1);
                }

            }
        }
            return res;

    }

    public int getDis(int x, int y, int i, int j){
        return (x-i)*(x-i) + (y-j)*(y-j);
    }
}
