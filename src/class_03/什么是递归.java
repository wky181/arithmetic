package class_03;

import java.util.Arrays;

/**
 * @author 武凯焱
 * @date 2019/2/8 18:57
 * @Description:
 */
public class 什么是递归 {
    public static void main(String[] args) {
       int arr[] = {21,5,8,54,4657,1,45,54,23,8};
        insert(arr);
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    //求阶乘
    static int f(int n){
        if (n==1){
            return 1;
        }
        return n*f(n-1);
    }
    //打印即到即之间的数
    static void f1(int a,int b){
        System.out.println(a);
        if (a<b)
        f1(a+1,b);
    }
    /**
     * 反转字符串
     */
    static String reverse(String str,int end){
        if (end<0){
            return "";
        }
        else
        return str.charAt(end)+reverse(str,end-1);
    }
    /**
     * 最大公约数
     */
    static int gcd(int n,int m){
        if (m==0){
            return n;
        }
        return gcd(m,n%m);
    }
    /**
     * 插入排序
     */
    static void insertSort(int[] arr,int k){
        if (k==0){
            return ;
        }
        insertSort(arr,k-1);
        for (int i = k-1; i>=0 && arr[i+1]<arr[i] ; i--) {
                int temp = arr[i+1];
                arr[i+1] = arr[i];
                arr[i] = temp;
            }
    }
    /**
     * 汉诺塔
     */

    static void printHanoiTower(int N,String from,String to,String help){
        if (N==1){
            System.out.println("move"+ N + "from" + from + "to" + to );
        }else {
            printHanoiTower(N-1,from,help,to);//先把前N-1个盘子挪到辅助空间上去
            System.out.println("move" + N + "from" + from + "to" + to);
            printHanoiTower(N-1,help,to,from); //让N-1从辅助空间回到源空间上去
        }
    }
    /**
     * 二分递归解法
     */
    static boolean towDvide(int[] arr , int begin , int end,int key){
        if (begin>end){
            return false;
        }
        int mid = (begin+end)/2;
        if (arr[mid]<key){
            begin = mid+1;
            return towDvide(arr,begin,end,key);
        }
        else if (arr[mid]>key){
            end = mid-1;
            return towDvide(arr,begin,end,key);
        }
        else {
            return true;
        }

    }
    /**
     * 希尔排序
     */
    static void shellSort(int[] arr){
        for (int interval = arr.length/2; interval >0 ; interval = interval/2) {
            for (int i = interval ; i < arr.length ; i++) {
                for (int j = i-interval; j >=0 && arr[j+interval]<arr[j] ; j = j-interval) {
                        int temp = arr[j];
                        arr[j] = arr[j+interval];
                        arr[j+interval] = temp;
                }
            }
        }
    }
    /**
     * 迭代插排
     */
    public static void  insert(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i-1; j >=0 && arr[j+1]<arr[j] ; j--) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }

}
