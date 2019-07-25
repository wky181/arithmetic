package class_09;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 武凯焱
 * @date 2019/3/5 15:21
 * @Description:
 */
public class _9_3合法括号 {

    public static void main(String[] args) {
       /*Set<String> set   = new HashSet<>();
        Set<String> set1   = solve(3);
        set =  parenthesis(3);
        for (String str: set1
             ) {
            System.out.print(str+" ");
        }
        System.out.println();*/
       ditui();
    }

    /**
     * 逐步生成之递归解法
     * @param n
     * @return
     */
    public static Set<String> parenthesis(int n ){
        Set<String> set = new HashSet<>();
        if (n==1){
            set.add("()");
            return set;
        }
     Set<String> tempSet =   parenthesis(n-1);
        for (String str: tempSet
             ) {
            set.add("()"+str);
            set.add(str+"()");
            set.add("("+str+")");
        }
        return set;
    }
    /**
     * 迭代形式
     */
    public static Set<String> solve(int n){
        Set<String> set = new HashSet<>();
        set.add("()");
        for (int i = 2; i <=n ; i++) {
            Set<String> stringSet = new HashSet<>();
            for (String str: set) {
                stringSet.add("()"+str);
                stringSet.add(str+"()");
                stringSet.add("("+str+")");
            }
            set = stringSet;
        }
        return set;
    }
    /**
     * 括号生成
     */
    public static List<String> ditui(){
        Set<String> set  = new HashSet<>();
        set.add("()");
        for (int i = 1; i <3 ; i++) {
            Set<String> stringSet = new HashSet<>();
            for (String str:set
                 ) {
                stringSet.add("("+str+")");
                stringSet.add(str+"()");
                stringSet.add("()"+str);


            }
         set = stringSet;
        }
        List<String> list = new ArrayList<String>();
        for (String str:set
             ) {
            list.add(str);
            System.out.println(str);
        }
        return list;
    }

}
