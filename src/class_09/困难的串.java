package class_09;

/**
 * @author 武凯焱
 * @date 2019/5/27 8:58
 * @Description:              
 * 如果一个字符串包含两个相邻的重复子串，则称它是“容易的串”，其他串称为“困难的串”。例如
 * BB、ABCDABCD都是容易的串，而D、DC、ABDAD、CBABCBA都是困难的串。输入正整数n和L，输出由前L个字符组成的、字典序第k个困难的串。例如，当L=3时，
 * 前7个困难的串分别为A、AB、ABA、ABAC、ABACA、ABACAB、ABACABA。输入保证答案不超过80个字符。
 * 样例输入：
 *
 * 7  3
 *
 * 30 3
 *
 * 样例输出：
 *
 * ABACABA
 *
 * ABACABCACBABCABACABCACBACABA
 */


public class 困难的串 {
    static int count ;
    public static void main(String[] args) {
        int l = 3;
        int n = 7;
        dfs(l,n,"");
    }
    public static void dfs(int l,int n,String prefix){
        for (char i = 'A'; i <'A'+l; i++) {
            if (isHard(prefix,i)){
                prefix = prefix+i;
                System.out.println(prefix);
                count++;
                if (count==n){
                    System.exit(0);
                }else {
                    dfs(l,n,prefix);
                }
            }
        }
    }

    public static boolean isHard(String prefix,char n) {
        int count =  0;
        for (int i = prefix.length()-1; i >=0 ; i-=2) {
            String s1 = prefix.substring(i,prefix.length()-count);
            String s2 = prefix.substring(prefix.length()-count)+n;
            if (s1.equals(s2)){
                return false;
            }
            count++;
        }
        return true;
    }

}
