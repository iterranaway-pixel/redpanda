import java.util.Scanner;

public class SumNaturalNumbers {

    // Recursive method to calculate sum of first n natural numbers
    public static int sum(int n) {
        if (n == 1) {
            return 1;  // base case
        }
        return n + sum(n - 1);  // recursive case
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
// class ad1{
//     public int natural(a){
//         if (a == 0);
//           return 1
//         natural (a,a+1);
        
//     }
//     public static void main(String [] args){
//     Scanner sc = new Scanner(System.in);
//     int n = sc.nextInt();

//     int s=0;

//     for(int i =1; i<n;i++){
//         s+=i;
//     }
//     System.out.println(s);
// }}


// public class MyClass {
    
//     // This is a function (method) that takes two integers and returns their sum
//     public int addNumbers(int a, int b) {
//         int sum = a + b;
//         return sum;
//     }

//     public static void main(String[] args) {
//         MyClass obj = new MyClass();
//         int result = obj.addNumbers(5, 3);
//         System.out.println("Sum: " + result);
//     }
// }