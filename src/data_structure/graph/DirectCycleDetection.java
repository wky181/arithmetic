package data_structure.graph;

/**
 * @Author: wky233
 * @Date: 2020/7/27 8:59
 * @Description:  有向图环检测
 */
public class DirectCycleDetection {
    private DirectGraph G;
    private boolean[] vistied;
    private boolean[] onPath;
    private boolean hasCycle = false;
    public DirectCycleDetection(DirectGraph g) {
        this.G = g;
        vistied = new boolean[G.getV()];
        onPath = new boolean[G.getV()];
        for (int v = 0; v < G.getV() ; v++) {
            if (!vistied[v]){
                if (dfs(v)){
                    hasCycle = true;
                    break;
                }
            }
        }
    }

    private boolean dfs(int v) {
        vistied[v] = true;
        onPath[v] = true;
        for (int w: G.adj(v)) {
            if (!vistied[w]){
                if (dfs(w)){
                    return true;
                }
            }
            // 本来已经在路径上了，这次又访问到了
            else if (onPath[w]){
                return true;
            }
        }
        onPath[v] = false;
        return false;
    }

    public static void main(String[] args) {
        Graph g = new Graph("ug.txt");
        DirectGraph g2 = new DirectGraph("ug.txt",true);
        CycleDetection detection = new CycleDetection(g);
        DirectCycleDetection directCycleDetection= new DirectCycleDetection(g2);
       // System.out.println(detection.isHasCycle());
        System.out.println(directCycleDetection.hasCycle);
    }
}
