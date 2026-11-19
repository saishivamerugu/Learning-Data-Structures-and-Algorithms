public class Factorial{
    public static void main(String[] args){
        int ans = function(5);
        System.out.println(ans);
    }

    public static int function(int n){
        int ans = 0;
        if(n == 1) return 1;
        ans = n * function(n - 1);
        return ans;
    }
}