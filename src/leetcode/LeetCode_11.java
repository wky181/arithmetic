package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/1/28 15:34
 * @Description:
 */
public class LeetCode_11 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(new LeetCode_11().maxArea1(height));
    }

    /**
     * 暴力破解 时间复杂度o(n2)
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxValue = -1;
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                int a = Math.min(height[i],height[j]);
                maxValue = Math.max(maxValue,a*(j-i));
            }
        }
        return maxValue;
    }
    /**
     *若m,n之间的面积为最大面积。m左侧的指针点等于或矮于n，n右侧指针等于或矮于m。
     * 所以通过双指针方法，两个指针一定会同时经过最大面积对应的指针位置。
     */
    public int maxArea1(int[] height) {
        int l = 0;
        int r = height.length-1;
        int maxValue = -1;
        while (l < r){
            int a;
            int length = r-l;
            if(height[l] > height[r]){
                a = height[r];
                r--;

            }else {
                a = height[l];
                l++;
            }
            maxValue = Math.max(maxValue , a*length);
        }
        return maxValue;
    }
}
