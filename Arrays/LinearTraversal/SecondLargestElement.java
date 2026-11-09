package LinearTraversal;

import java.util.Arrays;

public class SecondLargestElement {

    public static int bruteForce(int[] arr) {
        Arrays.sort(arr);
        int largest = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) if (arr[i] < largest) return arr[i];
        return -1;
    }
    // TC: O(n log n)
    // SC: Depends on sorting implementation

    public static int optimal(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num < largest) {
                secondLargest = num;
            }
        }
        return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
    }
    // TC: O(n)
    // SC: O(1)

    public static void main(String[] args) {
        int[] arr = {10, 5, 20, 8, 15};
        System.out.println("Brute Force: " + bruteForce(arr));
        System.out.println("Optimal: " + optimal(arr));
    }
}