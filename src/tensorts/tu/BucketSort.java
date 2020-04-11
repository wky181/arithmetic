package tensorts.tu;

/**
 * @Author: wky233
 * @Date: 2020/3/10 0:06
 * @Description:
 */
public class BucketSort {
    public static void main(String[] args) {

    }
    public void sort(int[] nums){
        if (nums == null || nums.length < 1){
            return;
        }
        int[] bucket = new  int[nums.length];
        int min = nums[0];
        int max = nums[0];
        for (int num: nums) {
            min = Math.min(num,min);
            max = Math.max(num,max);
        }
        int bucketCount = ((max - min) / bucket.length) + 1;

    }
}
