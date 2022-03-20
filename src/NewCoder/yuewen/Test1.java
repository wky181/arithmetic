package NewCoder.yuewen;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/5/19 19:40
 * @Description:
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String sc = in.nextLine();
        String[] split = sc.split(",");
        long ans = 1;
        int[] integers = new int[split.length];
        for (int i = 0; i < split.length ; i++) {
            integers[i] = Integer.parseInt(split[i]);
            ans *= integers[i];
        }
        if (ans != 0) {
            Node[] nodes = new Node[split.length];
            for (int i = 0; i < integers.length; i++) {
                nodes[i] = new Node(ans / integers[i], i);
            }
            Arrays.sort(nodes, (n1, n2) -> (int) (n2.value - n1.value));
            System.out.println(nodes[0].index);
        }

    }
    static class Node{
        long value;
        int index;

        public Node(long value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
