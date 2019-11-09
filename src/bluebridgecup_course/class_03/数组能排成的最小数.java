package bluebridgecup_course.class_03;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 武凯焱
 * @date 2019/2/22 21:12
 * @Description:
 */
public class 数组能排成的最小数 {
    public static void main(String[] args) {
        Integer[] arr = {3,32,321};
        System.out.println(f(arr));
    }
    public  static int f(Integer[] arr){
        //自定义jdk快排的排序规则
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 =""+ o1 + o2;
                String str2 = "" +o2 + o1;
                return str1.compareTo(str2);
            }
        });
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i]+" ");
            sb.append(arr[i]);
        }
        return Integer.parseInt(sb.toString());
    }
}
