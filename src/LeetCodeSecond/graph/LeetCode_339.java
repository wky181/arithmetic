package LeetCodeSecond.graph;

import java.util.*;

/**
 * @Author: wky233
 * @Date: 2020/7/11 12:44
 * @Description:
 */
public class LeetCode_339 {
    private Map<String, HashMap<String, Double>> graph = new HashMap<>();

    public void buildGraph(List<List<String>> equations, double[] values) {
        for (int i = 0; i < values.length; i++) {
            graph.computeIfAbsent(equations.get(i).get(0), k -> new HashMap<>()).put(equations.get(i).get(1), values[i]);
            graph.computeIfAbsent(equations.get(i).get(1), k -> new HashMap<>()).put(equations.get(i).get(0), 1 / values[i]);
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        buildGraph(equations, values);
        int index = 0;
        double[] res = new double[queries.size()];
        for (List<String> list : queries) {
            res[index++] = bfs(list.get(0), list.get(1));
        }
        return res;
    }

    public Iterable<String> adj(String v) {
        return graph.get(v).keySet();
    }

    public double weight(String v, String w) {
        return graph.get(v).get(w);
    }
    // bfs
    public double bfs(String v, String target) {
        if (!graph.containsKey(v)) {
            return -1L;
        }
        if (v.equals(target)) {
            return 1L;
        }
        HashSet<String> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(1L, v));
        visited.add(v);
        while (!queue.isEmpty()) {
            Node top = queue.poll();
            for (String w : adj(top.v)) {
                if (!visited.contains(w)) {
                    double weight = weight(top.v, w);
                    Node node = new Node(weight * top.res, w);
                    if (w.equals(target)) {
                        return node.res;
                    }
                    queue.offer(node);
                    visited.add(w);
                }
            }
        }
        return -1;
    }
    // dfs
    public double dfs(String v, String target, HashSet<String> visited) {
        if (!graph.containsKey(v)) {
            return -1L;
        }
        if (v.equals(target)) {
            return 1L;
        }
        visited.add(v);
        for (String w : adj(v)) {
            if (!visited.contains(w)){
                double next = dfs(w,target,visited);
                if (next == -1){
                    return weight(v, w) * next;
                }
            }
        }
        visited.remove(v);
        return -1;
    }
    private class Node {
        private double res;
        private String v;

        public Node(double res, String v) {
            this.res = res;
            this.v = v;
        }
    }
}
