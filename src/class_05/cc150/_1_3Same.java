package class_05.cc150;

import java.util.Arrays;

/**
 * @author 武凯焱
 * @date 2019/3/2 21:52
 * @Description:
 */
public class _1_3Same {
    //变形词
    public static void main(String[] args) {
        System.out.println(solve("dssd","adds"));
    }
    public static boolean solve(String strA , String strB){
        if (strA.length()!=strB.length()){
            return false;
        }
        char[] charsA = strA.toCharArray();
        char[] charsB = strB.toCharArray();
        Arrays.sort(charsA);
        Arrays.sort(charsB);
        for (int i = 0; i <charsA.length ; i++) {
            if (charsA[i] != charsB[i]){
                return false;
            }
        }
        return true;
    }

}
