package class_03;

/**
 * @author 武凯焱
 * @date 2019/2/21 21:35
 * @Description:
 */
public class 需要排序的子数组 {
    public static void main(String[] args) {
       // int[] arr = {29, 78, 100, 28, 5, 61, 46, 30, 69, 13};
        int[] arr = Util.getRandomArr(10,1,100);
        Util.print(arr);
        int[] rs = findSegment(arr);
        Util.print(rs);
    }
    public static int[] findSegment(int[] arr) {
        int p1 = -1;
        int max = arr[0];
        int min = arr[arr.length-1];
        int p2 = -1;
        //找到右边界
        for (int i = 0; i <arr.length ; i++) {
                if (arr[i]>max){
                    max = arr[i];
            }
            if (arr[i]<max){
                p2 = i;
            }
        }
        for (int i = arr.length-1; i >=0 ; i--) {
            if (arr[i]<min){
                min = arr[i];
            }
            if (arr[i]>min){
                p1 = i;
            }
        }
        if (p1==-1){
            return new int[2];
        }
        int[] temp = {p1,p2};
        return temp;
    }
}
