package bluebridgecup_course;

import java.util.Arrays;

/**
 * @author 武凯焱
 * @date 2019/2/14 11:10
 * @Description:
 */
public class 最长连续递增子序列 {
    public static void main(String[] args) {
        int[] arr =  {1,9,3,7,9,-1};
        int[] newData = f(arr);
        for (int i = 0; i <newData.length ; i++) {
            System.out.print(newData[i]+" ");
        }

    }
    static int[] f(int[] arr){
        int index =0;
        int end =0;
        int begin = 0;
        int count=0;
        for (int i = 0; i < arr.length ; i++) {
            if ( (i+1<arr.length && arr[i] > arr[i+1])){
                int temp = i-begin;
                if (count<temp){
                    index = begin;
                    end = i ;
                    count = temp;
                    begin = i+1;
                }
            }
            else if (i+1>=arr.length ){
                int temp = i-begin;
                if (count<temp){
                    index = begin;
                    end = i ;
                }
            }
        }
        int [] newData;
        newData  = Arrays.copyOfRange(arr,index,end+1);
        return newData;
    }

}
