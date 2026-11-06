
import java.util.Scanner;

public class MissingNumber {

    static long findMissingNumber(int[] arr) {
        long n = arr.length;
        long expectedSum = n * (n + 1) / 2;
        long actualSum = 0;

        for (int num : arr) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(findMissingNumber(arr));

        sc.close();
    }
}
