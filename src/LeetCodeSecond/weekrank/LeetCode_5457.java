package LeetCodeSecond.weekrank;

/**
 * @Author: wky233
 * @Date: 2020/7/25 22:32
 * @Description:
 */
public class LeetCode_5457 {
    public int numOfSubarrays(int[] arr) {
        int[] pres = new int[arr.length + 1];
        int  ji = 0;
        int o = 0;
        int mod = (int) (1e9 + 7);
        int res = 0;
        for (int i = 1; i < arr.length+1 ; i++) {
            int count = 0;
            pres[i] = pres[i-1] + arr[i-1];
            if ((pres[i] & 1) == 1){
                ji++;
                ji %= mod;
                count += o + 1;
            }else {
                o++;
                o %= mod;
                count += ji;
            }
            res += count;
            res %= mod;
        }
        return res;
     }
}
