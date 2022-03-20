package Interview.yuanfudao;

import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/8/15 19:38
 * @Description:
 */
public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            WorkflowNode node = WorkflowNode.load(cin.next());
        }

    }
}
