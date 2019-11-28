package data_structure.stack.stack_problem;


import java.util.ArrayList;

/**
 * @author 武凯焱
 * @date 2019/11/26 21:45
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
/*        Myquene myquene = new Myquene();
        myquene.enqueue(1);
        myquene.enqueue(2);
        myquene.enqueue(3);
        System.out.println(myquene.departure());*/
    int[] nums = {6,5,4,65,1,24};
    TwoSatckSort twoSatckSort = new TwoSatckSort();
    ArrayList arrayList =  twoSatckSort.twoSatckSort(nums);
    System.out.println(arrayList.toString());
    }
}
