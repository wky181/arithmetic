package Interview.mogujie;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/4/20 13:36
 * @Description:
 */
public class Demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Work[] works = new Work[N];
        int[] workers = new int[M];
        for(int i = 0; i < N; i++ ){
            works[i] = new Work();
            works[i].hardLevle = sc.nextInt();
            works[i].money = sc.nextInt();
        }
        for(int i = 0; i < M; i++){
            workers[i] = sc.nextInt();
        }
        Arrays.sort(works,(o1, o2) -> o1.hardLevle - o2.hardLevle);
        int max = -1;
        for(Work work : works){
            if(work.money < max){
                work.money = max;
            }else{
                max =  work.money;
            }
        }
        for(int num : workers ){
            System.out.println(find(works, num));
        }

    }
    static int find(Work[] works, int target ){
        int l = 0;
        int r = works.length-1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(works[mid].hardLevle == target){
                return works[mid].money;
            }else if(works[mid].hardLevle > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return  target > works[0].hardLevle ? works[r].money : 0;
    }
    static class Work{
        int hardLevle;
        int money;
    }

}
