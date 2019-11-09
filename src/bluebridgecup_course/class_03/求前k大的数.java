package bluebridgecup_course.class_03;

import java.util.Scanner;

/**
 * @author 武凯焱
 * @date 2019/2/22 16:39
 * @Description:
 */
public class 求前k大的数 {
    static int current = 0;
    static int[] heap ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        heap = new int[k];
        int x=0;
        while (x!=-1){
            x= sc.nextInt();
            deal(x);
        }
     }
     public static void deal(int num){
        if (current<heap.length-1){
            heap[current++] = num;
        }
        else if (current==heap.length-1){
            heap[current] = num;
            current++;
            minHeap(heap);
            Util.print(heap);
        }
        else {
            if (num>heap[0]){
                heap[0] = num;
                minHeapFixDown(heap,0,heap.length);
            }
            Util.print(heap);
        }


     }
     public static void  minHeap(int[] arr){
        int n = arr.length/2-1;
         for (int i = n; i >=0; i--) {
             minHeapFixDown(arr,i,arr.length);
         }
     }
     public static  void  minHeapFixDown(int[] arr ,int i,int n){
        int left = 2*i+1;
        int right = 2*i+2;
        if (left>=n){
            return;
        }
        int min = left;
        if (right>=n){
            min = left;
        }else {
            if (arr[left] <= arr[right]) {
                min = left;
            }else {
                min = right;
            }
        }
        if (arr[i]<=arr[min]){
            return;
        }
        else {
            Util.swap(arr,i,min);
            minHeapFixDown(arr,min,n);
        }
     }
}
