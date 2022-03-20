package Interview.jingdong;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/4/18 15:24
 * @Description:
 */
public class LeetCode3 {
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int[] res = new int[requirements.length];
        boolean[] visted = new boolean[requirements.length];
        Arrays.fill(res, -1);
        long C = 0;
        long R = 0;
        long H = 0;
        mark(C,R,H,requirements,res,visted,0);
        int[][] Ci = new int[requirements.length][requirements.length];
        Arrays.sort(Ci,(o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < requirements.length ; i++) {
            Ci[i] = new int[]{requirements[i][0], i};
        }
        for (int i = 0; i < increase.length; i++) {
            C += increase[i][0];
            R += increase[i][1];
            H += increase[i][2];
            mark(C,R,H,requirements,res,visted,i+1);
        }
        return res;
    }
    public void mark(long C, long R, long H,int[][] requirements, int[] res , boolean[] visted,int day){

        for (int i = 0; i < requirements.length; i++) {
            if (visted[i]){
                continue;
            }
            if (C >= requirements[i][0] && R >= requirements[i][1] && H >= requirements[i][2]){
                visted[i] = true;
                res[i] = day;
            }
        }
    }
    public int find(int[][] Ci ,int target){
        int left = 0;
        int right = Ci.length-1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (Ci[mid][0] == target){
                left = mid+1;
            }else if (Ci[mid][0] < target){
                left = mid + 1;
            }else {
                right = mid-1;
            }
        }
        return -1;
    }
}
