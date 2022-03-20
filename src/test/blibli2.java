package test;

/**
 * @Author: wky233
 * @Date: 2020/8/13 20:18
 * @Description:
 */
public class blibli2 {
    String yun[] = {"+", "-" ,"*", "/" };
    public boolean Game24Points (int[] arr) {
        for (int i = 0; i < 4 ; i++) {
            for (int j = 0; j < 4 ; j++) {
                if (i == j){
                    continue;
                }
                for (int x = 0; x < 4 ; x++) {
                    if (x == j || x == i){
                        continue;
                    }
                    for (int k = 0; k < 4 ; k++) {
                        double sum = 0;
                        sum = method(arr[i], arr[j],yun[k]);
                        for (int l = 0; l < 4 ; l++) {
                            double sum1 = 0;
                            sum1 = method(sum, arr[x],yun[l]);
                            for (int m = 0; m < 4 ; m++) {
                                double sum2 = 0;
                                sum2 = method(sum1, arr[k],yun[m]);
                                    if (sum2 == 24){
                                        return true;
                                    }
                                }
                            }
                        }
                    }

            }
        }
        return false;
    }

    private double method(double i, double i1, String s) {
        if (s.equals("+")){
            return  i + i1;
        }
        else if (s.equals("-")){
            return  i - i1;
        }else if (s.equals("*")){
            return i * i1;
        }else {
            return i / i1;
        }
    }
}
