package data_structure.graph;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: wky233
 * @Date: 2020/7/17 10:48
 * @Description:
 */
public class Kruskal1 {
    private WeightGraph G;
    private ArrayList<WeightEdge> mst;

    public Kruskal1(WeightGraph g) {
        this.G = g;
        WeigthCC cc = new WeigthCC(g);
        if (cc.getCcount() > 1){
            return;
        }
        this.mst = new ArrayList<>();
        ArrayList<WeightEdge> weights = new ArrayList<>();
        for (int v = 0; v < g.getV(); v++) {
            for (int w: g.adj(v)) {
                if (w < v){
                    weights.add(new WeightEdge(v,w,g.getWeight(v,w)));
                }
            }
        }
        Collections.sort(weights);
        UF uf = new UF(G.getV());
        for (WeightEdge weightEdge: weights) {
            if (!uf.isConnect(weightEdge.getV(),weightEdge.getW())){
                uf.UnionElements(weightEdge.getV(),weightEdge.getW());
                mst.add(weightEdge);
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
