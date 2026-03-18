import java.util.*; // Import required utility classes: ArrayList and List for dynamic data structures

/**
 * Graph class to find all possible paths from a source vertex to a destination
 * vertex in a directed or undirected graph.
 * Uses recursive backtracking on adjacency list representation.
 * Uses visited array to prevent revisiting vertices (handles cycles by avoiding
 * loops).
 */
public class grp4 {
    private int n; // Stores the number of vertices in the graph
    private List<List<Integer>> adjList; // Adjacency list: each index i has list of neighbors of vertex i
    private boolean[] visited; // Boolean array to track visited vertices during traversal
    private List<Integer> path; // Dynamic list to build and hold the current path being explored

    /**
     * Constructor to build the graph.
     * 
     * @param n          Number of vertices (0 to n-1)
     * @param isDirected true if directed graph, false for undirected
     * @param edges      2D array where each row is {source, destination} edge
     */
    public grp4(int n, boolean isDirected, int[][] edges) {
        this.n = n; // Assign number of vertices to instance variable
        this.adjList = new ArrayList<>(); // Create empty ArrayList for adjacency lists
        this.visited = new boolean[n]; // Create visited array of size n, initialized to false
        this.path = new ArrayList<>(); // Create empty path list

        // Initialize adjacency list for each vertex with empty lists
        for (int i = 0; i < n; i++) { // Loop from 0 to n-1
            adjList.add(new ArrayList<>()); // Add empty ArrayList for vertex i's neighbors
        }

        // Build the adjacency list from edges
        for (int[] edge : edges) { // Iterate over each edge array
            int src = edge[0]; // Extract source vertex from edge
            int dest = edge[1]; // Extract destination vertex from edge
            adjList.get(src).add(dest); // Add dest to src's neighbor list (directed edge)
            if (!isDirected) { // If undirected graph
                adjList.get(dest).add(src); // Add src to dest's neighbor list (bidirectional)
            }
        }
    }

    /**
     * Recursive function implementing backtracking to explore all possible paths
     * from current vertex to destination.
     * 
     * @param curr Current vertex in the current path
     * @param dest Destination vertex to reach
     */
    private void findAllPaths(int curr, int dest) {
        path.add(curr); // Append current vertex to the path list (explore this branch)
        visited[curr] = true; // Mark current vertex as visited to prevent cycles

        // Base case: if current vertex is the destination, we found a complete path
        if (curr == dest) { // Check if reached destination
            System.out.print("Path: "); // Print "Path: " prefix
            for (int v : path) { // Iterate over vertices in path
                System.out.print(v + " "); // Print each vertex followed by space
            }
            System.out.println(); // Print newline to end the path line
        } else {
            // Recursive case: explore all unvisited neighbors from current
            for (int neigh : adjList.get(curr)) { // Iterate over neighbors of current vertex
                if (!visited[neigh]) { // If neighbor not yet visited (avoid cycles)
                    findAllPaths(neigh, dest); // Recursive call on neighbor
                }
            }
        }

        // Backtracking: undo changes to allow other branches
        path.remove(path.size() - 1); // Remove last vertex from path (pop)
        visited[curr] = false; // Unmark current as visited for other paths
    }

    /**
     * Public interface to initiate finding all paths from source to destination.
     * 
     * @param src  Source vertex
     * @param dest Destination vertex
     */
    public void printAllPaths(int src, int dest) {
        System.out.println("All paths from " + src + " to " + dest + ":"); // Header with src-dest
        findAllPaths(src, dest); // Start recursion from source
        System.out.println(); // Extra newline for spacing
    }

    /**
     * Utility method to print adjacency list for verification/debugging.
     */
    public void printAdjList() {
        System.out.println("Adjacency List:"); // Header for adj list
        for (int i = 0; i < n; i++) { // Loop through all vertices
            System.out.print(i + " -> "); // Print vertex i and arrow
            for (int neigh : adjList.get(i)) { // Loop through its neighbors
                System.out.print(neigh + " "); // Print each neighbor
            }
            System.out.println(); // Newline after each vertex's list
        }
        System.out.println(); // Extra space
    }

    /**
     * Main method demonstrating usage with sample directed and undirected graphs.
     */
    public static void main(String[] args) {
        // Create directed graph with multiple paths from 0 to 3: 0-1-2-3, 0-1-3, 0-2-3
        System.out.println("=== DIRECTED GRAPH (multiple paths from 0 to 3) ===");
        int[][] dirEdges = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 1, 3 }, { 2, 3 } }; // Define directed edges
        grp4 g1 = new grp4(4, true, dirEdges); // Create directed graph instance
        g1.printAdjList(); // Print adj list first
        g1.printAllPaths(0, 3); // Find/print all paths 0 to 3

        // Create undirected graph, find paths from 0 to 2: 0-1-2, 0-3-2
        System.out.println("=== UNDIRECTED GRAPH (from 0 to 2) ===");
        int[][] undirEdges = { { 0, 1 }, { 1, 2 }, { 0, 3 }, { 2, 3 } }; // Define undirected edges (one dir)
        grp4 g2 = new grp4(4, false, undirEdges); // Create undirected instance
        g2.printAdjList(); // Print adj list
        g2.printAllPaths(0, 2); // Find/print all paths 0 to 2
    }
}
