package test;

import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/3/18 17:20
 * @Description:
 */
public class Test02 {
    public static void main(String[] args) {
        System.out.println(method());
    }
    public static String method  (){
        String str1 = "ABCDEFGHI";
        String str2 = "JKLMNOPQR";
        String str3 = "STUVWXYZ ";
        Scanner scanner = new Scanner(System.in);
        int mouth = scanner.nextInt();
        int day = scanner.nextInt();
        int count = (mouth-1) % 3;
        for (int i = 0; i < count ; i++) {
            String temp = str1;
            str1 = str2;
            str2 = str3;
            str3 = temp;
        }
        str1 = revers(str1,day - 1);
        str2 = revers(str2,day - 1);
        str3 = revers(str3,day - 1);
        scanner.nextLine();
        String string = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            int index = 0;
            if ((index = str1.indexOf(c)) != -1){
                stringBuilder.append(1+""+(index+1)+" ");
            }else if ((index = str2.indexOf(c)) != -1){
                stringBuilder.append(2+""+(index+1)+" ");
            }else if ((index = str3.indexOf(c)) != -1){
                stringBuilder.append(3+""+(index+1)+" ");
            }
        }
        return stringBuilder.substring(0,stringBuilder.length()-1).toString();
    }
    public static String revers(String str, int num){
        int count = num % str.length();
        String sub1 = str.substring(0, count);
        String sub2 = str.substring(count);
        str = sub2 + sub1;
        return str;
    }
}
