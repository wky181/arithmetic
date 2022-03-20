package demo;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/9/20 20:35
 * @Description:
 */
public class Dxm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length() ; i++) {
            char c = str.charAt(i);
            int count = map.getOrDefault(c, 0 ) + 1;
            map.put(c, count);
        }
        String s = sc.next();
        int res = 0;
        for (int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            int count = map.getOrDefault(c,0);
            if (count > 0){
                count--;
                res++;
                map.put(c,count);
            }
        }
        System.out.println(res);
    }
}
