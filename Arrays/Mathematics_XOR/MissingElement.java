package Mathematics_XOR;

public class MissingElement {
    
    public static int bruteForce(int[] arr, int n) {
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == i) count++;
            }
            if (count == 0) return i;
        }
        return -1;
    }
    // TC: O(n²)
    // SC: O(1)

    public static int optimal(int[] arr, int n) {
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : arr) actualSum += num;
        return expectedSum - actualSum;
    }
    // TC: O(n)
    // SC: O(1)

    public static void approach(int[] arr){
        int j = 1;
        for(int i = 0; i < arr.length; i++){
            if (arr[i] == j) {
                j++;
            } else {
                System.out.println(j + " is the missing element"); 
                return;
            }
        }
    } 
    // TC : O(n)
    // SC : O(1)

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5};
        int n = 5;
        System.out.println("Brute Force: " + bruteForce(arr, n));
        System.out.println("Optimal: " + optimal(arr, n));
    }
}
