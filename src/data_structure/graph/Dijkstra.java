package data_structure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/**
 * @Author: wky233
 * @Date: 2020/7/10 14:00
 * @Description:
 */
public class Dijkstra {
    private WeightGraph G;
    private int s;
    private int[] dis;
    private boolean[] visited;
    private int[] pre;

    public Dijkstra(WeightGraph g, int s) {
        G = g;
        this.s = s;
        this.dis = new int[G.getV()];
        pre = new int[G.getV()];
        Arrays.fill(dis, Integer.MAX_VALUE);
        Arrays.fill(pre, -1);
        dis[s] = 0;
        pre[s] = s;
        visited = new boolean[G.getV()];
        while (true){
            int distance = Integer.MAX_VALUE;
            int curV = -1;
            for (int v = 0; v < g.getV(); v++) {
                if (!visited[v] && dis[v] < distance){
                    distance = dis[v];
                    curV = v;
                }
            }
            if (curV == -1){
                break;
            }
            visited[curV] = true;
            for (int w: g.adj(curV)) {
                if (!visited[w]) {
                    if (g.getWeight(curV,w) + dis[curV] < dis[w]) {
                        dis[w] = g.getWeight(curV,w) + dis[curV];
                        pre[w] = curV;
                    }
                }
            }
        }

    }

    public boolean isConnected(int w) {
        G.validateVertex(w);
        return visited[w];
    }

    public int disTo(int v) {
        G.validateVertex(v);
        return dis[v];
    }

    public Iterable<Integer> path(int t) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (!isConnected(t)) {
            return arrayList;
        }
        int cur = t;
        for (int i = 0; i < pre.length; i++) {
            System.out.print(String.format("(index: %d val: %d)", i, pre[i]));
        }
        System.out.println();
        while (cur != s) {
            arrayList.add(cur);
            cur = pre[cur];
        }
        arrayList.add(s);
        Collections.reverse(arrayList);
        return arrayList;
    }

    public static void main(String[] args) {
        WeightGraph weightGraph = new WeightGraph("dj-g.txt");
        Dijkstra dijkstra = new Dijkstra(weightGraph, 0);
        for (int v = 0; v < weightGraph.getV(); v++) {
            System.out.print(dijkstra.disTo(v) + "p ");
        }
        System.out.println();
        System.out.println(dijkstra.path(3));
    }

    private class Node implements Comparable<Node> {
        public int v;
        public int dis;

        public Node(int v, int dis) {
            this.v = v;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node another) {
            return dis - another.dis;
        }
    }
}
