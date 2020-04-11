package tensorts;

import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: wky233
 * @Date: 2020/3/8 17:11
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {4,6,5,7,8,9};
        int[] helper = new int[5-4+1];
        System.arraycopy(nums,4,helper,4 , 5-4+1);
        System.out.println(helper.length);
       // CopyOnWriteArrayList
    }
}
