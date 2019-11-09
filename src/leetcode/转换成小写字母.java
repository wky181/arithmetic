package leetcode;

/**
 * @author 武凯焱
 * @date 2019/10/14 14:57
 * @Description:
 */
public class 转换成小写字母 {
    public static void main(String[] args) {
       for (int i = 0; i <255 ; i++) {
            char character = (char) i;
            System.out.println(i+": "+character+" ");
        }
     //   System.out.println(upCase("StrInG"));
    }
    public static String upCase(String str){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c<91 && c>64){
                c = (char) (c+32);
            }
            result.append(c);
        }
        return result.toString();
    }
    
}
