package LinearTraversal;

import java.util.Arrays;

public class LargestElement {

    public static int bruteForce(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }

    // TC: O(n log n)
    // SC: Depends on sorting implementation

    public static int optimal(int[] arr) {
        int largest = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > largest) largest = arr[i];
        return largest;
    }

    // TC: O(n)
    // SC: O(1)

    public static void main(String[] args) {
        int[] arr = {10, 5, 20, 8, 15};
        System.out.println("Brute Force: " + bruteForce(arr));
        System.out.println("Optimal: " + optimal(arr));
    }
}
