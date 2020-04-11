package Interview.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/4/4 0:10
 * @Description:
 */
public class Test11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long nums = sc.nextLong();
        for (int i = 0; i < nums ; i++) {
          long count =  sc.nextLong();
            long[] numbers = new long[(int)count];
            for (int j = 0; j < count ; j++) {
                numbers[j] = sc.nextLong();
            }
            Arrays.sort(numbers);
            boolean b = numbers[(int)count-1] - numbers[(int)count-2] < numbers[0];
            if (!b ){
                if (count == 3){
                    System.out.println("NO");
                }else {
                    boolean a = numbers[(int)count-1] - numbers[(int)count-2] < numbers[(int)count-3];
                    if (a) {
                        System.out.println("YES");
                    }else {
                        System.out.println("NO");
                    }
                }
            }else {
                System.out.println("YES");
            }
        }
    }
}
