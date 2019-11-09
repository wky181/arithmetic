package bluebridgecup_course.cc150;

/**
 * @author 武凯焱
 * @date 2019/3/3 8:33
 * @Description:
 */
public class _1_4Relacement {
    public static void main(String[] args) {
        String str  =  "gdfg fd sf";
        char[] ss =  str.trim().toCharArray();
        System.out.println(str.replaceAll("\\s","20%"));
        System.out.println(solve(ss,ss.length));
    }
    public static String solve(char[] inString , int length){

        int count =0;
        for (int i = 0; i < length; i++) {
            if (inString[i] == ' '){
                count+=2;
            }
        }
        char[] temps = new char[length+count];
        int p = length-1;
        int r = p+count;
        for (int i = p; i >=0 ; i--) {
            if (inString[i] == ' '){
                temps[r--] = '0';
                temps[r--] = '2';
                temps[r--] = '%';
            }
            else {
                temps[r--] = inString[i];
            }
        }
    return new String(temps);
    }
}
