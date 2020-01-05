import java.util.*;

public class FindMaxSubarray {
    public static void main(String[] args){
        //int[] list = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        Scanner in = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int n = in.nextInt();

        int[] list = new int[n];
        System.out.print("Enter the list: ");

        for (int i = 0; i < n; i++)
            list[i] = in.nextInt();

        int[] result = findMaxSubarray(list, 0, list.length-1);
        System.out.println(Arrays.toString(result));

    }

    public static int[] findMaxSubarray(int[] list, int low, int high){
        int[] result = new int[3];

        if (low == high) {
            result[0] = low;
            result[1] = high;
            result[2] = list[low];
            return result;
        }

        else {
            int mid = (low + high) / 2;

            int[] left_result = findMaxSubarray(list, low, mid);
            int[] right_result = findMaxSubarray(list, mid+1, high);
            int[] cross_result = findMaxCrossingSubarray(list, low, mid, high);

            if (left_result[2] >= right_result[2] && left_result[2] >= cross_result[2])
                return left_result;
            else if (right_result[2] >= left_result[2] && right_result[2] >= cross_result[2])
                return right_result;
            else
                return cross_result;
        }
    }

    public static int[] findMaxCrossingSubarray(int[] list, int low, int mid, int high){
        int[] result = new int[3];
        int sum = 0;
        int max_left = mid;
        int max_right = mid;
        int left_sum = (int)Double.NEGATIVE_INFINITY;
        int right_sum = (int)Double.NEGATIVE_INFINITY;

        for (int i = mid; i >= low; i--){
            sum += list[i];
            if (sum > left_sum) {
                left_sum = sum;
                max_left = i;
            }
        }

        sum = 0;
        for (int j = mid+1; j <= high; j++){
            sum += list[j];
            if (sum > right_sum){
                right_sum = sum;
                max_right = j;
            }
        }

        result[0] = max_left;
        result[1] = max_right;
        result[2] = left_sum + right_sum;

        return result;
    }

}
