import java.util.*; // Import utility classes like ArrayList and List

/**
 * GraphRepresentation class with DFS traversal for directed/undirected graphs.
 * Supports adjacency matrix, list, and DFS traversal.
 */
public class grp2 {
    private int n; // Number of vertices in the graph
    private int[][] adjMatrix; // 2D array for adjacency matrix representation
    private List<List<Integer>> adjList; // List of lists for adjacency list representation
    private boolean isDirected; // Flag to indicate if graph is directed or undirected
    private boolean[] visited; // Visited array for DFS traversal

    /**
     * Constructor to initialize graph with given number of vertices, type, and
     * edges.
     * 
     * @param n          number of vertices
     * @param isDirected true for directed, false for undirected
     * @param edges      2D array of edges {src, dest}
     */
    public grp2(int n, boolean isDirected, int[][] edges) {
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
     * Recursive DFS from starting vertex v.
     * 
     * @param v current vertex
     */
    private void dfs(int v) {
        visited[v] = true; // Mark current vertex as visited
        System.out.print(v + " "); // Print the vertex (traversal order)

        // Visit all adjacent vertices recursively
        for (int neigh : adjList.get(v)) { // For each neighbor
            if (!visited[neigh]) { // If not visited
                dfs(neigh); // Recursive DFS call
            }
        }
    }

    /**
     * Perform DFS traversal starting from vertex 0.
     */
    public void dfsTraversal() {
        System.out.print("DFS Traversal (from 0): ");
        Arrays.fill(visited, false); // Reset visited array
        dfs(0); // Start DFS from vertex 0
        System.out.println(); // New line
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
        // DFS expected: 0 1 2 3
        System.out.println("=== DIRECTED GRAPH ===");
        int[][] directedEdges = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 2, 3 } };
        grp2 directedGraph = new grp2(4, true, directedEdges);
        directedGraph.printMatrix();
        directedGraph.printList();
        directedGraph.dfsTraversal();

        // Sample Undirected Graph: 4 vertices, edges 0-1, 0-3, 1-2, 2-3
        // DFS expected: 0 1 2 3 (or similar order)
        System.out.println("=== UNDIRECTED GRAPH ===");
        int[][] undirectedEdges = { { 0, 1 }, { 0, 3 }, { 1, 2 }, { 2, 3 } };
        grp2 undirectedGraph = new grp2(4, false, undirectedEdges);
        undirectedGraph.printMatrix();
        undirectedGraph.printList();
        undirectedGraph.dfsTraversal();
    }
}
