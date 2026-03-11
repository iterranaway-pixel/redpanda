public class hash2 {

    public static int insertLinear(Integer[] table, int key) {
        int m = table.length;
        int idx = ((key % m) + m) % m; // initial index
        int start = idx;
        int collisions = 0;

        while (table[idx] != null) {
            collisions++;
            idx = (idx + 1) % m; // linear probing: step size = 1
            if (idx == start) {
                throw new IllegalStateException("Hash table is full; cannot insert " + key);
            }
        }
        table[idx] = key;
        return collisions;
    }

    public static void printTable(Integer[] table) {
        System.out.println("Hash table (index -> value):");
        for (int i = 0; i < table.length; i++) {
            System.out.println(i + " -> " + table[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 23, 4, 57, 82, 95, 13, 113, 224, 72, 18 };

        int m = 10;
        Integer[] table = new Integer[m];
        int collisions = 0;

        for (int key : arr) {
            collisions += insertLinear(table, key);
        }

        printTable(table);
        System.out.println("Total collisions: " + collisions);
    }
}
