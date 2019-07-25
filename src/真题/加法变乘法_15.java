package 真题;

/**
 * @author 武凯焱
 * @date 2019/3/22 21:41
 * @Description:
 */
public class 加法变乘法_15 {
    //减去变化的量
    public static void main(String[] args) {
        for (int i = 1; i <=46 ; i++) {
            for (int j = i+2; j <=48 ; j++) {
                int ch1 = 1225-(i+1+i)-(j+1+j);
                int ch2 = 2015-(i*(i+1))-(j*(j+1));
                if (ch1==ch2){
                    System.out.println(i);
                }
            }
            
        }

    }
}
