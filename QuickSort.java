import java.util.*;

public class QuickSort {
    public static void main(String[] args){
        //int[] list = {1, 4, 2, 5, 3};
        Scanner in = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int n = in.nextInt();

        int[] list = new int[n];
        System.out.print("Enter the list: ");
        for (int i = 0; i < n; i++)
            list[i] = in.nextInt();

        quickSort(list, 0, list.length-1);
        System.out.print("Sorted list: ");
        System.out.println(Arrays.toString(list));

    }

    private static void quickSort(int[] list, int p, int r){
        if (p < r){
            int q = randomizedPartition(list, p, r);
            quickSort(list, p, q-1);
            quickSort(list, q+1, r);
        }

    }

    private static int randomizedPartition(int[] list, int p, int r){
        int random = (int)(Math.random() * (r - p + 1) + p);
        int temp = list[random];
        list[random] = list[r];
        list[r] = temp;

        int x = list[r];
        int i = p - 1;
        for (int j = p; j < r; j++){
            if (list[j] <= x){
                i++;
                temp = list[i];
                list[i] = list[j];
                list[j] = temp;
            }
        }

        temp = list[i+1];
        list[i+1] = list[r];
        list[r] = temp;

        return i+1;
    }
}
