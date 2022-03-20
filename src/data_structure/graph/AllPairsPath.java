package data_structure.graph;

/**
 * @Author: wky233
 * @Date: 2020/7/7 20:43
 * @Description: 多对点路径
 */
public class AllPairsPath {
    private Graph G;
    private SingleSourcePath[] paths;

    public AllPairsPath(Graph g) {
        this.G = g;
        paths = new SingleSourcePath[G.getV()];
        for (int i = 0; i < G.getV() ; i++) {
            paths[i] = new SingleSourcePath(g,i);
        }
    }
    public boolean isConnectedTo(int s, int t){
        G.validateVertex(s);
        G.validateVertex(t);
        return paths[s].isConnectedTo(t);
    }
    public Iterable<Integer> path(int s, int t){
        G.validateVertex(s);
        return paths[s].path(t);
    }

    public static void main(String[] args) {
        Graph g = new Graph("g.txt");
        AllPairsPath allPairsPath = new AllPairsPath(g);
        System.out.println(allPairsPath.path(0,6));
    }
}
