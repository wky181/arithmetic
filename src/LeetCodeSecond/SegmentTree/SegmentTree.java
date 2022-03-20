package LeetCodeSecond.SegmentTree;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/6/13 16:44
 * @Description:
 */
public class SegmentTree<E> {
    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[4 * arr.length];
        this.merger = merger;
        buildSegmentTree(0,0,data.length-1);
    }

    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r){
            tree[treeIndex] = data[l];
            return;
        }
        int lefTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        int mid = l + (r - l) / 2;
        buildSegmentTree(lefTreeIndex,l,mid);
        buildSegmentTree(rightTreeIndex,mid+1,r);
        tree[treeIndex] = merger.merge(tree[lefTreeIndex],tree[rightTreeIndex]);
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index){
        if (index < 0 || index >= data.length){
            throw new IllegalArgumentException("index is  Illegal ");
        }
        return data[index];
    }

    public int leftChild(int index){
        return 2*index + 1;
    }

    public int rightChild(int index){
        return 2*index + 2;
    }

    public E query(int queryL, int queryR){
        if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length){
            throw new IllegalArgumentException("Index is illegal");

        }
        return query(0,0,data.length-1,queryL,queryR);
    }
    //
    public E query(int treeIndex,int left, int right,int queryL, int queryR){
        if (left == queryL && right == queryR ){
            return tree[treeIndex];
        }
        int mid = left + (right - left) / 2;
        if (queryL >= mid + 1){
            return query(rightChild(treeIndex),mid+1,right,queryL,queryR);
        }
        else if (queryR <= mid){
            return query(leftChild(treeIndex),left,mid,queryL,queryR);
        }
        else {
            E leftResult = query(leftChild(treeIndex),left,mid,queryL,mid);
            E rightResult = query(rightChild(treeIndex),mid+1,right,mid+1,queryR);
            return merger.merge(leftResult,rightResult);
        }
    }

    public void update(int index, E target){
        if (index < 0 || index >= data.length){
            return;
        }
        set(0,0,data.length-1,index,target);

    }
    private void set(int treeIndex, int left, int right, int index, E target){
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
        tree[treeIndex] = merger.merge(tree[leftIndex],tree[rightIndex]);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < tree.length ; i++) {
            if (tree[i] != null){
                res.append(tree[i]);
            }
            else {
                res.append("null");
            }
            if (i != tree.length-1){
                res.append(",");
            }
        }
        return res.toString();
    }
}
