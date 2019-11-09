package leetcode;

/**
 * @author 武凯焱
 * @date 2019/7/22 10:51
 * @Description:
 */
public class 最大子序和 {
    public static void main(String[] args) {
        long startTime =  System.currentTimeMillis();
        int[] nums = {-2,-1,-4,-10};
        System.out.println(maxSubArray1(nums));
        long endTime =  System.currentTimeMillis();
        System.out.println("程序运行时间："+ (endTime-startTime)+"ms");
    }

    public static int maxSubArray(int[] nums) {
        int num = 0;
        int maxNums = Integer.MIN_VALUE;
        for (int i = 0; i <nums.length ; i++) {
            for (int j = 0; j <nums.length; j++) {
                num = 0;
                for (int k = i; k <=j ; k++) {
                    num+=nums[k];
                    if (num>maxNums) {
                        maxNums = num;
                    }
                }
            }
        }
    return maxNums;
    }
    public static int maxSubArray1(int[] nums) {
        int num = 0;
        int maxNums = Integer.MIN_VALUE;
        for (int i = 0; i <nums.length ; i++) {
            num = 0;
            //以下标i开头，下标j结尾，找出其中连续子数组的最大和
            for (int j = i; j <nums.length ; j++) {
                num+=nums[j];
                if (num>maxNums){
                    maxNums=num;
                }
            }
        }
        return maxNums;
    }
    public static int lineMaxSubArray(int[] nums){
        int thisNum = 0;
        int maxNum = 0;
        for (int i = 0; i <nums.length ; i++) {
            thisNum+=nums[i];
            if (thisNum>maxNum){
                maxNum = thisNum;
            }else if (thisNum<0){
                thisNum = 0;
            }
        }
        return maxNum;
    }
    public static int methde (int[] nums){
        int res =nums[0];
        //当前最大连续序列的和（不是最大和）
        int currntNums = 0;
        for (int i = 0; i <nums.length ; i++) {
            //考虑是否对结果是否有增益
            if (currntNums>0){
                currntNums+=nums[i];
            }else {

               currntNums = nums[i];
                }
            res = Math.max(currntNums,res);
            }
           return res;
    }
}
