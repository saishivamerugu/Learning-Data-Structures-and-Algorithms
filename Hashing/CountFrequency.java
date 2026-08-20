import java.util.Arrays;

public class CountFrequency{
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,1,3,2,4,5,4,6,5,7,8,1};
        countFreq(arr);
    }

    public static void countFreq(int []arr){
        int[] hash = new int[15];
        for(int i = 0; i < arr.length; i++) hash[arr[i]]++;
        System.out.print(Arrays.toString(hash)); 
    }

    public static void 
} 