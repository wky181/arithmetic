package NewCoder.yuewen;

import com.sun.javafx.css.PseudoClassState;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/5/19 20:05
 * @Description:
 * 3
 * 1,1,0
 * 1,1,1
 * 0,1,1
 */
public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][n];
        for(int i = 0; i < n; i++){
            String s = sc.next();
            String[] split = s.split(",");
            for(int j = 0; j < split.length; j++){
                nums[i][j] = Integer.parseInt(split[j]);
            }
        }
       /* HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < n ; i++) {
            HashSet<Integer> set =  new HashSet<>();
            for (int j = 0; j < n ; j++) {
                if (i !=j && nums[i][j] == 1){
                    set.add(j);
                }
                map.put(i,set);
            }
        }
        int res = 0;
        for (int i = 0; i < n ; i++) {
            HashSet<Integer> set = map.get(i);
            res++;
            for (int num : set) {
                map.get(num)
            }
        }*/
    }
}
