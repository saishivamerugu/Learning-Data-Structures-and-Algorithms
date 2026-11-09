// public class MaxConsecutiveOnes {
//     public static void main(String[] args) {
//         int[] arr = new int[]{1,1,0,1,1,1,1,1};
//         findmaxConsOne(arr);
//     }

//     public static void findmaxConsOne(int arr[]){
//         int max = 0, count = 0;
//         for(int i = 0; i < arr.length; i++){
//             for(int j = i; j < arr.length; j++){
//                 if(arr[j] == 0){
//                     count = j - i;
//                     if(count > max) max = count;
//                     break;
//                 }
//             }
//         } System.out.println(max);
//     }
// }
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 1, 1, 1, 1, 1, 0, 1,1,1,1,1,1,1,0};
        findMaxConsOne(arr);
        findMaxConsOneO(arr);
    }

    public static void findMaxConsOne(int arr[]) {
        int max = 0, count = 0;
        for (int i = 0; i < arr.length; i++) {
            count = 0;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] == 0) break;
                count++;
            }
            if (count > max) max = count;
        }
        System.out.println(max);
    }

    public static void findMaxConsOneO(int arr[]) {
        int max = 0, count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }

        System.out.println(max);
    }

}