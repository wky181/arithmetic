package LeetCodeSecond.weekrank;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author: wky233
 * @Date: 2020/7/12 10:43
 * @Description:
 */
public class LeetCode_5211 {
    private HashMap<Integer,Double>[] graph;
    private double[] dis;
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        graph = new HashMap[n];
        dis = new double[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashMap<>();
        }
        buildGraph(edges,succProb);
        bfs(start,end);
        return dis[end];
    }
    private Iterable<Integer> adj(int v){
       return graph[v].keySet();
    }
    private double weight(int v,int w){
        return graph[v].get(w);
    }
    private void bfs(int start, int end){
        boolean[] visited = new boolean[graph.length];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,1));
        while (!pq.isEmpty()){
            Node top = pq.poll();
            if (visited[top.v]){
                continue;
            }
            visited[top.v] = true;
            for (int w: adj(top.v)) {
                if (!visited[w]){
                    Node node = new Node(w,top.gai * weight(top.v,w));
                    pq.offer(node);
                    dis[w] = Math.max(dis[w],node.gai);
                }
            }
        }
    }
    private void buildGraph(int[][] edges,double[] succProb){
        for (int i = 0; i < edges.length ; i++) {
            int[] eage = edges[i];
            graph[eage[0]].put(eage[1],succProb[i]);
            graph[eage[1]].put(eage[0],succProb[i]);
        }
    }
    private class Node implements Comparable<Node>{
        int v;
        Double gai;

        public Node(int v, double gai) {
            this.v = v;
            this.gai = gai;
        }
        @Override
        public int compareTo(Node o) {
            return  o.gai.compareTo(gai);
        }
    }
}
