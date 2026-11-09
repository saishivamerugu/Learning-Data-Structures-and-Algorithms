package HashingAndFrequencyAndIndexing;

import java.util.HashSet;

public class DuplicateElement {

        public static int bruteForce(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) return arr[i];
            }
        }
        return -1;
    }
    // TC: O(n²)
    // SC: O(1)

    public static int optimal(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    // TC: O(n) average
    // SC: O(n)

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 3};

        System.out.println("Brute Force: " + bruteForce(arr));
        System.out.println("Optimal: " + optimal(arr));
    }
}
