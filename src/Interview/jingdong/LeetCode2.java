package Interview.jingdong;

/**
 * @Author: wky233
 * @Date: 2020/4/18 15:06
 * @Description:
 */
public class LeetCode2 {
    int res;
    public int numWays(int n, int[][] relation, int k) {
        dfs(relation,k,0,n-1);
        return res;
    }
    public void dfs(int[][] relation, int k, int start, int end) {
        if (k == 0 && start == end){
            res++;
        }
        if (k <= 0){
            return;
        }
        for (int i = 0; i < relation.length; i++) {
            if (relation[i][0] == start){
                dfs(relation,k-1,relation[i][1],end);
            }
        }
    }

}
