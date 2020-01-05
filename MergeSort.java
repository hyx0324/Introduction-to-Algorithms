import java.util.*;

public class MergeSort {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int n = in.nextInt();

        int[] list = new int[n];
        System.out.print("Enter the list: ");
        for (int i = 0; i < n; i++)
            list[i] = in.nextInt();

        //int[] list = {1,3,2,0,8};
        mergeSort(list, 0, list.length-1);
        //for (int element : list)
        //    System.out.println(element);
        System.out.print("Sorted list: ");
        System.out.println(Arrays.toString(list));

    }

    public static void mergeSort(int[] list, int p, int r){
        if (p < r){
            int q = (p + r) / 2;
            mergeSort(list, p, q);
            mergeSort(list, q+1, r);
            merge(list, p, q, r);
        }
    }

    public static void merge(int[] list, int p, int q, int r){
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] list_l = new int[n1+1];
        int[] list_r = new int[n2+1];

        for (int i = 0; i < n1; i++)
            list_l[i] = list[p+i];
        for (int j = 0; j < n2; j++)
            list_r[j] = list[q+1+j];

        list_l[n1] = (int)Double.POSITIVE_INFINITY;
        list_r[n2] = (int)Double.POSITIVE_INFINITY;

        int i = 0;
        int j = 0;

        for (int k = p; k <= r; k++){
            if (list_l[i] <= list_r[j]){
                list[k] = list_l[i];
                i++;
            }
            else {
                list[k] = list_r[j];
                j++;
            }
        }
    }
}
