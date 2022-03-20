package data_structure.graph;


/**
 * @Author: wky233
 * @Date: 2020/7/7 16:13
 * @Description:
 */
public class BipartitionDetection {
    private Graph G;
    private boolean[] vistied;
    private boolean isBipartition = true;
    private int[] colors;
    public BipartitionDetection(Graph g) {
        this.G = g;
        vistied = new boolean[G.getV()];
        colors = new int[G.getV()];
        // 判断每一个联通分量
        for (int i = 0; i < G.getV() ; i++) {
            if (!vistied[i]){
                if (!dfs(i,0)){
                    isBipartition = false;
                    break;
                }
            }
        }

    }

    private boolean dfs(int v, int color) {
        vistied[v] = true;
        colors[v] = color;
        for (int w: G.adj(v)) {
            if (!vistied[w]){
                if (!dfs(w, 1 - color)){
                    return false;
                }
            }else if (colors[w] == color){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Graph g = new Graph("g2.txt");
        BipartitionDetection b = new BipartitionDetection(g);
        System.out.println(b.isBipartition);
        Graph g1 = new Graph("g.txt");
        BipartitionDetection b1 = new BipartitionDetection(g1);
        System.out.println(b1.isBipartition);

    }
}
