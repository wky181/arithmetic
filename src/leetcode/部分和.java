package leetcode;

import java.util.ArrayList;

/**
 * @author 武凯焱
 * @date 2019/3/11 9:03
 * @Description:
 */
public class 部分和 {
    public static void main(String[] args) {
            int[] arr = {1,0,2,4,7,1};
        System.out.println(solve(arr,12));
        dfs(arr,4,0,new ArrayList<Integer>());
    }
    //二进制模板
    public static boolean solve(int[] arr ,int target){
        int n = pow(2,arr.length)-1;
        for (int i = 1; i <=n ; i++) {
            int res = 0;
            for (int j = 0; j <arr.length ; j++) {
                if (((i>>j)& 1) == 1){
                    res+=arr[j];
                }
            }
            if (res==target){
                return true;
            }

        }
        return false;
    }
    public static int pow (int x,int p){
        if(p==0){
            return 1;
        }
        int res = x;
        int n =  1;
        while (n*2<=p){
            res*=res;
            n*=2;
        }
        return res*pow(x,p-n);
    }
    public static void  dfs(int[] arrs, int k, int cur, ArrayList<Integer> list){
        if (k==0){
            System.out.println("yes");
            for (Integer num: list
                 ) {
                System.out.print(num+" ");
            }
            System.exit(0);
        }
        if (k<0 || cur == arrs.length){
            return;
        }
        list.add(arrs[cur]);
        int index = list.size()-1;
        dfs(arrs,k-arrs[cur],cur+1,list); //选择当前元素
        list.remove(index); //回溯
        dfs(arrs,k,cur+1,list);

    }
}
