public class PatternExample {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 6};
        subArrayMaxSum(arr, 3);
    }

    static void subArrayMaxSum(int[] arr, int k) {
        int max = 0;
        for (int i = 0; i <= arr.length - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) sum += arr[j];
            if (sum > max) max = sum;
        }
        System.out.println(max);
    }
}