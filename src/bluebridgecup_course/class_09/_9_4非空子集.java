package bluebridgecup_course.class_09;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 武凯焱
 * @date 2019/3/6 16:59
 * @Description:
 */
public class _9_4非空子集 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        Set<Set<Integer>> sets = solve(arr,arr.length,arr.length-1);
        ArrayList<ArrayList<Integer>> arrys = solve1(arr,arr.length);
        for (ArrayList arry: arrys
             ) {
            System.out.println(arry.toString());
        }
    }
    /**
     * 递归增量实现
     * @return
     */
    public static Set<Set<Integer>> solve(int[] A ,int n, int cur){
        Set<Set<Integer>> newSet = new HashSet<>();
        if (cur == 0){
            Set<Integer> nil = new HashSet<>();//空集
            Set<Integer> first = new HashSet<>();//包含第一个元素的集合
            first.add(A[0]);
            newSet.add(nil);
            newSet.add(first);
            return newSet;
        }
            Set<Set<Integer>> oldSet = solve(A,n,cur-1);
        for (Set set: oldSet) {
            //对于每个子集,cur这个元素可以加进去,也可以不加进去
            newSet.add(set);//保留原样
            Set<Integer> clone = (Set<Integer>) ((HashSet) set).clone();
            clone.add(A[cur]);//添加当前元素
            newSet.add(clone);
        }
        return newSet;
    }

    /**
     *
     */
    public static   ArrayList<ArrayList<Integer>>  solve1(int[] arr,int n){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i <=pow(2,n)-1 ; i++) {
            ArrayList<Integer> s = new ArrayList<>();
            for (int j = n-1; j >=0 ; j--) { //每次从高位开始检查
                if (((i>>j)& 1) == 1){
                    s.add(arr[j]);
                }
            }
            res.add(s);
        }
        return  res;
    }
    public static int pow(int num , int n){
        if (n<=0){
            return 1;
        }
        if (n==1){
            return num;
        }
        int pow = 1;
        int res = num;
        while ((pow<<1)<=n){
            res *= res ;
            pow<<=1;
        }
        return res*pow(num,n-pow);
    }
}
