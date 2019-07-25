import java.util.Scanner;

/**
 * @author 武凯焱
 * @date 2019/2/7 14:07
 * @Description:
 */
public class 一的个数 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        System.out.println(Integer.toString(n,2));
        for (int i = 0; i <32 ; i++) {
            if ((n&(1<<i))==(1<<i)){
                count++;
            }
        }
        System.out.println(count);
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
         count =0;
        for (int i = 0; i <32 ; i++) {
            if (((n>>>i)&1)==1){
                count++;
            }
        }
        System.out.println(count);
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        count=0;
        while (n!=0){
            n=(n-1)&n;
            count++;
        }
        System.out.println(count);
    }
}
