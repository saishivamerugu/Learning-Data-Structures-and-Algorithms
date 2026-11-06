
import java.util.Scanner;

public class PrimeNumber {

    static boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (long i = 3; i <= n / i; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        if (isPrime(n)) System.out.println("Prime");
        else System.out.println("Not Prime");
        sc.close();
    }
}


// The idea is simple:
// 1. If n < 2, it is not prime.
// 2. If n == 2, it is prime.
// 3. If n is even, it is not prime.
// 4. Check only odd divisors from 3 up to the square root of n.
// 5. If any divisor divides n completely, return false. Otherwise, return true.