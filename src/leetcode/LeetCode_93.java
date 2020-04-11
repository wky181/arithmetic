package leetcode;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/4/3 12:28
 * @Description:
 */
public class LeetCode_93 {
    public static void main(String[] args) {

    }
    List<String> res;
    public List<String> restoreIpAddresses(String s) {
        return null;
    }
    public void backtrace(String str , int splitCount, int index, ArrayQueue<String> queue){
        if (splitCount == 0){
            res.add(String.join(".",queue));
            return;
        }
        for (int i = index; i < index+3 ; i++) {
            if (i >= str.length()){
                break;
            }

        }
    }
}
