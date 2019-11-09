package bluebridgecup_course.class_09;


/**
 * @author 武凯焱
 * @date 2019/3/9 10:20
 * @Description:
 */
public class 闭式解 {
    public static void main(String[] args) {

    }
    public static void solve(){
        int[][] exmple = {
                {0,1},
                {1,1}
        };
        int[][] exm = {
                {1,1}
        };
     /*   int[][] res =*/
    }
    public static int[][] martixPow(int[][] arr , int p){
        int [][] result = new int[ arr.length][ arr[0].length];
        for(int i=0; i<result.length; i++) {
            result[i][i] = 1;
        }
        int[][] pingfang = arr;
        for(; p != 0; p >>= 1) {
            if((p & 1) != 0) {
                // 注意result在前面
                result = matrix(result, pingfang);
            }
            pingfang = matrix(pingfang, pingfang);
        }
        return result;
    }
    public static int[][] matrix(int[][]arr , int[][] temp){
        int arrClo = arr[0].length;
        int arrRow = arr.length;
        int tempRow  = temp.length;
        int tempClo  = temp.length;
        int[][] res = new int[arrRow][tempClo];
        if (arrClo!= tempRow){
            return res;
        }
        for (int i = 0; i < arrRow ; i++) {
            for (int j = 0; j <tempClo ; j++) {
                for (int k = 0; k < arrClo ; k++) {
                    res[i][j] += arr[i][k]+temp[k][j];
                }
            }
        }
        return res;
    }
}
