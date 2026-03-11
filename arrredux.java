public class arrredux {
    public static void main(String[] args) {
        int arr[] = {5, 1, 1, 1, 2, 3, 5};

        // Step 1: Find the minimum value in the array
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        // Step 2: Subtract the minimum value from each element
        System.out.println("Reduced array:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] - min;
            System.out.println(arr[i]);
        }
    }
}

