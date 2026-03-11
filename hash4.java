public class hash4 {
    public static void main(String[] args) {
        int[] keys = {23, 4, 57, 82, 95, 13, 113, 224, 72, 18};
        int tableSize = 10;

        @SuppressWarnings("unchecked")
        java.util.LinkedList<Integer>[] table = (java.util.LinkedList<Integer>[]) new java.util.LinkedList[tableSize];

        for (int key : keys) {
            int idx = key % tableSize;
            if (table[idx] == null) table[idx] = new java.util.LinkedList<>();
            table[idx].add(key);
        }

        System.out.println("Hash table (chaining) with table size " + tableSize + ":");
        for (int i = 0; i < tableSize; i++) {
            System.out.print(i + " -> ");
            System.out.println(table[i] == null ? "[]" : table[i]);
        }
    }
}
