package test;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author: wky233
 * @Date: 2020/6/15 13:13
 * @Description: 通过这实验可以发现 K 和 N 的对数之间存在显著的线性相关性：N = 2的k次方
 */
public class PfTest {
    static class BitKeeper {
        // 最大连续0的个数
        private int maxbits;
        public void random() {
            long value =
                    ThreadLocalRandom.current().nextLong(2L << 32);
            int bits = lowZeros(value);
            if (bits > this.maxbits) {
                this.maxbits = bits;
            }
        }
        // 统计末尾连续0的个数
        private int lowZeros(long value) {
            int i = 1;
            for (; i < 32; i++) {
                if (value >> i << i != value) {
                    break;
                }
            }
            return i - 1;
        }
    }
    static class Experiment {
        private int n;
        private BitKeeper keeper;
        public Experiment(int n) {
            this.n = n;
            this.keeper = new BitKeeper();
        }
        public void work() {
            for (int i = 0; i < n; i++) {
                this.keeper.random();
            }
        }
        public void debug() {
            System.out.printf("%d %.2f %d\n", this.n,
                    Math.log(this.n) / Math.log(2),
                    this.keeper.maxbits);
        }
    }
    public static void main(String[] args) {

            Experiment exp = new Experiment(10);
            exp.work();
            exp.debug();
    }
}
