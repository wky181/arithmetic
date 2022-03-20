package demo;

import java.util.HashMap;





























import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/10/10 19:30
 * @Description:
 */
public class Blf4 {
    static HashMap<Character, HashSet<Character>> graph;
    static HashSet<Character> visited;
    static HashSet<Character> onPath;
    static int count = 0;
    public static void main(String[] args){
        int[] nums = {2, 5, 8};
        Scanner sc = new Scanner(System.in);
        String mod = sc.next();
        int n = sc.nextInt();
        String[] strs  = new String[n];
        for (int i = 0; i < n ; i++) {
            String str = sc.next();
            strs[i] = str;
        }
        buildTree(strs);
        dfs(mod.charAt(0));
        System.out.println(count);
    }
    public static void buildTree(String[] strings){
        graph = new HashMap<>();
        visited = new HashSet<>();
        onPath = new HashSet<>();
        for (String s: strings){
            char first = s.charAt(0);
            char end = s.charAt(s.length() - 1);
            if (!graph.containsKey(first)){
                graph.put(first,new HashSet<>());
            }
            if (!graph.containsKey(end)){
                graph.put(end,new HashSet<>());
            }
            graph.get(first).add(end);
        }
    }
    public static boolean dfs(Character v){
        visited.add(v);
        onPath.add(v);
        HashSet<Character> hashSet = graph.get(v);
        for (Character w: hashSet) {
            if (!visited.contains(w)){
                count++;
                if (dfs(w)){
                    return true;
                }
            }else if (onPath.contains(w)){
                return true;
            }
        }
        onPath.remove(v);
        return false;
    }
}

