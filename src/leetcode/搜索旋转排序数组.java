package leetcode;

/**
 * @author 武凯焱
 * @date 2019/8/1 20:49
 * @Description:
 */
public class 搜索旋转排序数组 {
    public static void main(String[] args) {
        int nums[] = {4,5,6,7,0,1,2};
    }

    public static int search(int[] nums, int target) {
        if (nums.length<=0){
            return -1;
        }
        int index = searchMinIdenx(nums);
        if (target == nums[index]) {
            return index;
        }
        if (index == 0) {
            return towSearch(0, nums.length - 1, nums, target);
        }
        if (nums[0] > target) {
            return towSearch(index, nums.length - 1, nums, target);
        } else {
            return towSearch(0, index - 1, nums, target);
        }
    }

    public static int towSearch(int left, int right, int[] nums, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int searchMinIdenx(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid-1>=0 && nums[mid] < nums[mid - 1]) {
                return mid;
            } else {
                if (nums[mid] > nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return 0;
    }
}
