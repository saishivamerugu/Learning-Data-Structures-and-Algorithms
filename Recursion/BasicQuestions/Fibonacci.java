package BasicProgramming;

public class Fibonacci {
    public static void main(String[] args) {
        findFibo(5);
    }

    public static void findFibo(int n){
        int a = 0, b = 1;
        for(int i = 0; i < n; i++){
            System.out.print(a + " ");
            int c = a + b;
            a = b;
            b = c;
        }
    }
}
