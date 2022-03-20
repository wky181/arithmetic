package demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/9/18 17:10
 * @Description:
 */
public class Blf2 {
    static HashMap<Character, HashSet<Character>> graph;
    static HashSet<Character> visited;
    static HashSet<Character> onPath;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = sc.next();
        }
        buildTree(strings);
        for (Character character: graph.keySet()) {
            if (!visited.contains(character)){
                if (dfs(character)){
                    System.out.println("Y");
                    return;
                }
            }
        }
        System.out.println("N");
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
