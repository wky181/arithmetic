package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 武凯焱
 * @date 2019/10/5 14:48
 * @Description:
 */
public class 自除数 {
    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(1,22));
    }
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>(right-left+1);
        for (int i = left; i <=right ; i++) {
            if (isDividingNumbers(i)){
                list.add(i);
            }
        }
        return list;
    }
    public static boolean isDividingNumbers(int number){
      int num = number;
        while (num>0){
            int temp = num%10;
            if (temp==0 || number%temp !=0){
                return false;
            }
            num = num/10;

        }
        return true;
    }
}
