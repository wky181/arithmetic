package Interview.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/4/7 20:30
 * @Description:
 */
public class T {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Long fan = sc.nextLong();
        int[] po = new int[n];
        int[] shang = new int[n];
        for (int i = 0; i < n; i++) {
            po[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            shang[i] = sc.nextInt();
        }
        guaiwu[] guaiwus = new guaiwu[n];
        for (int i = 0; i < n ; i++) {
            guaiwus[i] = new guaiwu(po[i],shang[i]);
        }
        Arrays.sort(guaiwus,(a,b) -> a.po - b.po);
        long res = 0;
        for (int i = 0; i < guaiwus.length ; i++) {
            if (fan >= guaiwus[i].po ){
                fan++;
            }else {
                res += guaiwus[i].shang;
            }
        }
        System.out.println(res);
    }
    static class guaiwu {
        int po;

        public guaiwu(int po, int shang) {
            this.po = po;
            this.shang = shang;
        }

        int shang;

    }
}
