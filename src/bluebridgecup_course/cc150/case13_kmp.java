package bluebridgecup_course.cc150;
/**
 * @author 武凯焱
 * @date 2019/3/4 16:50
 * @Description:
 */
public class case13_kmp {
    public static void main(String[] args) {
        String s = "ABBADFS";
        String key = "AD";
        int i = s.indexOf("AC",2);
        System.out.println(i);
    }
    public static int indexOf(String s , String key){
        int i =  0;
        int p2 = i;
        int j = 0;
        int count = 0;
        while (i<s.length()){
            if (count==key.length()){
                return i - key.length()+1;
            }
            if (s.charAt(i)== key.charAt(j)){
                i++;
                j++;
                count++;

            }else {
                i = p2+1;
                p2 = i;
                j = 0;
            }
        }
        return  -1;
    }
}
