package BasicQuestions;

public class PrintLinearlyFrom1ToN {
    public static void main(String[] args) {
        int n = 5;;
        printLinearlyFrom1ToN(1, n);
        withoutBackTracking(n, n);
    }

    public static void printLinearlyFrom1ToN(int i, int n){
        if(i > n) return;
        System.out.println(i++);
        printLinearlyFrom1ToN(i, n);
    }

    public static void withoutBackTracking(int i, int n){
        if(i < 1) return;
        withoutBackTracking(i-1, n); // we kept the function call before we print something...
        System.out.println(i);
    }
}
