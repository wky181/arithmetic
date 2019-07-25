package 真题;

/**
 * @author 武凯焱
 * @date 2019/3/20 21:48
 * @Description:
 */
public class 李白打酒 {
    static int count;
    public static void main(String[] args){
        solve(5,9,2);
        System.out.println(count);
    }
    public static void solve(int dian ,int hua,int  jiu){
        if (dian==0 && hua == 0 && jiu ==1){
            count++;
        }
        if (dian>0) solve(dian-1,hua,jiu*2);
        if (hua>0) solve(dian,hua-1,jiu-1);



    }
}
