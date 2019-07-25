package 真题;

/**
 * @author 武凯焱
 * @date 2019/3/21 8:11
 * @Description:
 */
public class 奇怪的分式_14 {
    public static void main(String[] args) {
        for (int i = 1; i <=9 ; i++) {
            for (int j = 1; j <=9 ; j++) {
                if (i!=j) {
                    for (int k = 1; k <=9 ; k++) {
                        for (int l = 1; l <=9 ; l++) {
                            if (k!=l){
                                int g1 = gcd(i*k,j*l);
                                int g2 = gcd(i*10+k,j*10+l);
                                if ((i*k)/g1 == (i*10+k)/g2 && (j*l)/g1 == (j*10+l)/g2){
                                    System.out.println(i+"/"+j +"*****" + k +"/"+l );
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    public static int gcd(int a , int b){
        if (a%b == 0){
            return b;
        }
        return gcd(b,a%b);
    }
}
