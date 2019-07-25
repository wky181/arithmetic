import java.util.Arrays;
import java.util.Random;

/**
 * @author 武凯焱
 * @date 2019/2/17 17:34
 * @Description:
 */
public class demo {
    public static int quickSelect(int a[], int l, int r, int k) {
        Random rand = new Random();
        int p = rand.nextInt(r - l + 1) + l;
        int x = a[p];
        int tmp = a[p]; a[p] = a[r]; a[r] = tmp;
        int i = l, j = r;
        while(i < j) {
            while(i < j && a[i] < x) {
                i++;
            }
            if(i < j) {
                a[j] = a[i];
                j--;
            }
            while(i < j && a[j] > x) {
                j--;
            }
            if(i < j) {
                a[i] = a[j];
                i++;
            }
        }
        a[i] = x;
        p = i;
        if(i - l + 1 == k) {
            return a[i];
        }
        if(i - l + 1 < k) {
            //填空
            return quickSelect(a,i+1,r, k-(i-l+1));
        } else {
            return quickSelect(a, l, i - 1, k);
        }
    }
    public static void main(String args[]) {
        int [] a = {1,2,4,4,5,7};
        int[] b =a;
        Arrays.sort(b);
        for (int i = 0; i <b.length ; i++) {
            System.out.print(b[i]+" ");
        }
        System.out.println(quickSelect(a, 0, a.length-1, 4));
    }
}
