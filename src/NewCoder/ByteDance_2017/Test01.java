package NewCoder.ByteDance_2017;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author 武凯焱
 * @date 2019/10/21 10:47
 * @Description:
 */
public class Test01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int n = input.nextInt();
            String[] str = new String[n];
            Element[] elements = new Element[10];
            for (int i = 0; i < 10; i++) {
                elements[i] = new Element();
            }
            for (int i = 0; i < n; i++) {
                str[i] = input.next();
                long base = 1;
                for (int j = str[i].length() - 1; j >= 0; j--, base *= 10) {
                    Element element = elements[str[i].charAt(j) - 'A'];
                    //标记字符串的首个字符
                    if (j == 0) {
                        element.flag = 1;
                    }
                    element.w += base;
                }
            }
            // 自定义按照权值排序
            Arrays.sort(elements, new Comparator<Element>() {
                @Override
                public int compare(Element o1, Element o2) {
                    return o1.w > o2.w ? 1 : (o1.w == o2.w ? 0 : -1);
                }
            });
            long longs = 0;
            //如果最小权值的字符是前导0 ，需要向前面找则向左边寻找可以为0且权重相对小的字符
            if (elements[0].flag == 1) {
                int i = 0;
                for (; i < 10; i++) {
                    if (elements[i].flag == 0) {
                        break;
                    }
                }
                Element temp = elements[i];
                for (; i > 0; i--) {
                    elements[i] = elements[i-1];
                }
                elements [0] = temp;
            }
            for (int i = 0  ; i <elements.length ; i++) {
                longs +=i*elements [i].w;
            }
            System.out.println(longs);
        }
    }
/**
 * 记录字符的权重和标识符的类，flag=0，表示该字符可以为0，反之，说明该字符不能为0.
 */

    static class Element {
        long w;
        int flag;
    }
}
