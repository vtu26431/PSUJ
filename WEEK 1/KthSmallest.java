import java.util.Arrays;

public class KthSmallest {

    public static int findKthSmallest(int[] arr, int k) {
        Arrays.sort(arr);   // sort the array
        return arr[k - 1];  // kth smallest element
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;

        System.out.println("Kth smallest element is: " + findKthSmallest(arr, k));
    }
}
