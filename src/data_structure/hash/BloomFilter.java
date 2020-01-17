package data_structure.hash;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author 武凯焱
 * @date 2019/12/2 14:48
 * @Description: 简化版布隆过滤器
 */
public class BloomFilter {
    /**
     *  位图长度
     */
    public static final int NUM_SLOTS = 1024*1024*8;
    /**
     * 哈希函数的个数，一个哈希函数的结果用于标记一个位
      */
    public static final int NUM_HASH = 8;

    private BigInteger bitmap = new BigInteger("0");

    public static void main(String[] args) {
        BloomFilter bloomFilter = new BloomFilter();
        bloomFilter.addElement("java");
        bloomFilter.addElement("javaa");
        bloomFilter.addElement("javab");
        bloomFilter.addElement("javac");
        bloomFilter.addElement("javad");
        bloomFilter.addElement("javae");
        System.out.println(bloomFilter.check("java0"));
    }
    public  int hash(String message ,int code){
        message = message+String.valueOf(code);
        try {
            //将任意输入映射成128位(16个字节)的一个整数（范围是2的128次方）的hash函数
            MessageDigest md5 = MessageDigest.getInstance("md5");
            byte[] bytes = message.getBytes();
            //将目的消息输入md5
            md5.update(bytes);
            byte[] digest = md5.digest();
            BigInteger bigInteger = new BigInteger(digest);
            //取余让结果不大于位图大小
            return Math.abs(bigInteger.intValue())%NUM_SLOTS;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public boolean check(String message){
        for (int i = 0; i < NUM_HASH; i++) {
            int hashcode = hash(message, i);
            if (!bitmap.testBit(hashcode)) {
                return false;
            }
        }
        return true;
    }
    public void addElement(String message){
        for (int i = 0; i < NUM_HASH; i++) {
            int hashcode = hash(message, i);
            if (!bitmap.testBit(hashcode)) {
                // 将位图该hash的位置 置1
               bitmap = bitmap.or(new BigInteger("1").shiftLeft(hashcode));
            }
        }
    }
}