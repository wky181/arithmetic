package data_structure.graph;

import java.util.ArrayList;

/**
 * @Author: wky233
 * @Date: 2020/7/6 23:41
 * @Description:
 */
public class GraphDFS {
    private Graph G;
    private boolean[] vistied;
    private ArrayList<Integer> pre = new ArrayList<>();
    private ArrayList<Integer> post = new ArrayList<>();
    public GraphDFS(Graph g) {
        this.G = g;
        vistied = new boolean[G.getV()];
        for (int i = 0; i < G.getV() ; i++) {
            if (!vistied[i]){
                dfs(i);
            }
        }

    }

    private void dfs(int v) {
        vistied[v] = true;
        pre.add(v);
        for (int w: G.adj(v)) {
            if (!vistied[w]){
                dfs(w);
            }
        }
        post.add(v);
    }

    public Iterable<Integer> getPre() {
        return pre;
    }
    public Iterable<Integer> getPost() {
        return post;
    }

    public static void main(String[] args) {
        Graph g = new Graph("g.txt");
        GraphDFS dfs = new GraphDFS(g);
        System.out.println(dfs.pre);
        System.out.println(dfs.post);
    }
}
