package 真题;

/**
 * @author 武凯焱
 * @date 2019/3/19 8:37
 * @Description:
 */
public class 纸牌三角形_17 {
    static int count;
    public static void main(String[] args) {
        int[] arr = new int[9];
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = i+1;
        }
        solve(arr,0);
        System.out.println(count/6);
    }
    public static void solve(int[] arr,int k){
        if (k==arr.length){
            if (check(arr)){
                count++;
            }
            return;
        }
        for (int i = k; i <arr.length ; i++) {
                swap(arr,k,i);
                solve(arr,k+1);
                swap(arr,k,i);
        }
    }
    public static void swap(int arr[],int i ,int j){
        int temp  = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static boolean check (int[] arr){
        int sum1 = arr[0]+arr[1]+arr[3]+arr[5];
        int sum2 = arr[0]+arr[2]+arr[4]+arr[8];
        int sum3 = arr[5]+arr[6]+arr[7]+arr[8];
        if (sum1==sum2 && sum2==sum3){
            return true;
        }
        return false;
    }
}
