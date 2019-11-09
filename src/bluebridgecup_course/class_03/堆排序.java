package bluebridgecup_course.class_03;

/**
 * @author 武凯焱
 * @date 2019/2/20 20:51
 * @Description:
 */
public class 堆排序 {
    public static void main(String[] args) {
        int[] arr  = {96, 94, 87, 83, 70, 77, 77, 70, 50, 19, 12, 57, 19, 19, 34, 18, 42, 35, 7, 36};
        sort1(arr);
        Util.print(arr);
    }
    // 使乱序数组变为小顶堆
    static void minHeap(int[] arr){
        int n = (arr.length/2)-1;
        for (int i = n; i >=0 ; i--) {
            minHeapFixDown(arr,i,arr.length);
        }
    }
    static void minHeapFixDown(int[] arr,int i,int n){
        int left = 2*i+1;
        int right = 2*i+2;
        int min = left;
        //左节点越界  說明是叶子节点
        if (left>=n){
            return;
        }
        //右节点越界  左节点还在 先令左节点为最小
        if (right>=n){
            min = left;
        }else {
            if (arr[left]<=arr[right]){
                min = left;
            }else {
                min = right;
            }
        }
        //此時min指向了左右孩子中最小的那個
        if (arr[i]<= arr[min]){
            return;
        }else {
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
            //小孩子那个位置的数值发生变换，递归调整
            minHeapFixDown(arr,min,n);
        }

    }
    //使用小顶堆 排倒序
    static void  sort(int[] arr) {
        minHeap(arr);
        int n = arr.length;
        for (int i = 1; i <  n ; i++) {
            Util.swap(arr,0,n-i);
            minHeapFixDown(arr,0,n-i);
        }
    }
    //使乱序数组变为大顶堆
    static void maxHeap(int[] arr){
        int n = arr.length/2;
        for (int i = n; i >=0 ; i--) {
            maxHeapFixDown(arr,i,arr.length);
        }
    }
    static void maxHeapFixDown(int[] arr,int i,int n){
        int left = 2*i+1;
        int right = 2*i+2;
        //说明i位置是叶子节点
        if (left>=n){
            return;
        }
        int max = left;
        //右节点越界  左节点还在 先令左节点为最大，然后与根节点相比
        if (right>=n){
            max = left;
        }else {
            if (arr[left]>=arr[right]){
                max = left;
            }else{
                max = right;
            }
        }
        //此時max指向了左右孩子中最最大的那個
        if (arr[max]<=arr[i]){
            return;
        }else {
            Util.swap(arr,i,max);
            //大孩子那个位置的数值发生变换，递归调整
            maxHeapFixDown(arr,max,n);
        }
    }
    //使用大顶堆排正序
    static void sort1(int[] arr){
        maxHeap(arr);
        Util.print(arr);
        int n = arr.length;
        for (int i = 1; i <  n ; i++) {
            Util.swap(arr,0,n-i);
            maxHeapFixDown(arr,0,n-i);
        }
    }
    //将乱序数组变为小顶堆
    public static void minHeapDown(int arr[],int i,int n){
            int left = 2*i+1;
            int right = 2*i+2;
            if (left>=n){
                return;
            }
            int min = left;
            if (right>=n){
                min = left;
            }else {
                if (arr[left]<=arr[right]){
                    min = left;
                }else {
                    min = right;
                }
            }
            if (arr[i]>=arr[min]){
                Util.swap(arr,i,min);
                minHeapDown(arr,min,n);
            }else {
                return;
            }
      /*  int left = 2*i+1;
        int right = 2*i+2;
        int min = left;
        //左节点越界  說明是叶子节点
        if (left>=n){
            return;
        }
        //右节点越界  左节点还在 先令左节点为最小
        if (right>=n){
            min = left;
        }else {
            if (arr[left]<=arr[right]){
                min = left;
            }else {
                min = right;
            }
        }
        //此時min指向了左右孩子中最小的那個
        if (arr[i]<= arr[min]){
            return;
        }else {
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
            //小孩子那个位置的数值发生变换，递归调整
            minHeapFixDown(arr,min,n);
        }*/


    }
    //minheap
    public static void minHeapl(int[] arr){
        int n = (arr.length/2)-1;
        for (int i = n; i >=0; i--) {
            minHeapDown(arr,i,arr.length);
        }
    }
    public static void sortl(int[] arr){
        minHeapl(arr);
        int n = arr.length;
        for (int i = 1; i <arr.length ; i++) {
                Util.swap(arr,0,n-i);
                minHeapDown(arr,0,n-i);
        }

    }
}
