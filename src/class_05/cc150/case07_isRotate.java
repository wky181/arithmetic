package class_05.cc150;

/**
 * @author 武凯焱
 * @date 2019/3/3 15:20
 * @Description:
 */
// 判断是否旋转词
public class case07_isRotate {
    public static void main(String[] args) {
        System.out.println(solve("dasd","sdda"));
    }
    public static boolean solve(String stra , String strb){
        if (stra.length()!=strb.length()){
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(strb);
        stringBuilder.append(strb);
        return stringBuilder.toString().contains(stra);
    }
}
