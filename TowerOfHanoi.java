public class TowerOfHanoi {


    public static void solveHanoi(int n, char source, char a, char destination) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }


        solveHanoi(n - 1, source, destination, a);


        System.out.println("Move disk " + n + " from " + source + " to " + destination);

        solveHanoi(n - 1, a, source, destination);
    }

    public static void main(String[] args) {
        int numDisks = 3; 
        solveHanoi(numDisks, 'A', 'B', 'C');
    }
}
// solveHanoi(3, A, B, C)
// ├── solveHanoi(2, A, C, B)
// │   ├── solveHanoi(1, A, B, C)
// │   └── Move disk 2 from A to B
// │   └── solveHanoi(1, C, A, B)
// ├── Move disk 3 from A to C
// └── solveHanoi(2, B, A, C)
//     ├── solveHanoi(1, B, C, A)
//     └── Move disk 2 from B to C
//     └── solveHanoi(1, A, B, C)

