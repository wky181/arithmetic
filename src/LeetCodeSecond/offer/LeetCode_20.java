package LeetCodeSecond.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wky233
 * @Date: 2020/6/18 17:11
 * @Description:
 */
public class LeetCode_20 {
    public boolean isNumber(String s) {
        Map[] states = {
                //0 开始的空格
              new HashMap(){{put(' ', 0);put('s',1);put('d',2);put('.', 4);}},
                //1 幂符号前的正负号
                new HashMap(){{put('d',2);put('.',4);}},
                //2 小数点前的数字 符合条件
                new HashMap(){{put('d',2);put('.',3);put('e',5);put(' ',8);}},
                //3 小数点、小数点后的数字 符合条件
                new HashMap(){{put('d',3);put('e',5);put(' ',8);}},
                //4当小数点前为空格时，小数点、小数点后的数字
                new HashMap(){{put('d',3);}},
                //5 幂符号
                new HashMap(){{put('s',6);put('d',7);}},
                //6 幂符号后的正负号
                new HashMap() {{ put('d', 7); }},
                //7 幂符号后的数字 符合条件
                new HashMap() {{ put('d', 7); put(' ', 8); }},                           // 7.
                //8 结尾的空格  符合条件
                new HashMap() {{ put(' ', 8); }}
        };
        int p = 0;
        char t;
        for (char c : s.toCharArray()){
            if (c >= '0' && c <= '9'){
                t = 'd';
            }
            else if (c == '+' || c == '-'){
                t = 's';
            }else {
                t = c;
            }
            if (!states[p].containsKey(t)){
                return false;
            }
            p = (int)states[p].get(t);
        }
        return  p == 2 || p == 3 || p == 7 || p == 8;
    }
}
