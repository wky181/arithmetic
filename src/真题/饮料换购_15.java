package 真题;

/**
 * @author 武凯焱
 * @date 2019/3/23 10:02
 * @Description:
 */
public class 饮料换购_15 {
    public static void main(String[] args) {
        solve(125);
    }
    public static void solve(int num){
        int number = num;
        int sum = 0;
        int yu = 0;
        while (number/3>0){
            int temp = number/3;
            sum+=number;
            yu +=number%3;
            number = temp;
            if (yu/3>0){
                number+=yu/3;
                yu = yu%3;
            }
        }
        if (number+yu/3>0){
            sum+=number;
            sum+=(number+yu)/3;
            System.out.println(sum);
        }else
        System.out.println(sum+number);
    }
}
