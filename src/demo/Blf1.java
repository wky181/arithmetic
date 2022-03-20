package demo;

import java.util.*;

/**
 * @Author: wky233
 * @Date: 2020/9/18 17:04
 * @Description:
 */
public class Blf1 {
    static HashMap<Integer, HashSet<Integer>> graph;
    static HashSet<Integer> visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] array = s.toCharArray();
        int count = 0;
        List<List<Integer>> listList = new ArrayList<>();
        for (int i = 0; i < array.length;) {
            List<Integer> list = new ArrayList<>();
            while ( i < array.length && count < 2){
                if (Character.isDigit(array[i])){
                    int num = 0;
                    while (Character.isDigit(array[i])){
                        num = num * 10 + array[i] - '0';
                        i++;
                    }
                    list.add(num);
                    count++;
                }else {
                    i++;
                }
            }
            count  = 0;
            if (i < array.length){
                listList.add(list);
            }
        }
        buildTree(listList);
        for (Integer v: graph.keySet()) {
            if (!visited.contains(v)){
                if (dfs(v,v)){
                    System.out.println("Y");
                    return;
                }
            }
        }
        System.out.println("N");
    }

    public static void buildTree(List<List<Integer>> listList){
        graph = new HashMap<>();
        visited = new HashSet<>();
        for (List<Integer> list: listList) {
            Integer from = list.get(0);
            Integer to = list.get(1);
            System.out.println(from + "->" + to);
            if (!graph.containsKey(from)){
                graph.put(from,new HashSet<>());
            }
            if (!graph.containsKey(to)){
                graph.put(to,new HashSet<>());
            }
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
    }
    public static boolean dfs(Integer v, Integer parent){
        visited.add(v);
        HashSet<Integer> hashSet = graph.get(v);
        for (Integer w: hashSet) {
            if (!visited.contains(w)){
                if (dfs(w,v)){
                    return true;
                }
            }else if (!w.equals(parent)){
                return true;
            }
        }
        return false;
    }
}
