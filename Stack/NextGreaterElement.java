package MonotonicStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        
        int[] arr = new int[]{3,1,3,2,4};
        bruteForceApproach(arr);

        List<Integer> ans = optimalApproach(arr);
        System.out.println(ans);
    }

    public static List<Integer> optimalApproach(int[] arr){

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            ans.add(-1);
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = arr.length - 1; i >= 0; i--){
            while (!stack.isEmpty() && stack.peek() <= arr[i] ) {
                stack.pop();
            }
            if(!stack.isEmpty()){
                ans.set(i, stack.peek());
            } stack.push(arr[i]);
        }
        return ans;
    }

    public static void bruteForceApproach(int[] arr){
        int[] ans = new int[]{-1,-1,-1,-1,-1};
        
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] < arr[j]) {
                    ans[i] = arr[j];
                    break;
                }
            }
        } System.out.println(Arrays.toString(ans));
    }
}
