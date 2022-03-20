package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/4/30 10:45
 * @Description:
 */
public class LeetCode_1095 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        int topIndex = findTopIndex(mountainArr,0,len-1);
        if (mountainArr.get(topIndex) == target){
            return topIndex;
        }
        int left =  findSortIndex(target,mountainArr,0,topIndex - 1);
        if (left != -1){
            return left;
        }
        int right = findReversSortIndex(target,mountainArr,topIndex+1,len-1);

        return right;

    }

    private int findSortIndex(int target, MountainArray mountainArr, int left, int right) {
        while (left < right){
            // 向下取整取在左中位数
            int mid = left + (right - left) << 1;
            // 所以不会出现下标越界
            if (mountainArr.get(mid) < target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return mountainArr.get(left) == target ? left : -1;
    }
    private int findReversSortIndex(int target, MountainArray mountainArr, int left, int right) {
        while (left < right){
            // 向下取整取在左中位数
            int mid = left + (right - left) << 1;
            if (mountainArr.get(mid) > target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return mountainArr.get(left) == target ? left : -1;
    }

    private int findTopIndex(MountainArray mountainArr, int left, int right) {
        while (left < right){
            // 向下取整取在左中位数
            int mid = left + (right - left) << 1;
            // 所以不会出现下标越界
            if (mountainArr.get(mid) < mountainArr.get(mid+1)){
                left = mid + 1;
            }else {
                // mid在下坡
                right = mid;
            }
        }
        return left;
    }

}
