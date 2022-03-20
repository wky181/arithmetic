package data_structure.graph;

import java.util.*;

/**
 * @Author: wky233
 * @Date: 2020/7/7 21:39
 * @Description: 计算联通分量
 */
public class CCBFS {
    private Graph G;
    private int[] visited;
    private int ccount;
    private ArrayList<Integer> arrayList = new ArrayList<>();
    public CCBFS(Graph g) {
        this.G = g;
        visited = new int[G.getV()];
        Arrays.fill(visited,-1);
        for (int v = 0; v < G.getV() ; v++) {
            if (visited[v] == -1){
                bfs(v,ccount);
                ccount++;
            }
        }
    }
    private void bfs(int s, int ccid) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        visited[s] = ccid;
        while (!queue.isEmpty()){
            int  v = queue.poll();
            arrayList.add(v);
            for (int w : G.adj(v)) {
                if (visited[w] == -1) {
                    queue.offer(w);
                    visited[w] = ccid;
                }
            }
        }
    }

    public Iterable<Integer> getArrayList() {
        return arrayList;
    }

    // 返回各个连通分量子集
    public ArrayList<Integer>[] component(){
        ArrayList<Integer>[] res = new ArrayList[ccount];
        for (int i = 0; i < ccount ; i++) {
            res[i] = new ArrayList<Integer>();
        }
        for (int v = 0; v < ccount ; v++) {
            res[visited[v]].add(v);
        }
        return res;
     }
    public static void main(String[] args) {
        Graph graph = new Graph("g.txt");
        GraphBFS bfs = new GraphBFS(graph);
        for (int v : bfs.getArrayList()) {
            System.out.print(v + " ");
        }
        System.out.println(bfs);
    }
}
