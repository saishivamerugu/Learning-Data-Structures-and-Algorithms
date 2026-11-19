
package ParameterizedAndFunctionalRecursion;

public class SumOfNNumbers {
    public static void main(String[] args) {
        int i = 5, sum = 0;
        usingParameterised(i, sum);
        System.out.println(usingFunctional(5));
    }

    public static void usingParameterised(int i, int sum) {
        if (i < 1){
            System.out.println(sum);
            return;
        } 
        usingParameterised(i - 1, sum + i);
    }

    public static int usingFunctional(int n){
        if(n == 0) return 0;
        return n + usingFunctional(n - 1);
    }
}
