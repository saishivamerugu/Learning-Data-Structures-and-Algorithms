package BasicQuestions;

public class PrintFromNTo1 {
    public static void main(String[] args) {
        int n = 5;
        printFomNTo1(1, n);
        withoutBackTracking(3, 3);
    }

    public static void printFomNTo1(int i, int n){
        if(n < i) return;
        System.out.println(n--);
        printFomNTo1(i, n); 
    }
}
