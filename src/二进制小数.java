import java.util.Scanner;

/**
 * @author 武凯焱
 * @date 2019/2/7 15:02
 * @Description:
 */
public class 二进制小数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num = sc.nextDouble();
        StringBuffer sbf = new StringBuffer("0.");
        while (num>0){
            num = num*2;
            if (num>=1){
                num = num-1;
                sbf.append("1");
            }
            else{
                sbf.append("0");
            }
            if (sbf.length()>34){
                System.out.println("ERROR");
                return;
            }
        }
        System.out.println(sbf);
    }
}
