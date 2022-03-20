package data_structure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: wky233
 * @Date: 2020/7/7 21:58
 * @Description:
 */
public class CycleDetectionBFS {
    private Graph G;
    private boolean[] visited;
    private boolean hasCycle = false;
    private int[] pre;
    public CycleDetectionBFS(Graph g) {
        this.G = g;
        visited = new boolean[G.getV()];
        pre = new int[G.getV()];
        Arrays.fill(pre,-1);
        for (int v = 0; v < G.getV() ; v++) {
            if (!visited[v]){
                if(bfs(v)){
                    hasCycle = true;
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
            for (int w : G.adj(v)) {
                if (!visited[w]) {
                    queue.offer(w);
                    pre[w] = v;
                    visited[w] = true;
                }else if (pre[v] != w){
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Graph g = new Graph("g.txt");
        CycleDetectionBFS cycleDetectionBFS = new CycleDetectionBFS(g);
        System.out.println(cycleDetectionBFS.hasCycle);
    }
}
