package NewCoder.yuewen;

/**
 * @Author: wky233
 * @Date: 2020/5/19 19:36
 * @Description:
 */
public class Test3 {
    public int stairs (int n) {
        if (n <= 2){
            return n;
        }
        int per_per = 1;
        int per = 2;
        for (int i = 3; i <=n ; i++) {
            int temp = per;
            per = per + per_per;
            per_per = temp;
        }
        return per;
    }
}
