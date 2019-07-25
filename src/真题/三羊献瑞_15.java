package 真题;

/**
 * @author 武凯焱
 * @date 2019/3/22 20:33
 * @Description:
 */
//暴力 1065
public class 三羊献瑞_15 {
    public static void main(String[] args) {
        for (int d = 0; d <=9 ; d++) {
            for (int w = 0; w <=9 ; w++) {
                if (w!=d)
                for (int z = 0; z <=9 ; z++) {
                    if (z!=w && z!=d)
                    for (int c = 0; c <=9 ; c++) {
                        if (c!=w && c!=d && c!=z)
                        for (int x = 0; x <=9 ; x++) {
                            if (x!=w && x!=d && x!=z && x!=c)
                            for (int y = 0; y <=9 ; y++) {
                                if (y!=w && y!=d && y!=z && y!=c && y!=x)
                                for (int a = 0; a <=9 ; a++) {
                                    if (a!=w && a!=d && a!=z && a!=c && a!=x && a!=y)
                                    for (int b = 0; b <=9 ; b++) {
                                        if (b!=w && b!=d && b!=z && b!=c && b!=x && b!=y && b!=a){
                                            int num  = d*1000+w*100+z*10+c;
                                            int num1 = x*1000+ y*100 + a*10 + w;
                                            int sum = x*10000+y*1000+z*100+w*10+b;
                                            if (num+num1==sum){
                                                System.out.println(x+" "+ y+" "+z+" "+w+" "+a+" "+b+" "+c+" "+d);
                                            }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            }
        }
    }
}
