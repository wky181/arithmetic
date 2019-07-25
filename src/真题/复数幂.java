package 真题;

import java.io.FileNotFoundException;
import java.math.BigInteger;

/**
 * @author 武凯焱
 * @date 2019/3/12 19:53
 * @Description:
 */
public class 复数幂 {
    public static void main(String[] args) throws FileNotFoundException {
        BigInteger a = new BigInteger("2");
        BigInteger b = new BigInteger("3");
        BigInteger a1 = new BigInteger("2");
        BigInteger b1 = new BigInteger("3");
        for(int i=1;i<=123455;i++){
            BigInteger ta = a;
            a=a.multiply(a1).subtract(b.multiply(b1));
            b=ta.multiply(b1).add(b.multiply(a1));
        }
        System.out.println(a+(b.compareTo(BigInteger.ZERO)>0?"+":"")+b);
    }
    public static void solve(){
    }
}
