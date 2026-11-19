package ParameterizedAndFunctionalRecursion;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4, 5};
        usingTwoPointers(arr, 0, arr.length-1);
    }

    public static void usingTwoPointers(int[] arr, int left, int right){
        if(left > right){
            System.out.println(Arrays.toString(arr));
            return;
        } 
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        usingTwoPointers(arr, left+1, right-1);
    }

    
}
