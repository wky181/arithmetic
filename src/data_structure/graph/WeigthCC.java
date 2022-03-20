package data_structure.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/7/9 22:30
 * @Description:
 */
public class WeigthCC {
    private WeightGraph G;
    private int[] vistied;
    private int ccount;

    public int getCcount() {
      /*  for (int count: vistied) {
            System.out.print(count + " ");
        }
        System.out.println();*/
        return ccount;
    }
    public WeigthCC(WeightGraph g) {
        this.G = g;
        vistied = new int[g.getV()];
        Arrays.fill(vistied,-1);
        for (int i = 0; i < G.getV() ; i++) {
            if (vistied[i] == -1){
                dfs(i,ccount++);
            }
        }

    }

    public boolean isConnected(int v, int w){
        G.validateVertex(v);
        G.validateVertex(w);
        return vistied[v] == vistied[w];
    }

    private void dfs(int v, int count) {
        vistied[v] = count;
        for (int w : G.adj(v)) {
            if (vistied[w] == -1){
                dfs(w,count);
            }
        }
    }
    // 返回各个连通分量子集
    public ArrayList<Integer>[] component(){
        ArrayList<Integer>[] arrayLists = new ArrayList[ccount];
        for (int i = 0; i < ccount ; i++) {
            arrayLists[i] = new ArrayList<>();
        }
        for (int v = 0; v < G.getV() ; v++) {
            arrayLists[vistied[v]].add(v);
        }
        return arrayLists;
    }
    public static void main(String[] args) {
        Graph g = new Graph("g.txt");
        CC cc = new CC(g);
        System.out.println(cc.getCcount());
        System.out.println(cc.isConnected(0,4));
        ArrayList<Integer>[] components = cc.component();
        for (int ccid = 0; ccid < components.length ; ccid++) {
            System.out.print (ccid + " : ");
            for (int w: components[ccid]) {
                System.out.print (w + " ");
            }
            System.out.println();
        }
    }
}
