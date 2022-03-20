package LeetCodeSecond.weekrank;

/**
 * @Author: wky233
 * @Date: 2020/7/25 22:30
 * @Description:
 */
public class LeetCode_11111 {
    public int countOdds(int low, int high) {
        int count = 0;
        for (int i = low; i <= high ; i++) {
            if ((i & 1) == 1){
                count++;
            }
        }
        return count;
    }
}
