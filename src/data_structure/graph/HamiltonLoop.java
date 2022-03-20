package data_structure.graph;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: wky233
 * @Date: 2020/7/9 11:14
 * @Description: 哈密顿回路
 */
public class HamiltonLoop {
    private Graph G;
    private boolean[] vistied;
    private int[] pre;
    private int end;
    public HamiltonLoop(Graph g) {
        this.G = g;
        vistied = new boolean[G.getV()];
        pre = new int[G.getV()];
        dfs(0, G.getV());
    }
    private boolean dfs(int v, int left) {
        vistied[v] = true;
        left--;
        if (G.hasEdge(v,0) && left == 0){
            end = v;
            return true;
        }
        for (int w : G.adj(v)) {
            if (!vistied[w]) {
                pre[w] = v;
                if (dfs(w, left)) {
                    return true;
                }
            }
          /*  else if (w == 0 && left == 0) {
                end = v;
                return true;
            }*/
        }
        // 回溯
        vistied[v] = false;
        return false;
    }
    public Iterable<Integer> path(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (end == -1){
            return arrayList;
        }
        int cur = end;
        while (cur != 0){
            arrayList.add(cur);
            cur = pre[cur];
        }
        arrayList.add(0);
        Collections.reverse(arrayList);
        return arrayList;
    }
    public static void main(String[] args) {
        Graph g = new Graph("loop.txt");
        HamiltonLoop loop = new HamiltonLoop(g);
        for (int num: loop.path()) {
            System.out.print(num + " ");
        }
    }
}
