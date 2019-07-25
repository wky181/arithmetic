package class_09;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 武凯焱
 * @date 2019/3/7 15:02
 * @Description:
 */
public class _9_5全排列 {
    public static void main(String[] args) {
        /*List<String> arrayList = solve("ABC");
        for (String str:arrayList) {
            System.out.println(str);
        }*/
        List<String> list =  solve1("ABCD",3);
        System.out.println(list.size());
        for (String str: list) {
            System.out.println(str);
        }

    }

    /**
     * 迭代形式求解
     * @return
     */
    public static List<String> solve(String str){
        List<String> strings = new ArrayList<>();
        strings.add(0,""+str.charAt(0));
        for (int i = 1; i <str.length() ; i++) {
            List<String> list = new ArrayList<>();
            char c = str.charAt(i);
            for (String strs: strings
                 ) {
                String temp = c+strs;
                list.add(temp);
                temp = strs+c;
                list.add(temp);
                for (int j = 1; j <strs.length() ; j++) {
                    String temp1= strs.substring(0,j)+ c +strs.substring(j);
                    list.add(temp1);
                }
            }
            strings = list;
        }
        return strings;
    }
    /**
     * 递归形式求解
     */
    public static ArrayList<String> solve1(String string,int n){
        if (n==0){
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(0,""+string.charAt(0));
            return arrayList;
        }
        ArrayList<String>  arrayList   = solve1(string,n-1);
        ArrayList<String> arrayList1 = new ArrayList<>();
        char c = string.charAt(n);
        for (String str: arrayList) {  //对str中间的空和两边的空进行插入
           String temp = str + c;
           arrayList1.add(temp);
           temp = c+ str;
           arrayList1.add(temp);
            for (int i = 1; i <str.length() ; i++) {
                String  strs = str.substring(0,i) + c + str.substring(i);
                arrayList1.add(strs);
            }
        }
        return  arrayList1;
    }
}
