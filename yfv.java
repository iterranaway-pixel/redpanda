public class yfv {
 

    public static void main(String[] args) {
        int[] arr = {36, 19, 29, 12, 9};
        bubbleSort(arr);
        for (int num : arr) {
            System.out.println(num);
        }
    }

    static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) { // loop runs n-1 times
            for (int j = 0; j < n - 1 - i; j++) { // inner loop avoids out-of-bound
                if (arr[j] > arr[j + 1]) { // swap only if needed
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    
}
}
