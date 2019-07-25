package class_03;

import java.util.Arrays;

/**
 * @author 武凯焱
 * @date 2019/2/22 22:10
 * @Description:
 */
//要善用javaAPI
public class 三点29数组的包含 {
    public static void main(String[] args) {
        String str1 = "asdfg";
        String str2 = "asdfgh";
        System.out.println(isContain(str1,str2));
        System.out.println(isContain1(str1,str2));

    }
    static boolean isContain(String str1,String str2){
        for (int i = 0; i <str1.length() ; i++) {
            char ch = str1.charAt(0);
            if (str2.indexOf(ch)==-1){
                return false;
            }
        }
        return true;
    }
    static boolean isContain1(String str1,String str2){
            char[] chars = str2.toCharArray();
            Arrays.sort(chars);
        for (int i = 0; i <str1.length() ; i++) {
            char ch = str1.charAt(i);
           int index =   Arrays.binarySearch(chars,ch);
           if (index<0){
               return false;
           }
        }
        return true;
    }
}