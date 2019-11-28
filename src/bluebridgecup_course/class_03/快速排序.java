package bluebridgecup_course.class_03;

/**
 * @author 武凯焱
 * @date 2019/2/16 11:37
 * @Description:
 */
public class 快速排序 {
    public static void main(String[] args) {
        int[] arr = Util.getRandomArr(20,1,100);
        afterQuick(arr,0,arr.length-1);
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void quickSort(int[] arr,int p,int r){
        if (p<r) {
            //待排序小于8时直接使用插入排序
            if (r+1-p<=8){
                什么是递归.insertSort(arr,r);
            }else {
                int q = partition(arr, p, r);
                quickSort(arr, p, q - 1);
                quickSort(arr, q + 1, r);
            }
        }
    }
    //单向扫描法
    public static int partition(int[] arr,int p,int r){
        //优化
        int mid = (p+r)/2;
        int midValueIndex = -1;
        if (arr[p]<=arr[mid] && arr[p]>=arr[r]){
            midValueIndex=p;
        }else if (arr[r]<=arr[mid] && arr[r]>=arr[p]){
            midValueIndex = r;
        }else {
            midValueIndex = mid;
        }
        swap(arr,p,midValueIndex);
        int pivot = arr[p];
        int sp = p+1;
        while (sp<=r) {
            if (pivot >= arr[sp]) {
                sp++;
            } else {
                swap(arr, sp, r);
                r--;
            }
        }
        swap(arr, p, r);
        return r;
    }
    public static void swap(int[] arr,int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    //双向扫描法
    public static int partition2(int[] arr ,int p ,int r) {
        int privot = arr[p];
        int sp = p + 1;
        int bigger = r;
        while (sp <= bigger) {
            while (sp <= bigger && arr[sp]<=privot){
                sp++;
            }
            while (sp <= bigger && arr[bigger]>privot){
                bigger--;
            }
            if (sp<bigger)
            swap(arr,sp,bigger);
        }
        swap(arr,p,bigger);
        return bigger;
    }
    //
    public static int sort(int[] arr,int i , int j){
        int partion = arr[i];
        int left = i+1;
        int right = j;
        //单向扫描
        while (left<=right){
            if (arr[left]>partion){
                swap(arr,left,right);
                left++;
                right--;
            }else {
                left++;
            }
        }
        swap(arr,i,right);
        return right;
    }
    public static void afterQuick(int[] arr,int i,int j){
        if (i<j) {
            int q = sort(arr, i, j);
            afterQuick(arr, q + 1, j);
            afterQuick(arr, i, q - 1);
        }
    }
}
