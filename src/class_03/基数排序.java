package class_03;

import java.util.ArrayList;

/**
 * @author 武凯焱
 * @date 2019/2/21 16:21
 * @Description:
 */
public class 基数排序 {
    private static ArrayList[] bucket  = new ArrayList[10];

    //初始化十个桶
    static {
        for (int i = 0; i < bucket.length ; i++) {
            bucket[i] = new ArrayList();
        }
    }
    public static void main(String[] args) {
        int[] arr = Util.getRandomArr(100,1,100);
        sort(arr);
        Util.print(arr);
    }
    public static void sort(int[] arr){
        int d = 1; //表示数的当前位数
        int max = Util.maxValue(arr);
        int dNum = 1;
        while ((max/10)!=0){
            dNum++;
            max/=10;
        }
        while (d<=dNum){
            putAndOutBucket(arr,d++);
        }
    }
    //
    public static  void  putAndOutBucket(int[]arr ,int d){
        //数组元素全部入桶
        for (int i = 0; i < arr.length; i++) {
            putInBucket(arr[i],getDigitOn(arr[i],d));
        }
        int current = 0;
        //桶中元素放回数组
        for (int i = 0; i <bucket.length ; i++) {
            for (Object num : bucket[i]
                 ) {
                arr[current++] =(Integer)num;
            }
        }
        clearBucket();
    }
    //清除桶中的数据
    public static void  clearBucket(){
        for (int i = 0; i <bucket.length ; i++) {
            bucket[i].clear();
        }
    }

    //获取数字指定位置的数
    public static int getDigitOn(int num ,int d){
        String str = ""+num;
        int n = str.length();
        if (n<d){
            return 0;
        }
        String string   = ""+str.charAt(n-d);
        return Integer.parseInt(string);
    }
    //入桶
    private static void putInBucket(int data, int digitOn) {
        switch (digitOn) {
            case 0:
                bucket[0].add(data);
                break;
            case 1:
                bucket[1].add(data);
                break;
            case 2:
                bucket[2].add(data);
                break;
            case 3:
                bucket[3].add(data);
                break;
            case 4:
                bucket[4].add(data);
                break;
            case 5:
                bucket[5].add(data);
                break;
            case 6:
                bucket[6].add(data);
                break;
            case 7:
                bucket[7].add(data);
                break;
            case 8:
                bucket[8].add(data);
                break;
            default:
                bucket[9].add(data);
                break;
        }
    }
}
