import java.util.Scanner;

public class fac {

    // Recursive method to calculate sum of first n natural numbers
    public static int sum(int n) {
        if (n == 1) {
            return 1;  // base case
        }
        return n * sum(n - 1);  // recursive case
    }
// Example:

// If n = 4, the calls look like:

// sum(4) returns 4 + sum(3)

// sum(3) returns 3 + sum(2)

// sum(2) returns 2 + sum(1)

// sum(1) returns 1 (base case)

// So, the final result is 4 + 3 + 2 + 1 = 10.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // int n = 10;  // example input
        int result = sum(n);
        System.out.println(result);
    }
}