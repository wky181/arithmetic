package leetcode;
import	java.util.Arrays;

/**
 * @author 武凯焱
 * @date 2019/10/19 14:45
 * @Description: leetcode_204
 */
public class leetcode_204 {
    public static void main(String[] args) {
        System.out.println( countPrimes(2));

    }
    //超时算法
   public static int primeNumber(int n){
        if (n == 2){
            return 0;
        }
        int count = 0;
        for (int i = 2; i <n ; i++) {
           if(isPrime(i)){
               count +=1;
           }
           
       }
       return count;
    }
    public static boolean isPrime(int n){
        for (int i = 2;  i<=Math.sqrt(n); i++) {
            if (n%i==0 ) {
                return  false;
            }
        }
        return true;
    }
    public  static  int countPrimes(int n) {
       boolean[] isPrime = new boolean [n];
       Arrays.fill(isPrime ,true);
        for (int i = 2; i <Math.sqrt(n) ; i++) {
            if (isPrime[i]){
                // i 的倍数不可能是素数了
                for (int j = i*i; j <n ; j+=i) {
                    isPrime [j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i <n ; i++) {
            if (isPrime [i]){
                count++;
            }
        }
        return count;
    }
}
