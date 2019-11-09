package leetcode;

import java.util.HashSet;

/**
 * @author 武凯焱
 * @date 2019/8/10 15:02
 * @Description:
 */
public class 分糖果 {
    public static void main(String[] args) {
        int[] candies = Utils.getRandomArr(10,1,3);
        Utils.show(candies);
        System.out.println(distributeCandies(candies));
    }

    public static int distributeCandies(int[] candies) {
       /* HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i <candies.length ; i++) {
            hashSet.add(candies[i]);
        }
        if (hashSet.size()>=candies.length/2){
            return candies.length/2;
        }else {
            return hashSet.size();
        }*/
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i : candies) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        boolean[] type = new boolean[max-min+1];
        int count = 0;
        for (int i: candies) {
            if (!type[i-min]) {
                count++;
                if (count>=candies.length/2){
                    return candies.length/2;
                }
                type[i - min] = true;
            }
        }
        return count;
    }
}
