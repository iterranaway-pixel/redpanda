import java.util.*;

public class grph1 {
    private int n;
    private int[][] adjMatrix;
    private List<List<Integer>> adjList;
    private boolean isDirected;

    // Constructor
    public grph1(int n, boolean isDirected, int[][] edges) {
        this.n = n;
        this.isDirected = isDirected;
        this.adjMatrix = new int[n][n];
        this.adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Build matrix and list from edges
        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            adjMatrix[src][dest] = 1;
            adjList.get(src).add(dest);
            if (!isDirected) {
                adjMatrix[dest][src] = 1;
                adjList.get(dest).add(src);
            }
        }
    }

    // Print adjacency matrix
    public void printMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Print adjacency list
    public void printList() {
        System.out.println("Adjacency List:");
        for (int i = 0; i < n; i++) {
            System.out.print(i + " -> ");
            for (int neigh : adjList.get(i)) {
                System.out.print(neigh + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Sample Directed Graph: 4 vertices, edges 0->1, 0->2, 1->2, 2->3
        System.out.println("=== DIRECTED GRAPH ===");
        int[][] directedEdges = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 2, 3 } };
        grph1 directedGraph = new grph1(4, true, directedEdges);
        directedGraph.printMatrix();
        directedGraph.printList();

        // Sample Undirected Graph: 4 vertices, edges 0-1, 0-3, 1-2, 2-3 (symmetric)
        System.out.println("=== UNDIRECTED GRAPH ===");
        int[][] undirectedEdges = { { 0, 1 }, { 0, 3 }, { 1, 2 }, { 2, 3 } };
        grph1 undirectedGraph = new grph1(4, false, undirectedEdges);
        undirectedGraph.printMatrix();
        undirectedGraph.printList();
    }
}
