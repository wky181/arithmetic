package LeetCodeSecond.weekrank;

/**
 * @Author: wky233
 * @Date: 2020/7/19 10:30
 * @Description:
 */
public class LeetCode_5464 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int nums = 0;
        while (numBottles >= numExchange){
           int exchange  =   numBottles / numExchange;
           nums += exchange * numExchange;
           numBottles = exchange +  (numBottles % numExchange);
        }
        return nums + numBottles;
    }
}
