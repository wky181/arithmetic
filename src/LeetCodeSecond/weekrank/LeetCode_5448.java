package LeetCodeSecond.weekrank;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: wky233
 * @Date: 2020/6/28 10:31
 * @Description:
 */
public class LeetCode_5448 {
    public static void main(String[] args) {
        new LeetCode_5448().isPathCrossing("NNSWWEWSSESSWENNW");
    }
    public boolean isPathCrossing(String path) {
        char[] array = path.toCharArray();
        int x = 0;
        int y = 0;
        Set<String> strings = new HashSet<>();
        strings.add(x + "" +y);
        for (char c : array) {
            if (c == 'N') {
                x++;
            } else if (c == 'S') {
                x--;
            } else if (c == 'E') {
                y++;
            } else {
                y--;
            }
            String str = x + "" + y;
            if (strings.contains(str)){
                return true;
            }else {
                strings.add(str);
            }
        }
        return false;

    }
}
