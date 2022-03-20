package data_structure.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: wky233
 * @Date: 2020/7/10 9:02
 * @Description:
 */
public class Prim {
    private WeightGraph G;
    private ArrayList<WeightEdge> mst;
    private boolean[] visited;

    public Prim(WeightGraph g) {
        G = g;
        mst = new ArrayList<>();
        visited = new boolean[G.getV()];
        WeigthCC cc = new WeigthCC(G);
        if (cc.getCcount() > 1) {
            return;
        }
        //先将0染色
        visited[0] = true;
        // 优先队列
        Queue<WeightEdge> pq = new PriorityQueue<>();
        // 初始化
        for (int w: G.adj(0)) {
            pq.offer(new WeightEdge(0,w,g.getWeight(0,w)));
        }
        while (!pq.isEmpty()){
            WeightEdge min = pq.poll();
            if (visited[min.getW()] && visited[min.getV()]){
                continue;
            }
            mst.add(min);
            int newv = visited[min.getW()] ? min.getV() : min.getW();
            visited[newv] = true;
            for (int w : G.adj(newv)) {
                if (!visited[w]){
                    pq.offer(new WeightEdge(newv,w,g.getWeight(newv,w)));
                }
            }
        }
       /* //有V-1条边
        for (int i = 1; i < G.getV(); i++) {
            WeightEdge minEdge = new WeightEdge(-1, -1, Integer.MAX_VALUE);
            // 找出最小横切边
            for (int v = 0; v < G.getV(); v++) {
                if (visited[v]) {
                    for (int w : g.adj(v)) {
                        // 横切边 v访问过 w未访问
                        if (!visited[w] && minEdge.getWeight() > g.getWeight(v, w)) {
                            int weight = g.getWeight(v, w);
                            minEdge = new WeightEdge(v, w, weight);
                        }
                    }
                }
            }
            mst.add(minEdge);
            visited[minEdge.getW()] = true;
        }*/
    }

    public ArrayList<WeightEdge> getMst() {
        return mst;
    }

    public static void main(String[] args) {
        WeightGraph weightGraph = new WeightGraph("weight-g.txt");
        Prim prim = new Prim(weightGraph);
        System.out.println(prim.getMst());
    }
}
