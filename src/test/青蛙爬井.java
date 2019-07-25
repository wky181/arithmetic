package test;

/**
 * @author 武凯焱
 * @date 2019/3/8 8:57
 * @Description:
 */
public class 青蛙爬井 {
    public static void main(String[] args) {
        double count = 0;
        int temp = 60405-105;
        int n = temp/70;
        System.out.println(n);
        int m = temp % 70;
        System.out.println(m);
        count +=n;
        int num = 105+m;
        if (num>105){
            count+=2;
        }
        else {
            count++;
        }
        System.out.println(count);

    }
}
