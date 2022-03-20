package LeetCodeSecond.binarysearch;

import leetcode.MountainArray;

/**
 * @Author: wky233
 * @Date: 2020/9/11 11:16
 * @Description:
 */
public class LeetCode_1095 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int top = findTopIndex(mountainArr);
        if (mountainArr.get(top) == target){
            return top;
        }
        int left = findLeft(target, top - 1, mountainArr);
        if (left != -1){
            return left;
        }
        return findRight(target, top + 1 ,mountainArr);
    }

    private int findTopIndex(MountainArray mountainArr) {
        int left = 0;
        int right = mountainArr.length() - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)){
                left = mid + 1;
            }else {
                right = mid;
            }

        }
        return left;
    }
    private int findLeft(int target, int topIndex,MountainArray mountainArr){
        int left = 0;
        int right = topIndex;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < target ){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return mountainArr.get(left) == target ? left : -1;
    }
    private int findRight(int target, int topIndex,MountainArray mountainArr){
        int left = topIndex;
        int right = mountainArr.length() - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) > target ){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return mountainArr.get(left) == target ? left : -1 ;
    }
}