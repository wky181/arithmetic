package Interview.a360;

import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/8/24 11:04
 * @Description:
 */
public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        StringBuilder sb = new StringBuilder();
        boolean mark = true;
        for (int i = 0; i < s.length() ; i++) {
            if (mark){

                sb.append(Character.toUpperCase(s.charAt((i))));
                mark = false;
            }
            else if (s.charAt(i) == 'n'){
                System.out.println(sb.toString());
                sb = new StringBuilder();
                sb.append(Character.toUpperCase('n'));

            }else {
                sb.append(s.charAt(i));
            }
        }


        if (sb.length() > 0){
            System.out.println(sb.toString());
        }
    }
}
