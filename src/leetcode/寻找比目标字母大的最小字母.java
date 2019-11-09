package leetcode;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 武凯焱
 * @date 2019/7/13 15:18
 * @Description:
 */
public class 寻找比目标字母大的最小字母 {
    public static void main(String[] args) {
        char[] chars = {'e','e','e','n','n'};
        System.out.println(nextGreatestLetter1(chars,'e'));
    }
    public static char nextGreatestLetter(char[] letters, char target) {
        Set<Character> set = new HashSet();
        for (char c: letters) {
            set.add(c);
        }
        char[] chars = new char[set.size()];
        Iterator<Character> iterator = set.iterator();
        int num = 0;
        while (iterator.hasNext()){
            chars[num] = iterator.next();
            num++;
        }
        Arrays.sort(chars);
        int length  = chars.length;
        int left =  0;
        int right  = length-1;
        while (left<=right){
            int mid = (left+right)/2;
            char midChar =  chars[mid];
            if (midChar>target){
                right = mid - 1;
            } else if (midChar<target){
                left = mid + 1;
            }else {
                if (mid+1<length) {
                    return chars[mid + 1];
                }else {
                    return chars[0];
                }

            }
        }
        if (right<0 || left>=length){
            return chars[0];
        }
        if (chars[left]>target){
            return chars[left];
        }else {
            return chars[right];
        }
    }
    public static char nextGreatestLetter1(char[] letters, char target) {
        int low = 0;
        int high = letters.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (letters[mid] <= target) {
                low = mid + 1;
            } else if (letters[mid] > target) {
                high = mid - 1;
            }
        }
        if(low >= letters.length){
            return letters[0];
        }else{
            return letters[low];
        }

    }


}
