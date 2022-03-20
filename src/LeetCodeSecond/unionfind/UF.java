package LeetCodeSecond.unionfind;

/**
 * @Author: wky233
 * @Date: 2020/6/6 23:44
 * @Description:
 */
public interface UF {
    int getSize();
    boolean isConnected(int p, int q);
    void unionElements(int p, int q);
}
