package LinearTraversal;

import java.util.Arrays;

public class ArraySorted {

    public static boolean bruteForce(int[] arr) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        return Arrays.equals(arr, sorted); // here we used sorting of adjacent elements
    }
    // TC: O(n log n)
    // SC: O(n)

    public static boolean optimal(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
    // TC: O(n)
    // SC: O(1)

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Brute Force: " + bruteForce(arr));
        System.out.println("Optimal: " + optimal(arr));
    }
}