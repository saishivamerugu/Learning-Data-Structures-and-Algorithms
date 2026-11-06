public class CountNumbers3and5 {
    public static void main(String[] args) {
        count3and5(3, 2000);
    }

    public static void count3and5(int start, int end){
        int count = 0;
        for(int i = start; i <= end; i++){
            if(i % 3 == 0 && i % 5 == 0) count++;
        } System.out.println(count);
    }
}


// Q4. Count Numbers Divisible by 3 and 5 — Count such numbers in a given range.