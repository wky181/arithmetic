/**
 * @author 武凯焱
 * @date 2019/2/14 9:37
 * @Description:
 */
public class 旋转数组的最小数字 {
    public static void main(String[] args) {
        int[] arr = {7,1,2,3};
        System.out.println(findLow(arr,0,arr.length-1));
    }
    /*public static int findLow(int[] arr,int bigan,int end){
        if (bigan+1 == end ){
            return arr[end];
        }
        int mid = (bigan+end)/2;
        if (arr[mid]<=arr[end]){
            end = mid;
        }else {
            bigan = mid;
        }
        return findLow(arr,bigan,end);
    }*/
    //二分练习
    public static int findLow(int[] arr,int bigan,int end){
        int f = bigan;
        int r = end;
        while (f<r){
            if (f+1==r){
                return arr[r];
            }
            int mid = (f+r)/2;
            if (arr[mid]>r){
                f = mid;
            }else {
                r = mid;
            }
        }
        return bigan;
    }
}
