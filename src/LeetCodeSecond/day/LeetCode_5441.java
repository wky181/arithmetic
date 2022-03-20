package LeetCodeSecond.day;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author: wky233
 * @Date: 2020/6/21 10:39
 * @Description:
 */
public class LeetCode_5441 {
    public String[] getFolderNames(String[] names) {
        HashMap<String, Integer> nameCount = new HashMap<>();

        for (int i = 0; i < names.length ; i++) {
            String string = names[i];
            if (!nameCount.containsKey(names[i])){
                nameCount.put(string,1);
            }else {
                int count  = nameCount.get(string);
                string =  names[i] + "(" + count + ")";
                while (nameCount.containsKey(string)){
                    string = names[i] + "(" + ++count + ")";
                }
                nameCount.put(names[i],count+1);
                nameCount.put(string,1);
                names[i] = string;
            }
        }
        return names;
    }
}
