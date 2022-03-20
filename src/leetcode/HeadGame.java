package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/4/18 13:35
 * @Description:
 */
public class HeadGame {
    public static void main(String[] args) {
        int[] piles = {3, 9, 1, 2};
        System.out.println(new HeadGame().stoneGame(piles));
    }

    /* 返回游戏最后先⼿和后⼿的得分之差 */
    public int stoneGame(int[] piles) {
        Pair[][] pairs = new Pair[piles.length][piles.length];
        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < pairs.length; j++) {
                pairs[i][j] = new Pair(0, 0);
            }
        }
        for (int i = 0; i < pairs.length; i++) {
            pairs[i][i].fir = piles[i];
        }
        int len = piles.length;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                int left = piles[i] + pairs[i + 1][j].sec;
                int right = piles[j] + pairs[i][j - 1].sec;
                if (left > right) {
                    pairs[i][j].fir = left;
                    pairs[i][j].sec = pairs[i + 1][j].fir;
                } else {
                    pairs[i][j].fir = right;
                    pairs[i][j].sec = pairs[i][j - 1].fir;
                }
            }
        }
        return pairs[0][len - 1].fir - pairs[0][len - 1].sec;
    }

    class Pair {
        int fir;
        int sec;

        public Pair(int fir, int sec) {
            this.fir = fir;
            this.sec = sec;
        }
    }
}
