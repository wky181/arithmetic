package LeetCodeSecond.bst;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Author: wky233
 * @Date: 2020/6/8 17:38
 * @Description:
 */
public class BSTTest {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
  /*      int[] nums = {5,3,6,8,4,2};
        for (int i = 0; i < nums.length ; i++) {
            bst.add(nums[i]);
        }
        bst.inOrder();
       //    System.out.println(bst.toString());
        */
        Random random = new Random();
        int n = 10;
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            int anInt = random.nextInt(1000);
            bst.add(anInt);
            nums.add(anInt);
        }
        bst.inOrderNRPlus();
        while (!bst.isEmpty()){
            Integer integer = bst.removeMax();
            System.out.print(integer + ", ");
        }
        System.out.println();
        for (int i = 0; i < nums.size() ; i++) {
            System.out.print(nums.get(i) + ", ");
        }
    }
}
