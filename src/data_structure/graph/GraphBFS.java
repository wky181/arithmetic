package data_structure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: wky233
 * @Date: 2020/7/7 19:22
 * @Description:
 */
public class GraphBFS {
    private Graph G;
    private boolean[] visited;
    private ArrayList<Integer> arrayList = new ArrayList<>();
    public GraphBFS(Graph g) {
        this.G = g;
        visited = new boolean[G.getV()];
        for (int v = 0; v < G.getV() ; v++) {
            if (!visited[v]){
                bfs(v);
            }
        }
    }

    private void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        visited[s] = true;
        while (!queue.isEmpty()){
            int  v = queue.poll();
            arrayList.add(v);
            for (int w : G.adj(v)) {
                if (!visited[w]) {
                    queue.offer(w);
                    visited[w] = true;
                }
            }
        }
    }

    public Iterable<Integer> getArrayList() {
        return arrayList;
    }

    public static void main(String[] args) {
        Graph graph = new Graph("g.txt");
        GraphBFS bfs = new GraphBFS(graph);
        for (int v : bfs.getArrayList()) {
            System.out.print(v + " ");
        }
    }
}
