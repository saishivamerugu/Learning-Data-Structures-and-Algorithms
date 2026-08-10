public class PyramidStars {
    public static void main(String[] args) {
        printStars(5);
    }

    public static void printStars(int n){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n - i; j++) System.out.print(" ");
            for(int j = 1; j <= i; j++) System.out.print("* ");
            System.out.println();
        }
    }
} 
