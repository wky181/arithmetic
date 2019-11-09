package bluebridgecup_course.cc150;

/**
 * @author 武凯焱
 * @date 2019/3/4 14:55
 * @Description:
 */
public class case12_Pabinkarp {
    final static int seed =  31;
    public static void main(String[] args) {
        String s = "SDFBABSDABA";
        String p = "";
        System.out.println(match(p,s));


    }
    private static boolean  match(String p ,String s){
        long hash_p = hash(p);
        int p_length = p.length()-1;
        for (int i = 0; i+p_length <s.length() ; i++) {
            if (hash_p == hash(s.substring(i,p_length+1+i))){
                return true;
            }
        }
        return false;
    }

    //对模式串求哈希值
    static long hash(String str){
        long hash = 0;
        for (int i = 0; i < str.length() ; i++) {
            hash += seed*hash+str.charAt(i);
        }
        return hash%Long.MAX_VALUE;
    }
    //对原字符串的模式长度的字串求hash值
    static long[] hsahs (String p ,int M){
        long[] longs = new long[p.length()-M+1];
        longs[0] = hash(p.substring(0,M-1));
        for (int i = M ; i< p.length() ; i++) {
                char newChar = p.charAt(i);
                char oChar =p.charAt(i-M);
                //
                long temp = ((longs[i-M])*seed-pow(oChar,M)+oChar)%Long.MAX_VALUE;
                longs[i-M+1] = temp;
        }
        return longs;
    }
    public static int pow(int a,int n){
        if (n==0){
            return  1;
        }
        int res = a;
        int power = 1;
        while ((power<<1)<=n){
            res*=res;
            power<<=1;
        }
        return res*pow(a,n-power);
    }
}
