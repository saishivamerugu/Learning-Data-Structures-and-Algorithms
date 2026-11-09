package TwoPointers;

import java.util.HashSet;

public class RemoveDuplicatesFromSortedArray {

    public static void bruteForce(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) set.add(num);
        for (int num : set) System.out.print(num + " ");
    }
    // TC: O(n) average
    // SC: O(n)

    public static int optimal(int[] arr) {
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[j]) {
                j++;
                arr[j] = arr[i];
            }
        }
        return arr.length == 0 ? 0 : j + 1;
    }
    // TC: O(n)
    // SC: O(1)

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 5};
        System.out.println("Brute Force: ");
        bruteForce(arr);
        int k = optimal(arr);
        System.out.println();
        System.out.println("Optimal: ");
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
