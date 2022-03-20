package data_structure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: wky233
 * @Date: 2020/7/17 16:40
 * @Description:
 */
public class Dijkstra1 {
    WeightGraph graph;
    int[] dis;
    int s;
    int target;
    public Dijkstra1(WeightGraph graph, int s, int target) {
        this.graph = graph;
        dis = new int[graph.getV()];
        this.s = s;
        this.target = target;
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[s] = 0;
        Queue<WeightEdge> queue = new PriorityQueue<>();
        for (int w: graph.adj(s)) {
            queue.offer(new WeightEdge(s,w, graph.getWeight(s,w)));
        }
        while (!queue.isEmpty()){
            WeightEdge edge = queue.poll();

        }
    }
}
