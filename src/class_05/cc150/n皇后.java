package class_05.cc150;

/**
 * @author 武凯焱
 * @date 2019/3/13 20:38
 * @Description:
 */
public class n皇后 {
    static int n  ;
    static int count;
    public static void main(String[] args) {
        int row = 4;
        int[] arr = new int[row];
        dfs(arr,row,4);
        System.out.println(count);
    }
    public static void dfs(int[] arr, int row,int col){
        if (row == n+1){
            count++;
            return;
        }
        int[] newArr = new int[row];
        for (int i = 0; i < col; i++) {
            if (check(newArr,row,i)){
                arr[row] = i;
                dfs(newArr,row+1,col);
                newArr[row] = 0;
            }
        }
    }
    public static boolean check(int[] arr,int x ,int y){
        for (int i = 1; i <arr.length ; i++) {
            if (arr[i]==y){
               return false;
            }
            if (i+arr[i] == x+y){
                return false;
            }
            if (i-arr[i] == x-y){
                return false;
            }
        }
        return true;
    }
}
