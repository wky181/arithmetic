import java.util.Scanner;

/**
 * @author 武凯焱
 * @date 2019/2/13 21:29
 * @Description:
 */
public class 小白上楼梯 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            int n = sc.nextInt();
            System.out.println(climb(n));
        }

    }
    public static int climb(int n){
        if (n==0 || n == 1 ){
            return 1;
        }
        else if (n==2){
            return 2;
        }
        else if (n<0){
            return 0;
        }
        return climb(n-1)+climb(n-2)+climb(n-3);
    }
}
