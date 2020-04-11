package leetcode;

import java.util.Stack;

/**
 * @Author: wky233
 * @Date: 2020/2/18 12:59
 * @Description:
 */
public class LeetCode_71 {
    public static void main(String[] args) {
      String res = new LeetCode_71().simplifyPath1("/../");
        System.out.println(res);

    }
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < path.length(); i++) {
            char ch = path.charAt(i);
            switch (ch) {
                case '/':
                    if (stringBuilder.length() != 0) {
                        stack.push(stringBuilder.toString());
                        stringBuilder = new StringBuilder();
                    }
                    break;
                case '.':
                    int length = 1;
                    int index = i;
                    //判断该点是不是要退到上一级目录
                    while (i + 1 < path.length() && path.charAt(i+1) == '.') {
                        i++;
                        length++;
                    }
                    if (length == 2 && !stack.isEmpty()){
                        stack.pop();
                    }else if (length >=3){
                        stack.push(path.substring(index,i+1));
                    }
                    break;
                default:
                    stringBuilder.append(ch);
            }
        }
        if (stringBuilder.length() != 0){
            stack.push(stringBuilder.toString());
        }
        StringBuilder string = new StringBuilder();
        int mark = stack.size();
        while (!stack.isEmpty()) {
            string.insert(0, "/" + stack.pop());
        }
        return mark == 0 ? "/" : string.toString();
    }
    public String simplifyPath1(String path) {
        Stack<String> stack = new Stack<>();
        String[] strs = path.split("/");
        for (int i = 0; i < strs.length ; i++) {
            String str = strs[i];
           if ("".equals(str) || ".".equals(str)){
               continue;
           }else if ("..".equals(str) ){
               if (!stack.isEmpty()) {
                   stack.pop();
               }
           }else {
               stack.push(str);
           }
        }
        StringBuilder string = new StringBuilder();
        int mark = stack.size();
        for (int i = 0; i < stack.size(); i++) {
            string.append("/").append(stack.get(i));
        }
        return mark == 0 ? "/" : string.toString();
    }
}
