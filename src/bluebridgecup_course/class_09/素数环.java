package bluebridgecup_course.class_09;

/**
 * @author 武凯焱
 * @date 2019/3/16 20:07
 * @Description:
 */
public class 素数环 {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] rec = new int[n];
        rec[0] = 1;
        solve(1,rec,n);*/
      //  System.out.println(gcd(12,8));
        System.out.println(isPd(7));
    }
    public static void solve(int k ,int[] rec ,int n){
        if (k==n && isP(rec[n-1]+rec[0])){
            print(rec);
            return;
        }
        for (int i = 2; i <=n; i++) {
            if (check(rec,i,k)){
                rec[k] = i;
                solve(k+1,rec,n);
                rec[k] = 0;
            }
        }
    }
     static boolean check(int[] r, int i , int cur){
        for (int e: r
             ) {
            if (i==e || !isP(r[cur - 1] + i)){
                return false;
            }
        }
        return true;
    }
    private static boolean isP(int k){
        for (int i = 2; i*i <= k; i++) {
            if ( k%i == 0){
                return false;
            }
        }
        return true;
    }
    private static void print(int[] r) {
        for (int i = 0; i < r.length; i++) {
            System.out.print(r[i] + (i == r.length - 1 ? "" : " "));
        }
        System.out.println();
    }
    //求最大公约数
    public static int gcd(int a ,int b){
        if (a%b==0){
            return b;
        }else return gcd(b,a%b);
    }
    //判斷是否素數
    public static boolean isPd(int a){
        for (int i = 2; i <=Math.sqrt(a) ; i++) {
            if (a%2==0){
                return false;
            }
        }
        return true;
    }
}
