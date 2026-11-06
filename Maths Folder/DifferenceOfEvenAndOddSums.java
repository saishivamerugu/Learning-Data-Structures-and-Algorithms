
import java.util.Scanner;

public class DifferenceOfEvenAndOddSums {

    static long findDifference(int[] arr) {
        long evenSum = 0;
        long oddSum = 0;

        for (int num : arr) {
            if (num % 2 == 0) {
                evenSum += num;
            } else {
                oddSum += num;
            }
        }

        return evenSum - oddSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(findDifference(arr));

        sc.close();
    }
}
