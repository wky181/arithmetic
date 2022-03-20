package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/4/12 11:10
 * @Description:
 */
public class LeetCode_5382 {
    public static void main(String[] args) {
        String s = new LeetCode_5382().entityParser("and I quote: &quot;...&quot;");
        System.out.println(s);
    }
    public String entityParser(String text) {
        String res = "";
        res = text.replaceAll("&quot;","\"");
        res = res.replaceAll("&apos;","'");
        res = res.replaceAll("&amp;","&");
        res = res.replaceAll("&gt;",">");
        res = res.replaceAll("&lt;","<");
        res = res.replaceAll("&frasl;","/");
        return res;

    }
}
