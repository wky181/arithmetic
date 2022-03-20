package Interview.yuanfudao;

import java.util.Scanner;
public class T10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strings = new String[n];
        for (int i = 0; i < n ; i++) {
            strings[i] = sc.next();
        }
        for (String s : strings) {
            if (jundge(s)){
                System.out.println("Accept");
            }else {
                System.out.println("Wrong");
            }
        }

    }
    public static boolean jundge(String s){
        if (s == null || s.length() == 0){
            return false;
        }
        char first = s.charAt(0);
        if (!Character.isLetter(first)){
            return false;
        }
        boolean haveNumber = false;
        for (int i = 1; i < s.length() ; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)){
                haveNumber = true;
            }
            else if(!Character.isLetter(ch)){
                return false;
            }
        }
        return haveNumber;
    }
}
