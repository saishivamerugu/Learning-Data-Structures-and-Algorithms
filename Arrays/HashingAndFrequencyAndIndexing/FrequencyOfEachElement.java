package HashingAndFrequencyAndIndexing;

import java.util.HashMap;

public class FrequencyOfEachElement {
    public static void bruteForce(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            if (arr[i] == -1) continue;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    arr[j] = -1;
                }
            }
            System.out.println(arr[i] + " - " + count);
        }
    }
    // TC: O(n²)
    // SC: O(1).

    public static void optimal(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) map.put(num, map.getOrDefault(num, 0) + 1);
        for (int num : map.keySet()) System.out.println(num + " - " + map.get(num));
    }
    // TC: O(n) average
    // SC: O(n)

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 1, 4, 2, 3};
        System.out.println("Brute Force:");
        bruteForce(arr);
        System.out.println("Optimal:");
        optimal(arr);
    }

}
