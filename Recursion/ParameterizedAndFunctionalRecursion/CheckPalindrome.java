package ParameterizedAndFunctionalRecursion;

public class CheckPalindrome {
    public static void main(String[] args) {
        String str = new String("madam");
        String s = isPalindrome(str, 0, str.length() - 1) ? "Palindrome" : "not a palindrome";
        System.out.println(s);
    }

    public static boolean isPalindrome(String str, int left, int right) {
        if (left >= right) return true; 
        if (str.charAt(left) != str.charAt(right)) return false;
        return isPalindrome(str, left + 1, right - 1); 
    } 
}
