package bluebridgecup_course.class_03;

/**
 * @author 武凯焱
 * @date 2019/2/18 9:43
 * @Description:
 */
public class 归并排序 {
    static int nixu = 0;
    public static void main(String[] args) {
        int arr[] = Util.getRandomArr(5,1,20);
        Util.print(arr);
        sort(arr,0,arr.length-1);
        System.out.println(nixu);
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static void  mergerSort(int[] arr,int begin,int end){
        if (begin<end){
            int mid = (begin+end)/2;
            mergerSort(arr,begin,mid);
            mergerSort(arr,mid+1,end);
            merger(arr,begin,mid,end);
        }
    }
    public static void merger(int[] arr,int p,int mid, int r){
        int [] helper = new int [arr.length];
        System.arraycopy(arr,p,helper,p,r-p+1);
        int left = p; //辅助空间的左指针
        int right = mid+1; //辅助空间的右指针
        int current = p;
        while (left<=mid && right<=r){
            if (helper[left]<=helper[right]){
                arr[current] = helper[left];
                current++;
                left++;

            }else {
                arr[current] = helper[right];
                current++;
                right++;
                nixu += mid -left+1;
            }
        }
        while (left<=mid){
            arr[current]=helper[left];
            current++;
            left++;
        }
    }
    //归并排序 重在归并 划分随意
    public static void solve(int[] arr,int i,int j,int mid){
            int[] help = new int[arr.length];
            System.arraycopy(arr,i,help,i,j-i+1);
            int left = i;
            int right = mid+1;
            int cur = i;
            while (left<=mid && right<=j){
                if (help[left]<=help[right]){
                    arr[cur++] = help[left];
                    left++;
                }else {
                    arr[cur++] = help[right];
                    right++;
                }
            }
            while (left<=mid){
                arr[cur++] = help[left];
                left++;
            }
    }
    public static void sort(int[] arr,int begin ,int end){
        if (begin<end){
            int mid = (begin+end)/2;
            mergerSort(arr,begin,mid);
            mergerSort(arr,mid+1,end);
            merger(arr,begin,mid,end);
        }
    }
}
