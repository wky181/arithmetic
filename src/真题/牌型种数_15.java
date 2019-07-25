package 真题;

/**
 * @author 武凯焱
 * @date 2019/3/23 9:08
 * @Description:
 */
public class 牌型种数_15 {
    static  int number;
    public static void main(String[] args) {
        dfs(0,0);
        System.out.println(number);
    }
    public static void dfs(int k,int count ){
        if (k==13 && count==13){
            number++;
            return;
        }
        if (count>13 || k>13){
            return;
        }
        for (int i = 0; i <5 ; i++) {
            dfs(k+1,count+i);
        }
    }
}
