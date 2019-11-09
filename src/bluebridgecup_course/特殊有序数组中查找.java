package bluebridgecup_course;

/**
 * @author 武凯焱
 * @date 2019/2/14 15:20
 * @Description:
 */
public class 特殊有序数组中查找 {
    public static void main(String[] args) {
        String[] arr = {"a","","ac","","ad","b","","ba"};
        System.out.println(indexOf(arr,"abc"));
    }
    public static int indexOf(String[] arr, String key){
            int begin = 0;
            int end = arr.length-1;
            int mid ;
            while (begin<=end){
                mid = (begin+end)/2;
                while(arr[mid].equals("")){
                    mid++;
                    if (mid>end){
                        return -1;
                    }
                }
                if (arr[mid].compareTo(key)>0){
                    end = mid-1;
                }

                else if (arr[mid].compareTo(key)<0){
                    begin = mid+1;
                }
                else {
                    return mid;
                }

            }
            return -1;
    }
}
