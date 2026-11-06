
import java.util.Scanner;

public class GCD {

    static long findGCD(long a, long b) {

        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();

        a = Math.abs(a);
        b = Math.abs(b);

        System.out.println(findGCD(a, b));

        sc.close();
    }
}
