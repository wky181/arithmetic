package leetcode;

/**
 * @author 武凯焱
 * @date 2019/10/5 15:41
 * @Description:
 */
public class 只出现一次的数字2 {
    public static void main(String[] args) {
       int[] ints = {-401451,-177656,-2147483646,-473874,-814645,-2147483646,-852036,-457533,-401451,-473874,-401451,-216555,-917279,-457533,-852036,-457533,-177656,-2147483646,-177656,-917279,-473874,-852036,-917279,-216555,-814645,2147483645,-2147483648,2147483645,-814645,2147483645,-216555};
        System.out.println(singleNumber2(ints));
    }
    public static int singleNumber(int[] nums) {
        StringBuilder stringBuilder = new StringBuilder();
        int a = 0;
        for (int j = 0; j <32 ; j++) {
            int temp = 0;
            for (int i = 0; i <nums.length ; i++) {
                if (j==31){
                    a+=(nums[i]>>j)&1;
                }
                //需要考虑int范围-2147483648～2147483647 最小值为-2147483648
                long number = Math.abs(nums[i]);
                if (((number>>j)&1)==1){
                    temp++;
                }
            }
            if (temp%3==0){
                stringBuilder.append("0");
            }else {
                stringBuilder.append("1");
            }
        }
      String s =  stringBuilder.reverse().toString();
        if (a%3==0) {
            return Integer.parseInt(s, 2);
        }
        return (int) -Long.parseLong(s,2);
    }
    public static int singleNumber1(int[] nums) {
        int res = 0;
        int flag = 1;
        for (int i = 0; i <= 31; i++){
            //flag  1每移位i位相当于2的i次方
            flag = 1 << i;
            //sum记录该位置上1出现的次数
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & flag) != 0) {
                    sum++;
                }
            }
            //看这个只出现一次的数字的二进制在第i位上是0还是1
            if ((sum % 3) != 0) {
                //是1 将该位上二进制转化为十进制的值加上
                res += flag;
            }
        }
        return res;
    }
    //改进版
    public static int singleNumber2(int[] nums) {
        int result = 0;
        for (int j = 0; j <32 ; j++) {
            //sum记录j位置上1出现的次数
            int temp = 0;
            // 1每移位j位相当于2的j次方
            int towToTen=1;
            for (int i = 0; i <nums.length ; i++) {
                // 1每移位j位相当于2的j次方
                towToTen = 1<<j;
                if ((nums[i] & towToTen) != 0) {
                    temp++;
                }
            }
                //说明只出现一次数字的二进制在j位上的值为1 对应十进制的值为towToTen
                if (temp%3!=0){
                    result+=towToTen;
                }

        }
        return result;
    }
}
