package leetcode;

/**
 * @author 武凯焱
 * @date 2019/7/13 9:50
 * @Description:
 */
/*
345. 反转字符串中的元音字母
        编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
        示例 1:
        输入: "hello"
        输出: "holle"
        示例 2:
        输入: "leetcode"
        输出: "leotcede"
        说明:
        元音字母不包含字母"y"。（a，e，i，o，u）
*/

public class 反转字符串中的元音字母 {
    public static void main(String[] args) {
        String string  =  reverseVowels("lteio");
        System.out.println(string);
    }
    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int length = s.length()-1;
        int left = 0;
        int right  = length;
        while (left<right){
            while (!jundge(chars[left]) && left<right){
                    left++;
            }
            while (!jundge(chars[right]) && left<right){
                right--;
            }
            if (left<right){
                swap(chars,left,right);
                left++;
                right--;
            }
        }
        return new String(chars);
    }
    public static boolean jundge(char a){
        if (a=='a' || a=='e' || a == 'i' || a=='o' || a=='u'){
            return true;
        }else if  (a=='A' || a=='E' || a == 'I' || a=='O' || a=='U'){
            return true;
        }
        return false;
    }
    public static void  swap(char[] strings ,int a,int b){
        char temp = strings[a];
        strings[a] = strings[b];
        strings[b] = temp;
    }

}
