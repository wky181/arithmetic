package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/5/10 10:55
 * @Description:
 */
public class LeetCdoe_5405 {
    int count = 0;
    public int countTriplets(int[] arr) {
        for (int i = 0; i < arr.length ; i++) {
            for (int j = i + 1; j < arr.length ; j++) {
                for (int k = j; k < arr.length ; k++) {
                    int a = slove(i,j-1,arr);
                    int b = slove(j,k,arr);
                    if (a == b){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public int slove(int i, int j, int[] arr){
        int res = arr[i];
        for (int k = i+1; k < arr.length ; k++) {
            res = res ^ arr[k];
        }
        return res;
    }
    
}
