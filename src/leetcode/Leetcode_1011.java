package leetcode;

/**
 * @author 武凯焱
 * @date 2019/11/2 16:10
 * @Description:
 */
public class Leetcode_1011 {
    public static void main(String[] args) {
        int[] weights = {3,2,2,4,1,4};
        System.out.println(shipWithinDays(weights,3));

    }
    public static int shipWithinDays(int[] weights, int D) {
        int sum = 0;
        for (int i = 0; i <weights.length ; i++) {
            sum+=weights[i];
        }
        float target = sum/(float)D;
        System.out.println(target);
        int result = 0;
        int sums = 0;
        for (int i = 0; i <weights.length ; i++) {
            if (sums<target){
                sums+=weights[i];
            }else {
                result = Math.max(result,sums);
                sums = 0;
            }
        }
        return result;
    }

}
