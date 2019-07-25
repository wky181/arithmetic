import java.util.Arrays;

/**
 * @author 武凯焱
 * @date 2019/2/15 17:15
 * @Description:
 */
public class a的n次幂 {
    public static void main(String[] args) {
        System.out.println(pow(2,10));
    }
/*    public static int pow(int a,int n){
        if (n==0){
            return  1;
        }
        int res = a;
        int power = 1;
        while ((power<<1)<=n){
            res*=res;
            power<<=1;
        }
        return res*pow(a,n-power);
    }*/
    public static int pow (int num , int n){
        if (n==0){
            return 1;
        }
        int res = num;
        int pow = 1;
        if (pow*2<=n){
            res*=res;
            pow*=2;
        }
        return res*pow(num,n-pow);
    }
}
