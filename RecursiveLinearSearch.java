public class RecursiveLinearSearch {

    // Recursive method for linear search
    public static int linearSearch(int[] arr, int target, int index) {
        if (index == arr.length) {
            return -1; // base case: target not found
        }
        if (arr[index] == target) {
            return index; // target found, return index
        }
        return linearSearch(arr, target, index + 1); // search next element
    }

    public static void main(String[] args) {
        int[] numbers = {5, 3, 7, 1, 9, 4};
        int target = 7;

        int result = linearSearch(numbers, target, 0);

        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}

