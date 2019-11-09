package leetcode;

/**
 * @author 武凯焱
 * @date 2019/10/14 15:23
 * @Description:
 */
public class 提莫攻击 {
    public static void main(String[] args) {
        int[] nums = {
                1,2,3,4,5
        };
        System.out.println(findPoisonedDuration(nums,5));
    }
    public static int findPoisonedDuration(int[] timeSeries,int duration){
        if (timeSeries.length ==0){
            return 0;
        }
        //记录总中毒时间
        int result = duration;
        //当前数的后一个数
        int perNumber = timeSeries [timeSeries.length -1];
        for (int i = timeSeries.length-2 ; i >=0 ; i--) {
            int targetNum = perNumber-duration;
            if (targetNum >= timeSeries[i]){
                result +=duration;
            }else {
                result +=perNumber-timeSeries [i];
                //下一个人当前数的后一个数
                perNumber = timeSeries[i];
            }
        }
        return result;
    }
}
