package bluebridgecup_course.class_04;

/**
 * @author 武凯焱
 * @date 2019/2/25 15:08
 * @Description:
 */
public class 子数组最大累加和 {
    public static void main(String[] args) {
        int[] arr = {1,-2,3,5,-2,6,-1};
        System.out.println(solve(arr));
        System.out.println(solve1(arr));
    }

    //暴力破解 n平方复杂度
    public static int solve(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            int n = sum;
            for (int j = i + 1; j < arr.length; j++) {
                sum += arr[j];
                if (sum>n){
                    n = sum;
                }
            }
            if(n>max){
                max = n;
            }
        }
        return  max;
    }
    // 累加为负数 直接舍弃 令下一个元素为sum
    public static int solve1(int[] arr) {
        int sum = arr[0];
        int max = arr[0];
        int left = 0;
        int right = 0;
        for (int i = 1; i <arr.length ; i++) {
            if (sum>0){
                sum+=arr[i];
            }else {
                sum = arr[i];
                left = i;
            }
            if (sum>max){
                right = i;
                max = sum;
            }
        }
        System.out.println(left +"~~~~~~~" + right);
        return max;
    }
}
