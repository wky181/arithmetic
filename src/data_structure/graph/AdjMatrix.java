package data_structure.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/7/6 19:32
 * @Description:
 */
public class AdjMatrix {
    // 定点个数
    private int V;
    // 边条数
    private int E;
    private int[][] adj;

    public AdjMatrix(String filename) {
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
            adj = new int[V][V];
            for (int i = 0; i < E ; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
               // System.out.println(a + " " + b);
                if (a == b || adj[a][b] == 1){
                    throw new IllegalArgumentException("Illegal");
                }
                adj[a][b] = 1;
                adj[b][a] = 1;

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
            return adj[v][w] == 1;
    }
    public ArrayList<Integer> adj(int v){
        validateVertex(v);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < V ; i++) {
            if (adj[v][i] == 1){
                res.add(i);
            }
        }
        return res;
    }

    public int degree(int v){
        return adj(v).size();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("V = %d, E = %d", V, E));
        sb.append('\n');
        for (int i = 0; i < V ; i++) {
            for (int j = 0; j < V; j++) {
                 sb.append(String.format("%d ", adj[i][j]));

            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AdjMatrix adjMatrix = new AdjMatrix("g.txt");
        System.out.println(adjMatrix.toString());
    }
}
