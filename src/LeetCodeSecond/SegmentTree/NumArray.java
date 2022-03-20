
package LeetCodeSecond.SegmentTree;
/**
 * @Author: wky233
 * @Date: 2020/6/13 22:09
 * @Description:
 */

public class NumArray {
    SegmentTree segmentTree ;
    public NumArray(int[] nums) {
        if (nums != null && nums.length != 0) {
            segmentTree = new SegmentTree(nums);
        }
    }

    public int sumRange(int i, int j) {
        return segmentTree == null ? 0 : segmentTree.query(i,j);
    }

    public void update(int i, int val) {
        segmentTree.update(i,val);
    }
    private class SegmentTree{
        private int[] tree;
        private int[] data;

        public SegmentTree(int[] nums) {
            tree = new int[nums.length * 4];
            data = new int[nums.length];
            for (int i = 0; i < nums.length ; i++) {
                data[i]  = nums[i];
            }
            bulidSegmentTree(0,0,data.length-1);
        }
        private void bulidSegmentTree(int treeIndex, int left, int right){
            if (left == right){
                tree[treeIndex] = data[left];
                return;
            }
            int mid = left + (right - left) / 2;
            bulidSegmentTree(leftChild(treeIndex),left,mid);
            bulidSegmentTree(rightChild(treeIndex),mid+1, right);
            tree[treeIndex] = tree[leftChild(treeIndex)] + tree[rightChild(treeIndex)];
        }
        private int leftChild(int treeIndex){
            return treeIndex * 2 + 1;
        }

        private int rightChild(int treeIndex){
            return treeIndex * 2 + 2;
        }

        public void update(int index, int target){
            if (index < 0 || index >= data.length){
                return;
            }
            set(0,0,data.length-1,index,target);

        }
        private void set(int treeIndex, int left, int right, int index, int target){
            if (left == right){
                tree[treeIndex] = target;
                return;
            }
            int mid = left + (right - left) / 2;
            int leftIndex = leftChild(treeIndex);
            int rightIndex = rightChild(treeIndex);
            if (index <= mid){
                set(leftIndex,left,mid,index,target);
            }else {
                set(rightIndex,mid+1,right,index,target);
            }
            tree[treeIndex] = tree[leftIndex] + tree[rightIndex];
        }

        public int query(int queryL, int queryR){

           if (queryL < 0 || queryL > queryR || queryR >= data.length){
               return 0;
           }
           return query(0,0,data.length-1,queryL,queryR);
        }
        private int query(int treeIndex,int left, int right,int queryL, int queryR){
            if (queryL == left && queryR == right){
                return tree[treeIndex];
            }
            int mid = left + (right - left) / 2;
            if (queryL >= mid + 1){
                return query(rightChild(treeIndex),mid+1,right, queryL,queryR);
            }
            else if (queryR <= mid){
                return query(leftChild(treeIndex), left,mid,queryL,queryR);
            }
            else {
                int leftNum = query(leftChild(treeIndex),left,mid,queryL,mid);
                int rightNum = query(rightChild(treeIndex),mid+1,right,mid+1,queryR);
                return  leftNum + rightNum;
            }
        }
    }
}
