package data_structure.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: wky233
 * @Date: 2020/7/17 15:46
 * @Description:
 */
public class Prim1 {
    WeightGraph graph;
    ArrayList<WeightEdge> mst = new ArrayList<>();
    boolean visited[];
    public Prim1(WeightGraph graph) {
       this.graph = graph;
       visited = new boolean[graph.getV()];
       visited[0] = true;
       Queue<WeightEdge> queue = new PriorityQueue<>();
        for (int w : graph.adj(0)) {
            queue.offer(new WeightEdge(0,w, graph.getWeight(0,w)));
        }
        while (!queue.isEmpty()){
            WeightEdge edge = queue.poll();
            if (visited[edge.getW()] && visited[edge.getV()]){
                continue;
            }
            int newv = visited[edge.getW()] ? edge.getV() : edge.getW();
            visited[newv] = true;
            mst.add(edge);
            for (int w: graph.adj(newv)) {
                queue.offer(new WeightEdge(newv,w,graph.getWeight(newv,w)));
            }
        }

    }

    public ArrayList<WeightEdge> getMst(){
        return mst;
    }

    public static void main(String[] args) {
        WeightGraph weightGraph = new WeightGraph("weight-g.txt");
        Prim prim = new Prim(weightGraph);
        System.out.println(prim.getMst());
    }
}
