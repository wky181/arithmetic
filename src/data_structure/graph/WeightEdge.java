package data_structure.graph;

/**
 * @Author: wky233
 * @Date: 2020/7/9 22:07
 * @Description:
 */
public class WeightEdge implements Comparable<WeightEdge>{

    private int v, w, weight;

    public WeightEdge(int v, int w, int weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }



    public int getV() {
        return v;
    }

    public int getW() {
        return w;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(WeightEdge another) {
        return this.weight - another.weight;
    }

    @Override
    public String toString() {
        return String.format("(%d-%d: %d)", v, w,weight);
    }
}
