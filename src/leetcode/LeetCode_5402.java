package leetcode;

import java.util.LinkedList;

/**
 * @Author: wky233
 * @Date: 2020/5/3 11:00
 * @Description:
 */
public class LeetCode_5402 {
    public int longestSubarray(int[] nums, int limit) {
        int left = 0;
        int rigth = 0;
        int res = -1;
        LinkedList<Integer> max = new LinkedList<>();
        LinkedList<Integer> min = new LinkedList<>();
        while (rigth < nums.length && left < nums.length ){
            int r = nums[rigth];

            int a = min.isEmpty() ? 0 : Math.abs(min.peek() - r);
            int b = max.isEmpty() ? 0 : Math.abs(max.peek() - r);
            if (a <= limit && b <= limit){
                res = Math.max(rigth - left + 1, res);
                System.out.println(res + "_" + left + " " +rigth);
                stack(min, r, 0);
                stack(max, r, 1);
                System.out.println("min " + min.peek() + "max " + max.peek());
                rigth++;
            }else {
                int l = nums[left];
                if (!max.isEmpty() && l == max.peek()){
                    max.pollFirst();
                }
                if (!min.isEmpty() && l == min.peek()){
                    min.pollFirst();
                }
                left++;
            }

        }
        return res;
    }
    public void  stack(LinkedList<Integer> list, int num, int mark){
        if (list.isEmpty()){
            list.add(num);
        }else if(mark == 1){
            while (!list.isEmpty()){
                if (list.peekLast() < num){
                    list.pollLast();
                }else{
                    break;
                }
            }
            list.addLast(num);
        }else {
            while (!list.isEmpty()){
                if (list.peekLast() > num){
                    list.pollLast();
                }else{
                    break;
                }

            }
            list.addLast(num);
        }

    }
}
