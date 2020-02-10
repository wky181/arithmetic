package leetcode;


import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: wky233
 * @Date: 2020/1/30 21:02
 * @Description:
 */
public class LeetCode_451 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_451().frequencySort("tree"));
    }
    public String frequencySort(String s) {
        int[] nums = new int[128];
        for (int i = 0; i < s.length() ; i++) {
            nums[s.charAt(i)]++;
        }
        HashMap<Integer,String> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            String string = bulidSring(nums[i],(char)i);
            if (hashMap.containsKey(nums[i])){
                hashMap.put(nums[i],hashMap.get(nums[i])+string);
                nums[i] = 0;
            }else {
                hashMap.put(nums[i],string);
            }
        }
        Arrays.sort(nums);
        StringBuilder result = new StringBuilder();
        for (int i = nums.length-1; i >= 0 ; i--) {
            if (nums[i] > 0){
                result.append(hashMap.get(nums[i]));
            }
        }
        return result.toString();
    }
    public String bulidSring(int number,char c){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < number ; i++) {
            stringBuilder.append(c);
        }
       return stringBuilder.toString();
    }
}
