package Interview;

import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/8/29 19:37
 * @Description:
 */
public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String line = sc.next();
        String[] strings = line.split(",");
        int[] ints = new int[n];
        int index = 0;
        for (int i = 0; i < strings.length ; i++) {
            if (strings[i].length() == 0){
                continue;
            }
            ints[index++] = Integer.parseInt(strings[i]);
        }
        sort(ints);
        for (int i = 0; i < ints.length - 1 ; i++) {
            System.out.print(ints[i] + ",");
        }
        System.out.println(ints[ints.length-1]);
    }
    public static int[] sort(int[] arrays) {
        for (int i = 1; i < arrays.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arrays.length - i; j++) {
                if (arrays[j] > arrays[j + 1]) {
                    int temp = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return arrays;
    }
}
