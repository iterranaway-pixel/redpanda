import java.util.*;

public class SumOfDistinctElements {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1, 1, 4, 5, 6, 5};

        
        Set<Integer> distinct = new HashSet<>();
        for (int num : a) {
            distinct.add(num);
        }

       
        int sum = 0;
        for (int num : distinct) {
            sum += num;
        }

        System.out.println("Sum of distinct elements: " + sum);
    }
}