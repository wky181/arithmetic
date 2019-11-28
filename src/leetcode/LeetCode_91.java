package leetcode;

/**
 * @author 武凯焱
 * @date 2019/11/15 17:40
 * @Description:
 */
public class LeetCode_91 {

    static int count;
    public static void main(String[] args) {
        String str = "1787897759966261825913315262377298132516969578441236833255596967132573482281598412163216914566534565";
        System.out.println(dp(str));
        System.out.println(numDecodings(str));

    }
    public static int numDecodings(String s) {
        int[] memory = new int[s.length()+1];
        recursive(1,s,memory);
        return count;
    }
    //递归
    public static void recursive(int start,String s,int[] memory){
        if (memory[s.length()]!=0){
            count+=memory[s.length()];
            return;
        }
        if (s.length()==0){
            count++;
            return;
        }else if (start>s.length()){
            return;
        }
        if (Integer.parseInt(s.substring(0,start))==0){
            return;
        }
        recursive(1,s.substring(start),memory);
        memory[s.length()] = count;
        System.out.println(memory[s.length()]+"  "+s.length());
        if (start+1<=s.length()) {
            int num = Integer.parseInt(s.substring(0, start + 1));
            if (num > 26) {
                return;
            } else {
                recursive(1, s.substring(start+1),memory);
                memory[s.length()] = count;
            }
        }
    }
    //动态规划
    public  static int dp(String s){
        if (s.equals("0")){

            return 0;
        }
        int[] dp = new int[s.length()+1];
        dp[1] = 1;
        dp[0] = 1;
        for (int i = 1; i <s.length() ; i++) {
            int n = Integer.parseInt(""+s.charAt(i));
            int m = Integer.parseInt(""+s.charAt(i-1));

            if ((m*10+n)>26){
                dp[i+1] = dp[i];
            }else {
                dp[i+1] = dp[i]+dp[i-1];
            }
        }
        return dp[s.length()];
    }
}
