package data_structure.graph;

import java.util.*;

/**
 * @Author: wky233
 * @Date: 2020/7/7 22:53
 * @Description:
 */
// 无权单源最短路径问题
public class USSSPath {
    private Graph G;
    private boolean[] visited;
    private int[] pre;
    // 最短路径
    int[] dis;
    // 源点
    private int s;
    private ArrayList<Integer> arrayList = new ArrayList<>();

    public USSSPath(Graph g, int s) {
        this.G = g;
        this.s = s;
        visited = new boolean[G.getV()];
        dis = new int[G.getV()];
        pre = new int[G.getV()];
        Arrays.fill(pre,-1);
        Arrays.fill(dis,-1);
        bfs();
    }
    public int dis(int t){
        G.validateVertex(t);
        return dis[t];
    }

    private void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        pre[s] = s;
        dis[s] = 0;
        visited[s] = true;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            arrayList.add(v);
            for (int w : G.adj(v)) {
                if (!visited[w]) {
                    pre[w] = v;
                    dis[w] = dis[v] + 1;
                    queue.offer(w);
                    visited[w] = true;
                }
            }
        }
    }

    public Iterable<Integer> getArrayList() {
        return arrayList;
    }
    public Iterable<Integer> getPath(int t) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (!isConnectTo(t)){
            return arrayList;
        }
        int cur = t;
        while (cur != s){
            arrayList.add(cur);
            cur = pre[cur];
        }
        arrayList.add(s);
        Collections.reverse(arrayList);
        return arrayList;
    }

    public boolean isConnectTo(int t){
        G.validateVertex(t);
        return visited[t];
    }

    public static void main(String[] args) {
        Graph graph = new Graph("g.txt");
       USSSPath bfs = new USSSPath(graph,0);
        for (int v : bfs.getPath(6)) {
            System.out.print(v + " ");
        }
        System.out.println();
        System.out.println(bfs.dis(1));
    }
}
