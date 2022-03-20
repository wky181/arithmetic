package data_structure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: wky233
 * @Date: 2020/7/7 22:27
 * @Description:
 */
public class BipartitionDetectionBFS {
    private Graph G;
    private boolean[] visited;
    private int[] colors;
    private boolean isBipartition = true;
    private ArrayList<Integer> arrayList = new ArrayList<>();
    public BipartitionDetectionBFS(Graph g) {
        this.G = g;
        visited = new boolean[G.getV()];
        colors = new int[G.getV()];
        for (int v = 0; v < G.getV() ; v++) {
            if (!visited[v]){
                if (!bfs(v)){
                    isBipartition = false;
                    return;
                }
            }
        }
    }

    private boolean bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        visited[s] = true;
        while (!queue.isEmpty()){
            int  v = queue.poll();
            int color =  colors[v];
           // arrayList.add(v);
            for (int w : G.adj(v)) {
                if (!visited[w]) {
                    queue.offer(w);
                    visited[w] = true;
                    colors[w] = 1 - color;
                }else if (colors[w] == color){
                    return false;
                }
            }
        }
        return true;
    }

    public Iterable<Integer> getArrayList() {
        return arrayList;
    }

    public static void main(String[] args) {
        Graph graph = new Graph("g.txt");
        BipartitionDetectionBFS b1 = new BipartitionDetectionBFS(graph);
        System.out.println(b1.isBipartition);
        Graph graph1 = new Graph("g2.txt");
        BipartitionDetectionBFS b2 = new BipartitionDetectionBFS(graph1);
        System.out.println(b2.isBipartition);
    }
}
