package demo;

/**
 * @Author: wky233
 * @Date: 2020/9/27 10:33
 * @Description:
 */
public class W1 {
    public int minOperations(String[] logs) {
        int count = 0;
        for (String s: logs) {
            if (s.equals("./")){

            }else if (s.equals("../")){
                count--;
                if (count  <= 0){
                    count = 0;
                }
            }else {
                count++;
            }
        }
        return Math.max(0,count);
    }
}
