package LinearTraversal;

public class CountEvenOddElements {

    public static void bruteForce(int[] arr) {
        int even = 0, odd = 0;
        for (int num : arr) if (num % 2 == 0) even++;
        for (int num : arr) if (num % 2 != 0) odd++;
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }
    // TC: O(n)
    // SC: O(1)

    public static void optimal(int[] arr) {
        int even = 0, odd = 0;
        for (int num : arr) {
            if (num % 2 == 0) even++;
            else odd++;
        }
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }
    // TC: O(n)
    // SC: O(1)

    public static void main(String[] args) {
        int[] arr = {10, 15, 20, 25, 30, 35};

        System.out.println("Brute Force:");
        bruteForce(arr);

        System.out.println("Optimal:");
        optimal(arr);
    }
}