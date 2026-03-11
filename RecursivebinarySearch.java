public class RecursivebinarySearch {

    // Recursive method for binary search
    public static int binarySearch(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;  // base case: target not found
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid;  // target found
        } else if (arr[mid] > target) {
            return binarySearch(arr, target, left, mid - 1);  // search left half
        } else {
            return binarySearch(arr, target, mid + 1, right); // search right half
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 7, 9};  // NOTE: array must be sorted for binary search
        int target = 7;

        int result = binarySearch(numbers, target, 0, numbers.length - 1);

        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}

