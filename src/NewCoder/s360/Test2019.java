package NewCoder.s360;

import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/3/22 0:04
 * @Description:
 */
public class Test2019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long maxX = Long.MIN_VALUE; long maxY = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE; long minY = Long.MAX_VALUE;
        for (int i = 1; i <= n ; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            maxX = Math.max(maxX,x);
            maxY = Math.max(maxY,y);
            minX = Math.min(x,minX);
            minY = Math.min(y,minY);
        }
        long x = Math.abs(maxX - minX);
        long y = Math.abs(maxY - minY);
        long max = Math.max(x, y);
        System.out.println(max*max);
    }
}
