package class_05.cc150;


/**
 * @author 武凯焱
 * @date 2019/3/3 16:05
 * @Description:
 */
public class case09_RemoveKZeros {
    public static void main(String[] args) {
        System.out.println(solve(3,"100001"));
    }
    public static  String solve(int k, String src){
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (int i = 0; i <src.length() ; i++) {
            char c= src.charAt(i);
            if (c=='0'){
                count++;
            }else{
                for (int j = 0; j <count%k; j++) {
                    stringBuilder.append("0");
                }
                stringBuilder.append(""+c);
            }
        }
        return stringBuilder.toString();
    }

}
