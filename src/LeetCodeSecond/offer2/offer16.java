package LeetCodeSecond.offer2;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: wky233
 * @Date: 2020/9/10 11:05
 * @Description:
 */
public class offer16 {
    public double myPow(double x, int n) {
        double res  =  pow(x, Math.abs(n));
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap();
        map.put(1,2);
        return  n < 0 ? 1 / res : res;
    }
    public double pow(double x, int n) {
        if (n == 0){
            return 1;
        }
        if ((n % 2) == 0){
            double res = pow(x, n / 2);
           return  res * res;
        }else {
            return pow(x, n - 1) * x;
        }
    }

    public static void main(String[] args) {
        List<String> l1 = new ArrayList<String>();
        List<Integer> l2 = new ArrayList<Integer>();
        System.out.println(l1.getClass() == l2.getClass());
    }
}
