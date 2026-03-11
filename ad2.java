import java.util.*;

class ad2 {
    static int[] h = new int[100];
    static int n = 0;

    static void insert(int x) {
        int i = ++n;
        while (i > 1 && h[i / 2] < x) {
            h[i] = h[i / 2];
            i /= 2;
        }
        h[i] = x;
    }

    static int delete() {
        int max = h[1], last = h[n--];
        int i = 1, c;
        while (i * 2 <= n) {
            c = i * 2;
            if (c + 1 <= n && h[c + 1] > h[c]) c++;
            if (last >= h[c]) break;
            h[i] = h[c];
            i = c;
        }
        h[i] = last;
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) insert(sc.nextInt());
        int t = sc.nextInt();
        while (--t > 0) delete();
        System.out.print(delete());
    }
}
