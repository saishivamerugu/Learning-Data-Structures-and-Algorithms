package BasicQuestions;

public class PrintNameNTimes {
    public static void main(String[] args) {
        int n = 5;
        printNameNTimes(1, n);
    }

    public static void printNameNTimes(int i, int n){
        if(i > n) return;
        System.out.println("sai shiva merugu");
        printNameNTimes(i+1, n);
    }
}