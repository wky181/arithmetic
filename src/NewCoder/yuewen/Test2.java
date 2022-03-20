package NewCoder.yuewen;

/**
 * @Author: wky233
 * @Date: 2020/5/19 19:31
 * @Description:
 */
public class Test2 {

    public int trueBitCount (int num) {
        return count(num);
    }
    public int count (int num) {
        int count = 0;
        for (int i = 0; i < 32 ; i++) {
            if (((num>>i) & 1) == 1){
                count++;
            }
        }
        return count;
    }
}
