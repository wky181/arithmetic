package bluebridgecup_course.class_03;

/**
 * @author 武凯焱
 * @date 2019/2/20 9:30
 * @Description:
 */
public class 合并两个有序数组 {
    public static void main(String[] args) {
        int[] arr = {10,11,12,13,14,15};
        int[] arrB = {11,16,19};
        int[] arrA = new int[9];
        for (int i = 0; i <arr.length ; i++) {
            arrA[i] = arr[i] ;
        }
        merage(arrA,arrB);
        Util.print(arrA);
    }
    public static void merage(int[] arrA , int[] arrB ){
        int corrunt = arrA.length-1;
        int a = (arrA.length-arrB.length)-1;
        int b = arrB.length-1;
        while (a>=0 && b>=0){
            if (arrA[a]<=arrB[b]){
                arrA[corrunt--] = arrB[b--];
            }else {
                arrA[corrunt--] = arrA[a--];
            }
        }
        if (b!=0){
            while (b>=0){
                arrA[corrunt--] = arrB[b--];
            }
        }
    }
}
