package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/5/2 22:41
 * @Description:
 */
public class LeetCode_5385 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_5385().maxDiff(1101057));
    }
    public int maxDiff(int num) {
        String max = num + "";
        String min = max;
        char[] array = max.toCharArray();
        for (int i = 0; i < array.length ; i++) {
            if (array[i] != '9'){
               max = max.replaceAll(array[i]+ "", "9");
               break;
            }
        }
        System.out.println(max);
        char first = array[0];
        if (first != '1'){
            min = min.replaceAll(first + "","1");
        }else {
            for (int i = 1; i < array.length; i++) {
                if (array[i] != '0' && array[i] != '1'){
                    min = min.replaceAll(array[i]+ "", "0");
                    break;
                }
            }
        }
        System.out.println(min);
        return Integer.parseInt(max) - Integer.parseInt(min);
    }
}
