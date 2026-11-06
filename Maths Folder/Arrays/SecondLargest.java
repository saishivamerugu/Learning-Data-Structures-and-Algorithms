package Arrays;

public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10};
        secondLargest(arr);
    }

    static void secondLargest(int[] arr){
        int max = 0, sMax = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                sMax = max;
                max = arr[i];
            } 
            else if(arr[i] > sMax && arr[i] != sMax){
                sMax = arr[i];
            }
        } System.out.println(sMax);
    }
}
