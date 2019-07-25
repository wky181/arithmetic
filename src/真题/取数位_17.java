package 真题;

/**
 * @author 武凯焱
 * @date 2019/3/19 21:41
 * @Description:
 */
public class 取数位_17 {
        static int len(int x){
            if(x<10) return 1;
            return len(x/10)+1;
        }
        // 取x的第k位数字
        static int f(int x, int k){
            if(len(x)-k==0) return x%10;
            return f(x/10,k) ;  //填空
        }

        public static void main(String[] args)
        {
            int x = 251345;
            //System.out.println(len(x));
            System.out.println(f(x,3));
        }

}
