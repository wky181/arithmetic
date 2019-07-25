package 真题;

/**
 * @author 武凯焱
 * @date 2019/3/22 19:15
 * @Description:
 */
public class 立方变自身_15 {
    public static void main(String[] args){
        for (int i = 1; i < 1000000; i++) {
            int number = (int)Math.pow(i,3);
            if (solve(number,i)){
                System.out.println(i);
            }
        }
    }
    public static boolean solve(int num,int target){
        int res = 0;
        String str = ""+num;
        for (int i = 0; i <str.length(); i++) {
            res += Integer.parseInt(""+str.charAt(i));
        }
        return  target==res;
    }

}
