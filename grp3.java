import java.util.*; // Import utility classes like ArrayList, List, Queue, LinkedList

/**
 * GraphRepresentation class with BFS traversal for directed/undirected graphs.
 * Supports adjacency matrix, list, and BFS traversal using queue.
 */
public class grp3 {
    private int n; // Number of vertices in the graph
    private int[][] adjMatrix; // 2D array for adjacency matrix representation
    private List<List<Integer>> adjList; // List of lists for adjacency list representation
    private boolean isDirected; // Flag to indicate if graph is directed or undirected
    private boolean[] visited; // Visited array for BFS traversal

    /**
     * Constructor to initialize graph with given number of vertices, type, and
     * edges.
     * 
     * @param n          number of vertices
     * @param isDirected true for directed, false for undirected
     * @param edges      2D array of edges {src, dest}
     */
    public grp3(int n, boolean isDirected, int[][] edges) {
        this.n = n; // Set number of vertices
        this.isDirected = isDirected; // Set directed/undirected flag
        this.adjMatrix = new int[n][n]; // Initialize n x n matrix with zeros
        this.adjList = new ArrayList<>(); // Initialize adjacency list
        this.visited = new boolean[n]; // Initialize visited array to false (default)

        // Initialize each vertex's neighbor list as empty ArrayList
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Populate matrix and list from given edges
        for (int[] edge : edges) {
            int src = edge[0]; // Source vertex
            int dest = edge[1]; // Destination vertex
            adjMatrix[src][dest] = 1; // Mark edge in matrix (1 indicates edge exists)
            adjList.get(src).add(dest); // Add to source's neighbor list

            // For undirected graph, add reverse edge too
            if (!isDirected) {
                adjMatrix[dest][src] = 1; // Symmetric entry in matrix
                adjList.get(dest).add(src); // Bidirectional neighbor
            }
        }
    }

    /**
     * BFS traversal starting from given vertex using queue (level order).
     * 
     * @param start starting vertex
     */
    public void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>(); // Queue for BFS (FIFO)
        visited[start] = true; // Mark start as visited
        queue.add(start); // Enqueue start vertex

        while (!queue.isEmpty()) { // While queue not empty
            int v = queue.poll(); // Dequeue front vertex
            System.out.print(v + " "); // Print vertex (BFS order)

            // Enqueue all unvisited neighbors
            for (int neigh : adjList.get(v)) { // For each adjacent vertex
                if (!visited[neigh]) { // If not visited
                    visited[neigh] = true; // Mark as visited
                    queue.add(neigh); // Enqueue it
                }
            }
        }
    }

    /**
     * Perform BFS traversal starting from vertex 0.
     */
    public void bfsTraversal() {
        System.out.print("BFS Traversal (from 0): ");
        Arrays.fill(visited, false); // Reset visited array before traversal
        bfs(0); // Start BFS from vertex 0
        System.out.println(); // New line at end
    }

    /**
     * Prints the adjacency matrix row by row.
     */
    public void printMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < n; i++) { // For each row
            for (int j = 0; j < n; j++) { // For each column
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println(); // New line after row
        }
        System.out.println();
    }

    /**
     * Prints the adjacency list for all vertices.
     */
    public void printList() {
        System.out.println("Adjacency List:");
        for (int i = 0; i < n; i++) { // For each vertex
            System.out.print(i + " -> ");
            for (int neigh : adjList.get(i)) { // For each neighbor
                System.out.print(neigh + " ");
            }
            System.out.println(); // New line after list
        }
        System.out.println();
    }

    /**
     * Main method with sample directed and undirected graphs for demonstration.
     */
    public static void main(String[] args) {
        // Sample Directed Graph: 4 vertices, edges 0->1, 0->2, 1->2, 2->3
        // BFS expected: 0 1 2 3 (level order)
        System.out.println("=== DIRECTED GRAPH ===");
        int[][] directedEdges = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 2, 3 } };
        grp3 directedGraph = new grp3(4, true, directedEdges);
        directedGraph.printMatrix();
        directedGraph.printList();
        directedGraph.bfsTraversal();

        // Sample Undirected Graph: 4 vertices, edges 0-1, 0-3, 1-2, 2-3
        // BFS expected: 0 1 3 2 (level order)
        System.out.println("=== UNDIRECTED GRAPH ===");
        int[][] undirectedEdges = { { 0, 1 }, { 0, 3 }, { 1, 2 }, { 2, 3 } };
        grp3 undirectedGraph = new grp3(4, false, undirectedEdges);
        undirectedGraph.printMatrix();
        undirectedGraph.printList();
        undirectedGraph.bfsTraversal();
    }
}
