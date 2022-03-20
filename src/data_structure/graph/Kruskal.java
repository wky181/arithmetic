package data_structure.graph;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: wky233
 * @Date: 2020/7/9 22:05
 * @Description:
 */
public class Kruskal {
    private WeightGraph G;
    private ArrayList<WeightEdge> mst;
    public Kruskal(WeightGraph g) {
        this.G = g;
        mst = new ArrayList<>();
        WeigthCC cc = new WeigthCC(G);
        if (cc.getCcount() > 1){
            return;
        }
        //Kruskal
        ArrayList<WeightEdge> edges = new ArrayList<>();
        for (int v = 0; v < G.getV(); v++) {
            for (int w: G.adj(v)) {
                if (v < w){
                    edges.add(new WeightEdge(v,w,G.getWeight(v,w)));
                }
            }
        }
        Collections.sort(edges);
        UF uf = new UF(G.getV());
        for (WeightEdge edge: edges){
            int v = edge.getV();
            int w = edge.getW();
            if (!uf.isConnect(v,w)){
                mst.add(edge);
                uf.UnionElements(v,w);
            }
        }
    }

    public ArrayList<WeightEdge> getMst() {
        return mst;
    }

    public static void main(String[] args) {
        WeightGraph g = new WeightGraph("weight-g.txt");
        Kruskal kruskal = new Kruskal(g);
        System.out.println(kruskal.getMst());
    }
}
