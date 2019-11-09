package bluebridgecup_course.class_09;
import java.util.ArrayList;
import java.util.List;
/**
 * @author 武凯焱
 * @date 2019/3/8 20:01
 * @Description:
 */
public class _9_5全排列I {
    static List<String> res = new ArrayList<>();
    public static void main(String[] args) {
       /* char[] arr = "ABC".toCharArray();
        solve(arr,0);
        for (String ch: res
             ) {
            System.out.println(ch);
        }*/
        permutation("","ABCD".toCharArray());
    }
    public static void solve(char[] arr,int k){
        if (k==arr.length){ //排好了一种情况,递归的支路走到底了
            res.add(new String (arr));
            return;
        }
        //从k位开始的每个字符,都尝试放在新排列的k这个位置
        for (int i = k; i < arr.length ; i++) {
            swap(arr,i,k); //把k后面每个字符换到k位
            solve(arr,k+1);
            swap(arr,i,k);//回溯
        }
    }
     static void  swap(char[] arr ,int i , int j){
        char temp = arr[i];
        arr[i]  = arr[j];
        arr[j] =  temp;
    }

    /**
     * 按照字典序的全排列
     * @param prefix
     * @param arr
     */
    private static void permutation(String prefix,char[] arr){
        if (prefix.length() == arr.length){
            System.out.println(prefix);
            return;
        }
        for (int i = 0; i <arr.length ; i++) {
            char ch  = arr[i];
            if (count(prefix.toCharArray(),ch)<count(arr,ch)){
                //这个字符可用，在pre中出现的次数<在数组中的出现次数
                permutation(prefix+ch,arr);
            }
        }
    }
    private static int count(char[] arr , char ch){
        int count = 0;
        for (char c: arr) {
            if (c == ch){
                count++;
            }
        }
        return count;
    }
}
