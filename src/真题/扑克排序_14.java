package 真题;


/**
 * @author 武凯焱
 * @date 2019/3/21 9:16
 * @Description:
 */
public class 扑克排序_14 {
    public static void main(String[] args) {
        String str = "AA223344";
        solve(str.toCharArray(),0);

    }
    //全排列
    public static void solve(char[] chars,int k){
        if (k==chars.length){
            String str = new String(chars);
            if (str.lastIndexOf("A")-str.indexOf("A") == 2 &&
                    str.lastIndexOf("2")-str.indexOf("2") == 3 &&
                    str.lastIndexOf("3")-str.indexOf("3") == 4 &&
                    str.lastIndexOf("4")-str.indexOf("4") == 5
                    ){
                System.out.println(str);
            }
            return;
        }
        for (int i = k; i < chars.length; i++) {
            swap(i,k,chars);
            solve(chars,k+1);
            swap(i,k,chars);
        }

    }
    public static void swap(int i, int j,char[] chars){
        char ch = chars[i];
        chars[i] = chars[j];
        chars[j] = ch;
    }
}
