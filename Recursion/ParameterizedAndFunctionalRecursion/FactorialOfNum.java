package ParameterizedAndFunctionalRecursion;

public class FactorialOfNum {
    public static void main(String[] args) {
        usingParameterized(5, 1);
        System.out.println(usingFunctional(5));
    }

    public static void usingParameterized(int n, int fact){
        if(n < 1){
            System.out.println(fact); return;
        } 
        usingParameterized(n-1, fact * n);
    }

    public static int usingFunctional(int n){
        if(n == 0) return 1;
        return n * usingFunctional(n - 1);
    }
}
