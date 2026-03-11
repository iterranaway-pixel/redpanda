public class hash {
        public static void main(String[] args) {
        int[] arr = {23, 4, 57, 82, 95, 13, 113, 224, 72, 18};

        int m = 10;
        Integer[] table = new Integer[m];
        int collisions = 0;

        for (int key : arr) {
            int idx = key % m; 
            while (table[idx] != null) { 
                collisions++;
                idx = (idx + 1) % m;
            }
            table[idx] = key;
        }

        System.out.println("Hash table (index -> value):");
        for (int i = 0; i < m; i++) {
            System.out.println(i + " -> " + table[i]);

    
}

        System.out.println("Total collisions: " + collisions);
    }
}