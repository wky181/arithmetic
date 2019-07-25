package 真题;

import java.util.*;

/**
 * @author 武凯焱
 * @date 2019/3/18 16:14
 * @Description:
 */
public class 日志统计 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int k = in.nextInt();
//        通过id对获赞时间分类
        Map<Integer, String> map = new HashMap<Integer, String>();
        for(int i=0; i<n; i++) {
            int ts = in.nextInt();
            int id = in.nextInt();
            String temp = map.get(id);
            if (temp==null || temp.equals(""))
            map.put(id,","+ts);
            else{
                map.put(id,","+ts+temp);
            }
        }
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            Integer id = (Integer) iterator.next();
            String[] s = map.get(id).split(",");
            int[] new_s = new int[s.length-1];
            for (int i = 0; i <new_s.length ; i++) {
                new_s[i] = Integer.parseInt(s[i+1]);
            }
            List<Integer> host = new ArrayList<Integer>(); //存放热帖id
            // 对时间排序
            Arrays.sort(new_s);
            // 进行判断 ，i和j 控制热帖的获赞数
            for (int i = k-1, j=0;i < new_s.length  ; i++,j++) {
                if (new_s[i]-new_s[j]<d && !host.contains(id)) {
                    host.add(id);
                    System.out.println(id);
                }
            }

        }
        in.close();
    }
}
