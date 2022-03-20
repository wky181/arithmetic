package data_structure.graph;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: wky233
 * @Date: 2020/7/9 17:19
 * @Description:
 */
public class HamiltonLoopZip {
    private Graph G;
    private int vistied;
    private int[] pre;
    private int end;
    public HamiltonLoopZip(Graph g) {
        this.G = g;
        vistied = 0;
        pre = new int[G.getV()];
        dfs(0, G.getV());
    }
    private boolean dfs(int v, int left) {
        vistied += 1 << v;
        left--;
        if (G.hasEdge(v,0) && left == 0){
            end = v;
            return true;
        }
        for (int w : G.adj(v)) {
            if ((vistied & (1 << w)) == 0) {
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
        vistied -= 1 << v;
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
        HamiltonLoopZip loop = new HamiltonLoopZip(g);
        for (int num: loop.path()) {
            System.out.print(num + " ");
        }
    }
}
