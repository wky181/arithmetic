/**
 * @author 武凯焱
 * @date 2019/2/7 16:20
 * @Description:
 */
public class 整数奇偶位互换 {
    public static void main(String[] args) {
        System.out.println(sw(9));
    }

    public static int sw(int n) {
        int ou = n & 0xaaaaaaaa;//10101010 取奇数位
        int ji = n & 0x55555555;//010101010 //取偶数位
        return (ou>>1)^(ji<<1);
    }
}
