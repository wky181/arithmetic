package test;

/**
 * @Author: wky233
 * @Date: 2020/9/14 14:50
 * @Description:
 */
public class SP2 {
    public static void main(String[] args) {
        System.out.println(count(3));
    }
    static int[] findNumber(int num) {

        int count = count(num);
        int l = findL(num, count);
        int r = findR(num, count);
        return new int[]{l ,r};
    }
    static int count(int num){
        int index = 1;
        int count = 0;
        for (int i = 0; i < 32 ; i++) {
            if (i != 0) {
                index = index << 1;
            }
            if ((num & index) == index){
                count++;
            }
        }
        return count;
    }
    static int findL(int num, int c){
        for (int i = num - 1; i >= (num >> 1) ; i--) {
            int count = count(i);
            if (count == c){
                return i;
            }
        }
        return -1;
    }
    static int findR(int num, int c){
        long max = ((long) num << 1);
        for (int i = num+1; i < max  ; i++) {
            int count = count(i);
            if (count == c){
                return i;
            }
        }
        return -1;
    }
}
