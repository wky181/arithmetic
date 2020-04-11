package NewCoder.zhaohang;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/4/8 18:55
 * @Description:
 */
public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Character, Character> hashMap = new HashMap<Character, Character>();
        hashMap.put('1', '1');
        hashMap.put('2', '5');
        hashMap.put('3', '8');
        hashMap.put('4', '7');
        hashMap.put('5', '2');
        hashMap.put('6', '9');
        hashMap.put('7', '4');
        hashMap.put('8', '3');
        hashMap.put('9', '6');
        String[] strings = new String[n];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = sc.next();
        }
        for (int i = 0; i < strings.length; i++) {
            System.out.println(jun(strings[i], hashMap));
        }

    }

    public static boolean jun(String string, HashMap<Character, Character> hashMap) {
        StringBuilder builder = new StringBuilder(string);
        builder.reverse();
        for (int i = 0; i < string.length(); i++) {
            if (hashMap.get(string.charAt(i)) != builder.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}