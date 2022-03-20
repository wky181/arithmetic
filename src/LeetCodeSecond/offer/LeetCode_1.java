package LeetCodeSecond.offer;

/**
 * @Author: wky233
 * @Date: 2020/6/19 16:33
 * @Description: 位运算 模拟hash
 */
public class LeetCode_1 {
/*    public static void main(String[] args) {
        System.out.println((int));
    }*/
    public boolean isUnique(String astr) {
        int mark = 0;
        char[] arrays = astr.toCharArray();
        for (int i = 0; i < arrays.length ; i++) {
            int moveCount = arrays[i] - 'a';
            if ((mark & (1 << moveCount)) == 1){
                return false;
            }else {
                mark = mark | (1 << moveCount);
            }
        }
        return false;
    }
}
