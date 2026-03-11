import java.util.Arrays;

public class hash3 {
    private final int[] table;
    private final int EMPTY = Integer.MIN_VALUE;
    private final int m;

    public hash3(int size) {
        this.m = size;
        this.table = new int[m];
        Arrays.fill(table, EMPTY);
    }

    private int hash(int key) {
        return Math.abs(key) % m;
    }

    // Insert using quadratic probing: h(k, i) = (h(k) + i*i) % m
    public boolean insert(int key) {
        int h0 = hash(key);
        for (int i = 0; i < m; i++) {
            int idx = (h0 + i * i) % m;
            if (table[idx] == EMPTY) {
                table[idx] = key;
                return true;
            }
        }
        // table full / insertion failed
        return false;
    }

    public void display() {
        System.out.println("Index : Value");
        for (int i = 0; i < m; i++) {
            if (table[i] == EMPTY) {
                System.out.printf("%5d : %s%n", i, "-");
            } else {
                System.out.printf("%5d : %d%n", i, table[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[] keys = {23, 4, 57, 82, 95, 13, 113, 224, 72, 18};
        // choose a table size (preferably a prime > number of keys)
        hash3 ht = new hash3(10);

        for (int k : keys) {
            boolean ok = ht.insert(k);
            if (!ok) {
                System.out.println("Failed to insert: " + k);
            }
        }

        ht.display();
    }
}
