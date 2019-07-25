package leetcode;

import java.util.Arrays;

/**
 * @author 武凯焱
 * @date 2019/7/20 15:31
 * @Description:
 */
public class 柠檬水找零 {
    public static void main(String[] args) {
        int bills[] = {5,5,5,5,20,20,5,5,5,5};
        System.out.println(lemonadeChange(bills));
    }
    public static boolean lemonadeChange(int[] bills) {
        if (bills[0]==10 || bills[0]==20){
            return false;
        }
        int i = 0;
        int count = 1;
        int temp = 0;
        while (count>0){
            if (i==bills.length) {
              return true;
            }
            if (bills[i]==5) {
                count++;
            }
            else if (bills[i]==10){
                count--;
                temp++;
            }
            else {
                if (temp>0){
                    temp--;
                    count--;
                }
                else if (temp<=0 && count>=3){
                    count-=3;
                }
                else {
                    return false;
                }
            }
            i++;
        }
        return false;
    }
}
