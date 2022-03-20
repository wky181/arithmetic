package data_structure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @Author: wky233
 * @Date: 2020/7/7 14:51
 * @Description:
 */
public class SingleSourcePath {
    private Graph G;
    // 源
    private int s;
    //private boolean[] vistied;
    private int[] pre;
    public SingleSourcePath(Graph g, int s) {
        this.G = g;
        G.validateVertex(s);
        this.s = s;
        //vistied = new boolean[G.getV()];
        pre = new int[G.getV()];
        Arrays.fill(pre,-1);
        dfs(s,s);

    }
    public boolean isConnectedTo(int t){
        G.validateVertex(t);
        return pre[t] != -1;
    }
    public Iterable<Integer> path(int t){
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
    private void dfs(int v, int parent) {
        pre[v] = parent;
        for (int w: G.adj(v)) {
            if (pre[w] == -1){
                dfs(w,v);
            }
        }
    }
    public static void main(String[] args) {
        Graph g = new Graph("g.txt");
        SingleSourcePath singleSourcePath = new SingleSourcePath(g,0);
        System.out.println("0 -> 6 " + singleSourcePath.path(6));
    }
}
