package HashingAndFrequencyAndIndexing;

import java.util.HashSet;

public class FIndAllDuplicates {
    public static void bruteForce(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count > 0) System.out.print(arr[i] + " ");
            
        }
    }
    // TC: O(n²)
    // SC: O(1)

    public static void optimal(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();
        
        for (int num : arr) {
            if (seen.contains(num)) duplicates.add(num);
            else seen.add(num);
        }
        for (int num : duplicates) System.out.print(num + " ");
    }
    // TC: O(n) average
    // SC: O(n)

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 4, 5, 3, 6};

        System.out.print("Brute Force: ");
        bruteForce(arr);
        System.out.print("\nOptimal: ");
        optimal(arr);
    }

}
