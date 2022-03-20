package demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/9/23 20:35
 * @Description:
 */
public class Qn2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        String[] strings = new String[m];
        HashSet<Character> set = new HashSet<>();
        int[] nums = new int[m];
        for (int i = 0; i < strings.length ; i++) {
            strings[i] = sc.next();
            set.add(strings[i].charAt(0));
            String ch = strings[i].substring(1);
            switch (ch){
                case"A":
                    nums[i] = 14;
                    continue;
                case"K":
                    nums[i] = 13;
                    continue;
                case"Q":
                    nums[i] = 12;
                    continue;
                case "J":
                    nums[i] = 11;
                    continue;
                default:
                    nums[i] =Integer.parseInt(ch);
            }
        }
        boolean isShu = isShu(nums);
       // System.out.println(nums[nums.length - 1]);
      //  System.out.println(set.size());
        if (isShu){
            if (set.size() == 1 ){
                if (nums[nums.length - 1] == 14) {
                    System.out.println("HuangJiaTongHuaShun");
                }else {
                    System.out.println("TongHuaShun");
                }
                return;
            }else {
                System.out.println("ShunZi");
                return;
            }
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count =  hashMap.getOrDefault(nums[i], 0) + 1;
            hashMap.put(nums[i],count);
        }
        for (Integer integer: hashMap.keySet()) {
            int count = hashMap.get(integer);
            if (count == 4){
                System.out.println("SiTiao");
                return;
            }else if (count == 3){
                if (hashMap.size() == m - 3 + 1){
                    System.out.println("SanTiao");
                }else {
                    System.out.println("HuLu");
                }
                return;
            }else if (count == 2){
                if (hashMap.size() <= m / 2 + 1){
                    System.out.println("LiangDui");
                }else {
                    System.out.println("YiDui");
                }
                return;
            }
        }
        if (set.size() == 1){
            System.out.println("TongHua");
            return;
        }
        System.out.println("GaoPai");
    }
    public static boolean isShu(int[] nums){
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1 ; i++) {
            if (nums[i + 1] - nums[i] != 1){
                return false;
            }
        }
        return true;
    }
}
