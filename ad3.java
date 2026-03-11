import java.util.*;

class Graph {
    public static void main(String[] args) {
        int[][] matrix = {
            {0,1,0,1},
            {1,0,1,0},
            {0,1,0,1},
            {1,0,1,0}
        };

        int n = matrix.length;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (matrix[i][j] == 1)
                    adj.get(i).add(j);

        for (int i = 0; i < n; i++)
            System.out.println(i + " -> " + adj.get(i));
    }
}
