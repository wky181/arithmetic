package bluebridgecup_course.cc150;

/**
 * @author 武凯焱
 * @date 2019/3/2 21:35
 * @Description:
 */
public class _1_1Different {
    public static void main(String[] args) {
        System.out.println(solve("sfhcgc"));
    }
    public  static boolean solve(String string){
        int[] helper = new int[127];
        int j ;
        for (int i = 0; i <string.length() ; i++) {
            j = (int)string.charAt(i);
            if (helper[j]>0){
                return  false;
            }else
            helper[j]++;
        }
        return true;
    }

}
