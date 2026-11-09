package LinearTraversal;

import java.util.Arrays;

public class SumAndAverageOfArrayElements {
    public static double[] bruteForce(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        double average = (double) sum / arr.length;
        return new double[]{sum, average};
    }
    // TC: O(n)
    // SC: O(1) auxiliary space

    public static double[] optimal(int[] arr) {
        int sum = 0;
        for (int num : arr) sum += num;
        double average = (double) sum / arr.length;
        return new double[]{sum, average};
    }
    // TC: O(n)
    // SC: O(1)

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        System.out.println("Brute Force: " + Arrays.toString(bruteForce(arr)));
        System.out.println("Optimal: " + Arrays.toString(optimal(arr)));
    }

}
