public class ReverseNumber{
    public static void main(String[] args) {
        reverseNumber(521);
    }

    static void reverseNumber(int n){
        int digit = 0, rev = 0;
        while (n != 0) {
            digit = n % 10;
            rev = rev * 10 + digit;
            n /= 10;
        } System.out.println(rev);
    }
}