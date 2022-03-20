package LeetCodeSecond.unionfind;


import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author: wky233
 * @Date: 2020/6/6 22:40
 * @Description:
 */
public class LeetCode_128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length ; i++) {
            set.add(nums[i]);
        }
        int result = 0;
        for (int i = 0; i < nums.length ; i++) {
            int cnt = 0;
            int left = nums[i];
            int right = nums[i] + 1;
            while (set.contains(left)){
                cnt++;
                set.remove(left);
                left--;
            }
            while (set.contains(right)){
                cnt++;
                set.remove(right);
                right++;
            }
            result = Math.max(result, cnt);
        }
            return result;
    }

    public int longestConsecutive1(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        UF uf = new UF(nums);
        for (int i = 0; i < nums.length ; i++) {
            uf.unionElements(nums[i],nums[i] + 1);
        }
        return uf.maxSize;
    }
    private class UF{
        HashSet<Integer> set = new HashSet<>();
        private HashMap<Integer,Integer> parent = new HashMap<>();
        private HashMap<Integer,Integer> size = new HashMap<>();
        private int maxSize = 1;
        // 初始化
        public UF(int[] nums) {
            for (int i = 0; i < nums.length ; i++) {
                parent.put(nums[i],nums[i]);
                size.put(nums[i],1);
                set.add(nums[i]);
            }
        }
        // 查找元素所在集合
        private int find(int num){
            while (num != parent.get(num)){
                // 压缩路径
                int p  = parent.get(parent.get(num));
                parent.put(num, p);
                num = p;
            }
            return num;
        }
        // unionElements 合并元素
        public void unionElements(int p, int q){
            if (!set.contains(p) || !set.contains(q)){
                return;
            }
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot){
                return;
            }
            int pSize = size.get(pRoot);
            int qSize = size.get(qRoot);
            if (pSize > qSize){
                parent.put(qRoot,pRoot);
                size.put(pRoot, pSize + qSize);
            }
            else {
                parent.put(pRoot,qRoot);
                size.put(qRoot, pSize + qSize);
            }
            maxSize = Math.max(maxSize,pSize + qSize);
        }
    }

}
