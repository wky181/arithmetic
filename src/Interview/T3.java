package Interview;

import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/8/29 19:16
 * @Description:
 */
public class T3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int start = 0;
        int end = line.length()-1;
        char[] array = line.toCharArray();
        while (start < array.length && array[start] == '_'){
            start++;
        }
        while (end < array.length && array[end] == '_' ){
            end--;
        }
        boolean mark = false;
        for (int i = start; i <= end ; i++) {
            if (array[i] == '_' && !mark){
                System.out.print('_');
                mark = true;
                continue;
            }
            if (array[i] != '_'){
                System.out.print(array[i]);
                mark = false;
            }
        }
    }
}
