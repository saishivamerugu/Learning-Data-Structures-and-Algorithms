package TwoPointers;
import java.util.Arrays;

public class ReverseArray {

    public static int[] bruteForce(int[] arr) { // using extra array approach
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - 1 - i];
        }
        return result;
    }
    // TC: O(n)
    // SC: O(n)

    public static void optimal(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    // TC: O(n)
    // SC: O(1)

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        System.out.println("Brute Force: " + Arrays.toString(bruteForce(arr)));
        optimal(arr);
        System.out.println("Optimal: " + Arrays.toString(arr));
    }
}