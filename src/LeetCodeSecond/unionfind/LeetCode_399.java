package LeetCodeSecond.unionfind;

import org.hamcrest.Condition;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/7/11 9:45
 * @Description:
 */
public class LeetCode_399 {
    private HashMap<String, String> parent;
    private HashMap<String,Double> weight;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        parent = new HashMap<>();
        weight = new HashMap<>();
        // 加入边和权值
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation =  equations.get(i);
            String p = equation.get(0);
            String q = equation.get(1);
            unionElements(p,q,values[i]);
        }
        double[] res = new double[queries.size()];
        int index = 0;
        for (int i = 0; i < queries.size(); i++) {
            List<String> querie =  equations.get(i);
            String pRoot = find(querie.get(0));
            String qRoot = find(querie.get(1));

            if (!parent.containsKey(querie.get(0)) || !parent.containsKey(querie.get(1)) || !pRoot.equals(qRoot)){
                res[index++] = -1;
            }else {
                res[index++] = weight.get(querie.get(0)) / weight.get(querie.get(1));
            }
        }
        return res;
    }
    public void init(String s){
        // 如果节点不存在，那么权重默认是1
        if (!parent.containsKey(s)){
            parent.put(s,s);
            weight.put(s,1d);
        }
    }
    private String find(String s){
        if (!parent.containsKey(s)){
            return null;
        }else {
            // 压缩路径
            if (!s.equals(parent.get(s))){
                String f = parent.get(s);
                parent.put(s, find(f));
                weight.put(s,weight.get(s) * weight.get(f));
            }
        }
        return parent.get(s);
    }
    private void unionElements(String p, String q, Double value){
        init(p);init(q);
        String pRoot = find(p);
        String qRoot = find(q);
        if (pRoot.equals(qRoot)){
            return;
        }
        parent.put(pRoot,qRoot);
        // 更新现在pRoot/qRoot的权重
        weight.put(pRoot,value * weight.get(p)/ weight.get(q));
    }
    // 计算当前节点到根节点的乘积
    private double cal(String num) {
        double res = weight.get(num);
        while (num.equals(parent.get(num))){
            num = parent.get(num);
            res *= weight.get(num);
        }
        return res;
    }
}
