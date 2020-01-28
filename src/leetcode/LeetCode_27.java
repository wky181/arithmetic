package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/1/21 16:56
 * @Description: 优化，第二种方法 现在考虑数组包含很少的要删除的元素的情况。
 * 例如，num=[1，2，3，5，4]，Val=4num=[1，2，3，5，4]，Val=4。
 * 之前的算法会对前四个元素做不必要的复制操作。另一个例子是 num=[4，1，2，3，5]，
 * Val=4num=[4，1，2，3，5]，Val=4。似乎没有必要将 [1，2，3，5][1，2，3，5]
 * 这几个元素左移一步，因为问题描述中提到元素的顺序可以更改。
 *

 */
public class LeetCode_27 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println( new LeetCode_27().removeElement1(nums,3));
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+",");
        }
    }
    public int removeElement(int[] nums, int val) {
        if (nums == null){
            return 0;
        }
        // [0,k)区间都是非val的
        int k = 0;
        int res = 0;
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] != val){
                res++;
                if (i != k) {
                    swap(i, k, nums);
                }
                k++;
            }
        }
        return res;
    }

    /**
     *
     *@Description: 优化，第二种方法 现在考虑数组包含很少的要删除的元素的情况。
     * 例如，num=[1，2，3，5，4]，Val=4num=[1，2，3，5，4]，Val=4。
     * 之前的算法会对前四个元素做不必要的复制操作。另一个例子是 num=[4，1，2，3，5]，
     * Val=4num=[4，1，2，3，5]，Val=4。似乎没有必要将 [1，2，3，5][1，2，3，5]
     * 这几个元素左移一步，因为问题描述中提到元素的顺序可以更改。
     *
     */
    public int removeElement1(int[] nums, int val) {
        int n = nums.length;
        int i = 0;
        while (i < n){
            if (nums[i] == val){
                swap(i,n-1,nums);
                n--;
            }else {
                i++;
            }
        }
        return n;
    }
    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
