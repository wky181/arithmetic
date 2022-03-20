package LeetCodeSecond.unionfind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/6/8 22:48
 * @Description:
 */
public class LeetCode_990 {
    public boolean equationsPossible(String[] equations) {
      /*  List<String> notEquals = new ArrayList<>();
        UF uf = new UF();
        for (int i = 0; i < equations.length ; i++) {
            String s = equations[i];
            if (s.charAt(1) == '!'){
                notEquals.add(s);
                continue;
            }
            uf.unionElements(s.charAt(0), s.charAt(3));
        }
        for (String str: notEquals) {
            if (uf.isContneect(str.charAt(0), str.charAt(3))){
                return false;
            }
        }
        return true;*/
        List<String> notEquals = new ArrayList<>();
        UF1 uf = new UF1();
        for (int i = 0; i < equations.length ; i++) {
            String s = equations[i];
            if (s.charAt(1) == '!'){
                notEquals.add(s);
                continue;
            }
            uf.unionElements(s.charAt(0) - 'a', s.charAt(3) - 'a');
        }
        for (String str: notEquals) {
            if (uf.isContneect(str.charAt(0) - 'a', str.charAt(3) - 'a')){
                return false;
            }
        }
        return true;
    }
    // 使用hashMap实现的比较慢
    private class UF{
        public UF() {
            parent = new HashMap<>(26);
            size = new HashMap<>(26);
            for (char i = 'a'; i <= 'z' ; i++) {
                parent.put(i,i);
                size.put(i,1);
            }
        }

        HashMap<Character, Character> parent;
       // private int count;
        HashMap<Character, Integer> size;

        public Character find(Character p){
            if (!p.equals(parent.get(p))){
                // 压缩路径
                Character parentPro = parent.get(parent.get(p));
                parent.put(p,parentPro);
                p = parentPro;
            }
            return p;
        }
        public boolean isContneect(Character p, Character q){
            return find(p).equals(find(q));
        }
        public void unionElements(Character p, Character q){
            Character pRoot = find(p);
            Character qRoot = find(q);
            if (pRoot.equals(qRoot)){
                return;
            }

            else if (size.get(pRoot) > size.get(qRoot)){
                int sum = size.get(pRoot) + size.get(qRoot);
                size.put(pRoot,sum);
                parent.put(qRoot,pRoot);
            }else {
                int sum = size.get(pRoot) + size.get(qRoot);
                size.put(qRoot,sum);
                parent.put(pRoot,qRoot);
            }
        }
    }
    private class UF1{
        public UF1() {
            parent = new int[26];
            size = new int[26];
            for (char i = 0; i < parent.length ; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int[] parent;
        // private int count;
        int[] size;

        public int find(int p){
            if (p != parent[p]){
                // 压缩路径
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        public boolean isContneect(int p, int q){
            return find(p) == find(q);
        }
        public void unionElements(int p, int q){
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot){
                return;
            }
            else if (size[pRoot] > size[qRoot]){
                int sum = size[pRoot] + size[qRoot];
                size[pRoot] = sum;
                parent[qRoot] = pRoot;
            }else {
                int sum = size[pRoot] + size[qRoot];
                size[qRoot] = sum;
                parent[pRoot] = qRoot;
            }
        }
    }
}
