package bluebridgecup_course;

import java.util.Random;

/**
 * @author 武凯焱
 * @date 2019/2/6 21:19
 * @Description:
 */
public class 唯一成对的数 {
    public static void main(String[] args) {
        int N = 100;
        int[] arrs = new int[N];
        int index = new Random().nextInt(N);
        for (int i = 0; i < arrs.length - 1; i++) {
            arrs[i] = (i + 1);
        }
        arrs[N - 1] = new Random().nextInt(N - 1) + 1;
        swap(arrs, index, N - 1);
        int n = 0;
        for (int i = 1; i <= arrs.length - 1; i++) {
            n = n ^ i;
        }
        for (int i = 0; i < arrs.length; i++) {
            n = n ^ arrs[i];
        }
        toString(arrs);
        System.out.println(n);
        int[] helper = new int[N];
        for (int i = 0; i <helper.length ; i++) {
            helper[arrs[i]]++;
        }
        for (int i = 0; i <helper.length ; i++) {
            if (helper[i]==2){
                System.out.println(i);
                break;
            }

        }


    }

    public static void swap(int[] arrs, int i, int j) {
        int temp;
        temp = arrs[i];
        arrs[i] = arrs[j];
        arrs[j] = temp;
    }

    public static void toString(int[] arrs) {
        String temp = "[";
        for (int i = 0; i < arrs.length - 1; i++) {
            temp = temp + arrs[i] + ",";
        }
        temp = temp + arrs[arrs.length - 1] + "]";
        System.out.println(temp);
    }
}
