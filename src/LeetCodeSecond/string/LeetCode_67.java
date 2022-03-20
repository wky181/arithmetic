package LeetCodeSecond.string;

/**
 * @Author: wky233
 * @Date: 2020/6/23 9:49
 * @Description:
 */
public class LeetCode_67 {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int mark = 0;
        while (i >=0 || j >= 0){
            int numA = i >= 0 ? A[i] - '0' : 0;
            int numB = j >= 0 ? B[j] - '0' : 0;
            int nums = numA + numB + mark;
            mark = nums > 1 ? 1 : 0;
            sb.insert(0,nums % 2);
            i--;
            j--;
        }
        if (mark == 1){
            sb.insert(0,1);
        }
        return sb.toString();
    }
}
