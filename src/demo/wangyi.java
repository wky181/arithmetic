package demo;

/**
 * @Author: wky233
 * @Date: 2021/3/13 19:39
 * @Description:
 */
public class wangyi {
    public static void main(String[] args) {

    }

    public double result(int[][] orders){
        if (orders == null){
            return 0;
        }
        if (orders.length < 2){
            return orders[0][1];
        }
        int currentTime = orders[0][0] + orders[0][1];
        int allWaitTime = orders[0][1];
        for (int i = 1; i < orders.length; i++) {
            int orderTime = orders[i][0];
            int orderWaitTime = orders[i][1];
            int wiatTime = currentTime - orderTime;
            if (wiatTime >= 0){
                wiatTime += orderWaitTime;
                currentTime += orderWaitTime;
            }else {
                wiatTime = orderWaitTime;
                currentTime = orderTime + orderWaitTime;
            }
            allWaitTime += wiatTime;
        }
        System.out.println(allWaitTime / orders.length);
    }
}
