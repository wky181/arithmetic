package data_structure.graph;

import java.util.ArrayList;

/**
 * @Author: wky233
 * @Date: 2020/7/7 15:45
 * @Description:
 */
public class CycleDetection {
    private Graph G;
    private boolean[] vistied;
    private boolean hasCycle = false;

    public boolean isHasCycle() {
        return hasCycle;
    }

    public CycleDetection(Graph g) {
        this.G = g;
        vistied = new boolean[G.getV()];
        for (int v = 0; v < G.getV() ; v++) {
            if (!vistied[v]){
                if (dfs(v,v)){
                    hasCycle = true;
                    break;
                }
            }
        }
    }

    private boolean dfs(int v, int parent) {
        vistied[v] = true;
        for (int w: G.adj(v)) {
            if (!vistied[w]){
                if (dfs(w,v)){
                    return true;
                }
            }
            // 排除邻边的情况 v的parent 不为w 则不是一条边
            else if (w != parent){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Graph g = new Graph("g.txt");
        Graph g2 = new Graph("g2.txt");
        CycleDetection detection = new CycleDetection(g);
        System.out.println(detection.hasCycle);
        CycleDetection detection2 = new CycleDetection(g2);
        System.out.println(detection2.hasCycle);
    }
}
