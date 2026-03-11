// public class mat1 {


//     public static void main(String[] args) {
//         int[] arr = {1, 2, 4, 6, 7, 8, 10};
//         int[] arr2 = {2, 2, 0, 6, 3, 4, 10};

//         int k = 4;
//         int res = dupli(arr, arr2, k);
//         System.out.println("Index with difference " + k + ": " + res);
//     }

//     static int dupli(int[] arr, int[] arr2, int k) {
//         if (arr.length == arr2.length) {
//             for (int i = 0; i < arr.length; i++) {
//                 if (arr[i] - arr2[i] == k) {
//                     return i;
//                 }
//             }
//         }
//         return -1; // return -1 if no such index is found or arrays are unequal
//     }
// }
    

public class mat1 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 7, 8, 10};
        int[] arr2 = {2, 2, 0, 6, 3, 4, 10};
        int k = 4;

        dupli(arr, arr2, k);
    }

    static void dupli(int[] arr, int[] arr2, int k) {
        if (arr.length != arr2.length) {
            System.out.println("Arrays must be of equal length.");
            return;
        }

        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - arr2[i] == k) {
                System.out.println("Matching index: " + i);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching index found.");
        }
    }
}