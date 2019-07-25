package class_05.cc150;

/**
 * @author 武凯焱
 * @date 2019/3/3 15:34
 * @Description:
 */
public class Case08_WordReverse {
    public static void main(String[] args) {
        System.out.println(solve("hello lp"));
    }
    public static String solve(String str){
        StringBuilder stringBuilder = new StringBuilder(str);
        StringBuilder string  = new StringBuilder();
        String strings = stringBuilder.reverse().toString();
        //先将整个字符串翻转 ， 然后分割后每个单词再反转
        String[] words = strings.split("\\s");
        for (int i = 0; i <words.length ; i++) {
            StringBuilder temp =  new StringBuilder(words[i]);
            string.append(temp.reverse()+" ");
        }
        return string.deleteCharAt(str.length()).toString();
     }
}
