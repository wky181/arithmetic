package bluebridgecup_course.cc150;

/**
 * @author 武凯焱
 * @date 2019/3/3 9:39
 * @Description:
 */
//压缩字符串
public class _1_5zipString {
    public static void main(String[] args) {
        System.out.println(solve("gggdfdhgdffs"));
        System.out.println(compress("fs".toCharArray()));
    }
    public  static  String solve(String string){

        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        int last = 0;
        for (int i = 1; i <string.length() ; i++) {
            if (string.charAt(i)==string.charAt(last)){
                count++;
            }else {
                if (count>1){
                    stringBuilder.append(""+string.charAt(last)+count);
                }else {
                    stringBuilder.append(""+string.charAt(last));
                }
                last = i;
                count = 1;
            }
            if (i == string.length()-1){
                if (count>1){
                    stringBuilder.append(""+string.charAt(i)+count);
                }else {
                    stringBuilder.append(""+string.charAt(i));
                }
            }
        }

        return stringBuilder.toString();
    }
    public static   int compress(char[] chars) {
        if (chars.length==1){
            return 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        int last = 0;
        for (int i = 1; i < chars.length ; i++) {
            if (chars[i]==chars[last]){
                count++;
            }else {
                if (count>1){
                    stringBuilder.append(""+chars[last]+count);
                }else {
                    stringBuilder.append(""+chars[last]);
                }
                last = i;
                count = 1;
            }
            if (i == chars.length-1){
                if (count>1){
                    stringBuilder.append(""+chars[i]+count);
                }else {
                    stringBuilder.append(""+chars[i]);
                }
            }
        }
        chars = stringBuilder.toString().toCharArray();
        return stringBuilder.toString().toCharArray().length;
    }
}
