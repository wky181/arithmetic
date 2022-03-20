package data_structure.graph;

import java.util.*;

/**
 * @Author: wky233
 * @Date: 2020/7/7 21:11
 * @Description:
 */
public class PathBFS {
    private Graph G;
    private boolean[] visited;
    private int[] pre;
    // 源点
    private int s;
    // 目的
    private int t;
    //private ArrayList<Integer> arrayList = new ArrayList<>();

    public PathBFS(Graph g, int s,int t) {
        this.G = g;
        this.s = s;
        this.t = t;
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
            /*if (v == t){
                break;
            }*/
          //  arrayList.add(v);
            for (int w : G.adj(v)) {
                if (!visited[w]) {
                    pre[w] = v;
                    visited[w] = true;
                    queue.offer(w);
                    if (w == t){
                        return;
                    }
                }
            }
        }
    }


    public Iterable<Integer> getPath() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (!isConnectTo(t)){
            return arrayList;
        }
        System.out.println(isConnectTo(t));
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
        PathBFS bfs = new PathBFS(graph,0,3);
        for (int v : bfs.getPath()) {
            System.out.print(v + " ");
        }
    }

}
