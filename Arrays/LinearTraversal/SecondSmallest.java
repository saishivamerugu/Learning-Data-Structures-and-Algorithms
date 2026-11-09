package LinearTraversal;
import java.util.Arrays;

public class SecondSmallest {

    public static int[] bruteForce(int[] arr) {
        Arrays.sort(arr);
        int smallest = arr[0];
        int secondSmallest = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > smallest) {
                secondSmallest = arr[i];
                break;
            }
        }
        return new int[]{smallest, secondSmallest == Integer.MAX_VALUE ? -1 : secondSmallest};
    }
    // TC: O(n log n)
    // SC: Depends on sorting implementation

    public static int[] optimal(int[] arr) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num < smallest) {
                secondSmallest = smallest;
                smallest = num;
            } else if (num > smallest && num < secondSmallest) {
                secondSmallest = num;
            }
        }
        return new int[]{smallest, secondSmallest == Integer.MAX_VALUE ? -1 : secondSmallest};
    }
    // TC: O(n)
    // SC: O(1)

    public static void main(String[] args) {
        int[] arr = {10, 5, 20, 8, 15};

        System.out.println("Brute Force: " + Arrays.toString(bruteForce(arr)));
        System.out.println("Optimal: " + Arrays.toString(optimal(arr)));
    }
}