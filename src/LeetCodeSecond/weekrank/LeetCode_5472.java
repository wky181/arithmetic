package LeetCodeSecond.weekrank;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/7/26 10:31
 * @Description:
 */
public class LeetCode_5472 {
    public String restoreString(String s, int[] indices) {
        char[] array = s.toCharArray();
        Node[] nodes = new Node[s.length()];
        for (int i = 0; i < nodes.length ; i++) {
            nodes[i] = new Node(array[i],indices[i]);
        }
        Arrays.sort(nodes, ((o1, o2) -> o1.index - o2.index));
        StringBuilder sb = new StringBuilder();
        for (Node node: nodes) {
            sb.append(node.value);
        }
        return sb.toString();
    }
    private class Node{
        char value;
        int index;

        public Node(char value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
