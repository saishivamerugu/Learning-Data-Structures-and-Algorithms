public class Palindrome{
    public static void main(String[] args) {
        int n = 1221;
        isPalindrome(n);
    }

    static void isPalindrome(int n){
        int rev = 0, org = n;
        while(n != 0){
            rev = rev * 10 + n % 10;
            n /= 10;
        } System.out.println(rev == org ? "palindrome" : "not a palindrome");
    }

     static void usingRecursion(int n){
        
     }
}
