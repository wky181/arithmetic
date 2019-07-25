package class_05.cc150;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 武凯焱
 * @date 2019/3/3 10:32
 * @Description:
 */
public class _1_6hashSameCharSet {
    public static void main(String[] args) {
        String str1 = "ssstring";
        String str2 = "stsringsd";
        System.out.println(check1(str1,str2));
    }
    public static boolean check(String str1 ,String str2){
        int help[] = new int[128];
        for (int i = 0; i <str1.length() ; i++) {
            char c= str1.charAt(i);
            if (help[(int)c] == 0){
                help[(int)c]++;
            }
        }
        for (int i = 0; i < str2.length() ; i++) {
            char c = str2.charAt(i);
            if (help[(int)c] == 0 ){
                return  false;
            }
        }
        return true;
    }
    public static boolean check1(String str1 , String str2){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <str1.length() ; i++) {
            char c= str1.charAt(i);
            map.put((int)c,1);
        }
        for (int i = 0; i <str2.length() ; i++) {
            if (map.get(new Integer(i)) == null ){
                return false;
            }
        }
        return false;
    }
}
