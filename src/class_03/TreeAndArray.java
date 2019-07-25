package class_03;

/**
 * @author 武凯焱
 * @date 2019/2/20 10:48
 * @Description:
 */
public class  TreeAndArray {
    public static void main(String[] args) {
        int[] arr = {43,4,5,7,11,12,13};
        inOrder(arr,0);

    }
    //先序遍历
    static void preOrder(int[] arr ,int i){
        if (i>= arr.length){
            return;
        }
        System.out.print(arr[i]+" "); //输出根节点
        preOrder(arr,2*i+1);  //输出左节点
        preOrder(arr,2*i+2);  //输出右节点
    }
    //中序遍历
    static void  inOrder(int[] arr, int i){
        if (i>= arr.length){
            return;
        }
        inOrder(arr,2*i+1);//输出左节点
        System.out.print(arr[i]+" ");//输出根节点
        inOrder(arr,2*i+2); //输出右节点
    }
    //后序遍历
    static  void afterOrder(int[] arr,int i){
        if (i>=arr.length){
            return;
        }
        afterOrder(arr,2*i+1);//输出左节点
        afterOrder(arr,2*i+2);//输出右节点
        System.out.print(arr[i]+" ");//输出根节点

    }
}
