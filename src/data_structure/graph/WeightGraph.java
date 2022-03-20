package data_structure.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @Author: wky233
 * @Date: 2020/7/9 21:10
 * @Description:
 */
public class WeightGraph implements  Cloneable {
    // 定点个数
    private int V;
    // 边条数
    private int E;
    private TreeMap<Integer,Integer>[] adj;

    public WeightGraph(String filename) {
        File file = new File(filename);
        try(Scanner scanner = new Scanner(file)){
            V =  scanner.nextInt();
            if (V < 0){
                throw new IllegalArgumentException("V<0");
            }
            E = scanner.nextInt();
            if (E < 0){
                throw new IllegalArgumentException("E<0");
            }
            adj = new TreeMap[V];
            for (int i = 0; i < V ; i++) {
                adj[i] = new TreeMap<>();
            }
            for (int i = 0; i < E ; i++) {
                int a = scanner.nextInt();
                validateVertex(a);
                int b = scanner.nextInt();
                validateVertex(b);
                int weiht = scanner.nextInt();
                if (adj[a].containsKey(b)){
                    throw  new IllegalArgumentException();
                }
                adj[a].put(b,weiht);
                adj[b].put(a,weiht);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void validateVertex(int v){
        if (v < 0 || v >= V){
            throw new IllegalArgumentException();
        }
    }
    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }
    public boolean hasEdge(int v, int w){
        validateVertex(v);
        validateVertex(w);
        return adj[v].containsKey(w);
    }
    public Iterable<Integer> adj(int v){
        validateVertex(v);
        return adj[v].keySet();
    }
    public int getWeight(int v, int w){
        if (hasEdge(v,w)){
            return adj[v].get(w);
        }
        throw new IllegalArgumentException();
    }
    public int degree(int v){
        validateVertex(v);
        return adj[v].size();
    }
    public void removeEdge(int v, int w){
        validateVertex(v);
        validateVertex(w);
        adj[v].remove(w);
        adj[w].remove(v);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("V = %d, E = %d", V, E));
        sb.append('\n');
        for (int v = 0; v < V ; v++) {
            sb.append(String.format("%d: ",v));
            for (Map.Entry<Integer,Integer> entry: adj[v].entrySet()) {
                sb.append(String.format("(%d: %d)", entry.getKey(), entry.getValue()));
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        WeightGraph cloned = (WeightGraph) super.clone();
        cloned.adj = new TreeMap[V];
        for (int v = 0; v < V ; v++) {
            cloned.adj[v] = new TreeMap<Integer, Integer>();
            for (Map.Entry<Integer,Integer> entry: adj[v].entrySet()) {
                cloned.adj[v].put(entry.getKey(), entry.getValue());
            }
        }
        return cloned;
    }

    public static void main(String[] args) {
        WeightGraph weightGraph = new WeightGraph("weight-g.txt");
        System.out.println(weightGraph);
    }
}
