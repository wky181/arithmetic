package data_structure.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/7/6 22:32
 * @Description:
 */
public class AdjList {
    // 定点个数
    private int V;
    // 边条数
    private int E;
    private LinkedList<Integer>[] adj;

    public AdjList(String filename) {
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
            adj = new LinkedList[V];
            for (int i = 0; i < V ; i++) {
                adj[i] = new LinkedList<>();
            }
            for (int i = 0; i < E ; i++) {
                int a = scanner.nextInt();
                validateVertex(a);
                int b = scanner.nextInt();
                validateVertex(b);
                if (adj[a].contains(b)){
                    throw  new IllegalArgumentException();
                }
                adj[a].add(b);
                adj[b].add(a);
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
        return adj[v].contains(w);
    }
    public LinkedList<Integer> adj(int v){
        validateVertex(v);
        return adj[v];
    }

    public int degree(int v){
        return adj(v).size();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("V = %d, E = %d", V, E));
        sb.append('\n');
        for (int v = 0; v < V ; v++) {
            sb.append(String.format("%d: ",v));
            for (int w: adj[v]) {
                sb.append(String.format("%d ", w));
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AdjList adjList= new AdjList("g.txt");
        System.out.println(adjList.toString());
    }
}
