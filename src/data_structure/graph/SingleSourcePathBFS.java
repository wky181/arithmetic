package data_structure.graph;

import java.util.*;

/**
 * @Author: wky233
 * @Date: 2020/7/7 19:53
 * @Description:
 */
public class SingleSourcePathBFS {
    private Graph G;
    private boolean[] visited;
    private int[] pre;
    // 源点
    private int s;
    private ArrayList<Integer> arrayList = new ArrayList<>();

    public SingleSourcePathBFS(Graph g, int s) {
        this.G = g;
        this.s = s;
        visited = new boolean[G.getV()];
        pre = new int[G.getV()];
        Arrays.fill(pre,-1);
        bfs();
    }

    private void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        pre[s] = s;
        visited[s] = true;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            arrayList.add(v);
            for (int w : G.adj(v)) {
                if (!visited[w]) {
                    pre[w] = v;
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
        SingleSourcePathBFS bfs = new SingleSourcePathBFS(graph,0);
        for (int v : bfs.getPath(6)) {
            System.out.print(v + " ");
        }
    }
}
