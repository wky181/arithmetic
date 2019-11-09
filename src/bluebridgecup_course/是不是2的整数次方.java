package bluebridgecup_course;

import java.util.Scanner;

/**
 * @author 武凯焱
 * @date 2019/2/7 15:19
 * @Description:
 */
public class 是不是2的整数次方 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (((n-1)&n)==0){
            System.out.println(true);
        }else {
            System.out.println(false);
        }
    }
}
