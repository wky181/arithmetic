package data_structure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @Author: wky233
 * @Date: 2020/7/7 15:30
 * @Description:
 */
public class Path {
    private Graph G;
    // 源
    private int s;
    // 目标
    private int t;
    //private boolean[] vistied;
    private int[] pre;
    public Path(Graph g, int s, int t) {
        this.G = g;
        G.validateVertex(s);
        this.s = s;
        //vistied = new boolean[G.getV()];
        pre = new int[G.getV()];
        Arrays.fill(pre,-1);
        this.t  = t;
        dfs(s,s);

    }
    public boolean isConnectedTo(int t){
        G.validateVertex(t);
        return pre[t] != -1;
    }
    public Iterable<Integer> path(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (!isConnectedTo(t)){
            return arrayList;
        }
        // System.out.println(isConnectedTo(t));
        int cur = t;
        while (cur != s){
            arrayList.add(cur);
            //  System.out.println(cur);
            cur = pre[cur];
        }
        arrayList.add(s);
        Collections.reverse(arrayList);
        return arrayList;
    }
    private boolean dfs(int v, int parent) {
        pre[v] = parent;
        if (v == t){
            return true;
        }
        for (int w: G.adj(v)) {
            if (pre[w] == -1){
                if (dfs(w,v)){
                 return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Graph g = new Graph("g.txt");
        Path p = new Path(g,0,6);
        System.out.println("0 -> 6 " + p.path());
        Path p1 = new Path(g,0,1);
        System.out.println("0 -> 6 " + p1.path());
    }
}
