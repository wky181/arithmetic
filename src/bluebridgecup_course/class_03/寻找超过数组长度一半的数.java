package bluebridgecup_course.class_03;

import java.util.Arrays;

/**
 * @author 武凯焱
 * @date 2019/2/19 9:32
 * @Description:
 */
public class 寻找超过数组长度一半的数 {
    public static void main(String[] args) {
        int [] arr = {1,4,2,4,3,4,5,4,7,4};
        System.out.println(findNum3(arr));
    }
    // 用快排  时间复杂度 O(n logN)
    static int findNum(int[] arr){
        Arrays.sort(arr);
        return arr[arr.length/2];
    }
    //顺序查找 时间复杂度 O(n)
    static int findNum1(int[] arr){
        return 乱序中找第k大的数.quickSelcet(arr,0,arr.length-1,arr.length/2);
    }

    //用 消除法  时间复杂度 O(n)
    static int findNum2(int[] arr){
        int candidate = arr[0];
        int times = 0;
        for (int i = 0; i <arr.length ; i++) {
            if (times == 0){
                candidate = arr[i];
                times = 1;
                continue;
            }
            if (candidate!=arr[i]){
                times--;
            }
            else {
                times++;
            }
        }
        return candidate;
    }
    //变化，出现次数恰好为个数的一半，求出这个数
  /*
  * 关于加强版水王的题我有个想法可以扫描一遍数组就解决问题：
    水王占总数的一半，说明总数必为偶数；
    不失一般性，假设隔一个数就是水王的id，两两不同最后一定会消减为0
    水王可能是最后一个元素，每次扫描的时候，多一个动作，和最后一个元素做比较，单独计数，计数恰好等于一半
    如果不是，计数不足一半，那么去掉最后一个元素，水王就是留下的那个candidate*/
    static int findNum3(int[] arr){
        int candidate = arr[0];
        int times = 0;
        int lastIndexOf = 0;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]==arr[arr.length-1]){
                lastIndexOf++;
            }
            if (times==0){
                candidate = arr[i];
                times++;
                continue;
            }
            if (arr[i] == candidate ){
                times++;
            }else {
                times--;
            }

        }
        if (lastIndexOf==arr.length/2){
            return arr[arr.length-1];
        }
        return candidate;
    }
}
