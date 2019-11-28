package leetcode;

public class LeetCode_134 {
    public static void main(String[] args) {
        int[] gas = {5, 5, 1, 3, 4};
        int[] cos = {8, 1, 7, 1, 1};
        System.out.println(canCompleteCircuit(gas, cos));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        boolean[] flag = new boolean[gas.length];
        int[] res = new int[gas.length];
        int index = 0;
        int result = 0;
        int currnt = 0;
        for (int i = 0; i < gas.length; i++) {
            res[i] = gas[i] - cost[i];
            result += gas[i] - cost[i];
            currnt += gas[i] - cost[i];
            //重点代码
            if (currnt < 0) {
                currnt = 0;
                index = i+1;
            }
        }
        return result >= 0 ? index : -1; 
    }

}
