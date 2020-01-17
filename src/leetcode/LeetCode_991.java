package leetcode;

/**
 * @author 武凯焱
 * @date 2019/12/7 16:51
 * @Description:
 */
public class LeetCode_991 {

    public static void main(String[] args) {
        System.out.println(brokenCalc(1,7));
    }
    public static int brokenCalc(int X, int Y) {
        if (Y <= X){
            return X - Y;
        }else {
            if (Y%2==0){
               return 1 + brokenCalc(X,Y/2);
            }else {
                return 1 + brokenCalc(X,Y+1);
            }
        }
    }
}
