package LeetCodeSecond.day;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/7/11 23:10
 * @Description:
 */
public class LeetCode_315 {
    // 临时空间
    int[] temp;
    // 索引数组
    int[] indexs;
    // 结果集
    int[] res;
    int[] nums;
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        indexs = new int[nums.length];
        res = new int[nums.length];
        temp = new int[nums.length];
        this.nums = nums;
        for (int i = 0; i < indexs.length ; i++) {
            indexs[i] = i;
        }
        merge(indexs,0,nums.length-1,temp);
        List<Integer> list  = new ArrayList<>();
        for (int i = 0; i < nums.length ; i++) {
            list.add(res[i]);
        }
        return list;
    }
    public void merge(int[] numIndexs, int left, int right, int[] temp){
        if (left == right){
            return;
        }
        int mid = left + (right - left) / 2;
        merge(numIndexs,left,mid,temp);
        merge(numIndexs,mid+1,right,temp);
        if (nums[numIndexs[mid]] <= nums[numIndexs[mid+1]]){
            return;
        }
        mergeFind(numIndexs,left,mid,right,temp);

    }

    private void mergeFind(int[] numIndexs, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right ; i++) {
            temp[i] = numIndexs[i];
        }
        int l = left;
        int r = mid+1;
        // 考虑l出队的情况，因为我们要找的是一个数右边小于它的元素个数
        // 如果考虑r出队，那么求的是一个数左边大于它的个数
        for (int i = left; i <= right ; i++) {
            if (l > mid){
                numIndexs[i] = temp[r++];
            }else if (r > right){
                numIndexs[i] = temp[l++];
                res[numIndexs[i]] += right - mid;
            }else if (nums[temp[l]] > nums[temp[r]]){
                numIndexs[i] = temp[r++];
                res[numIndexs[i]] += (r - mid -1);
            }else {
                numIndexs[i] = temp[l++];
            }
        }
    }

}
