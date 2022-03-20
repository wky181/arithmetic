package LeetCodeSecond.unionfind;

/**
 * @Author: wky233
 * @Date: 2020/6/6 23:59
 * @Description: quick find
 */
public class UFDemo implements UF {
    private int[] ids;

    public UFDemo(int size) {
        ids = new int[size];
        for (int i = 0; i < size; i++) {
            ids[i] = i;
        }
    }

    @Override
    public int getSize() {
        return ids.length;
    }

    @Override
    // 判断元素p和元素q是否在一个集合中
    public boolean isConnected(int p, int q) {
        return find(p)  == find(q);
    }
    // 查询元素p所对应的集合编号
    public int find(int p){
        if (p < 0 || p >= ids.length){
            throw new IllegalArgumentException();
        }
        return ids[p];
    }
    @Override
    // 将元素p所在集合和元素q所在集合合并到一个集合中
    public void unionElements(int p, int q) {
        int idP = find(p);
        int idQ = find(q);
        if (idP != idQ){
            for (int i = 0; i < ids.length ; i++) {
                if (ids[i] == idQ){
                    ids[i] = idP;
                }
            }
        }
    }
}
