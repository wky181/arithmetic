package LeetCodeSecond.Array;

/**
 * @Author: wky233
 * @Date: 2020/7/19 22:52
 * @Description:
 */
public class LeetCode_670 {
    public int maximumSwap(int num) {
        int max = num;
        char[] array = String.valueOf(num).toCharArray();
        for (int i = 0; i < array.length ; i++) {
            int i1 = getMax(array, i);
            if (i1 == i){
                continue;
            }
            swap(i,i1,array);
            String s = new String(array);
            int anInt = Integer.parseInt(s);
            max = Math.max(max, anInt);
            swap(i,i1,array);
        }
        return max;
    }
    public void swap(int a, int b, char[] array){
        char temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    public int getMax(char[] nums,int index){
        char max = nums[index];
        int mark = index;
        for (int i = index; i < nums.length ; i++) {
            if (nums[i] >= max){
                max = nums[i];
                mark = i;
            }
        }
        return mark;
    }
}
