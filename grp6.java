import java.util.*; // Import utility classes: ArrayList for dynamic lists, Arrays for fill

/**
 * Program to determine if a directed graph is strongly connected.
 * A directed graph is strongly connected if there is a path from every vertex
 * to every other vertex.
 * Implements Kosaraju's algorithm:
 * 1. DFS on original graph to get finishing times (stack).
 * 2. Transpose the graph.
 * 3. DFS on transpose in decreasing finish time order; count SCCs.
 * Strongly connected if exactly 1 SCC.
 */
public class grp6 {
    private int n; // Number of vertices (0 to n-1)
    private List<List<Integer>> adjList; // Adjacency list for original directed graph
    private List<List<Integer>> transpose; // Adjacency list for transpose graph (reverse edges)
    private boolean[] visited; // Boolean array to mark visited vertices during DFS
    private java.util.Stack<Integer> stack; // Stack to store vertices in finishing time order (non-generic Stack)

    /**
     * Constructor: builds original and transpose adjacency lists from edges.
     * 
     * @param n     Number of vertices
     * @param edges Array of directed edges {{u, v} meaning u -> v}
     */
    public grp6(int n, int[][] edges) {
        this.n = n; // Set number of vertices
        this.adjList = new ArrayList<>(); // Initialize original adj list
        this.transpose = new ArrayList<>(); // Initialize transpose adj list
        this.visited = new boolean[n]; // Initialize visited array
        this.stack = new java.util.Stack<>(); // Initialize stack for finish order

        // Initialize empty lists for each vertex in both graphs
        for (int i = 0; i < n; i++) { // Loop over all vertices
            adjList.add(new ArrayList<>()); // Empty neighbor list for original
            transpose.add(new ArrayList<>()); // Empty neighbor list for transpose
        }

        // Build adjacency lists from edges
        for (int[] edge : edges) { // Iterate over all edges
            int u = edge[0]; // Extract source vertex u
            int v = edge[1]; // Extract destination vertex v
            adjList.get(u).add(v); // Add v to u's list in original (u -> v)
            transpose.get(v).add(u); // Add u to v's list in transpose (v -> u)
        }
    }

    /**
     * First DFS pass on original graph to compute finishing times.
     * Visits vertices, recurses on unvisited neighbors, pushes vertex to stack on
     * finish.
     * 
     * @param v Starting vertex for DFS
     */
    private void dfs1(int v) {
        visited[v] = true; // Mark current vertex as visited
        for (int neigh : adjList.get(v)) { // Iterate over neighbors of v in original graph
            if (!visited[neigh]) { // If neighbor not visited
                dfs1(neigh); // Recursive DFS on neighbor
            }
        }
        stack.push(v); // Push v to stack after processing all neighbors (finish time)
    }

    /**
     * Second DFS pass on transpose graph to identify SCCs.
     * Called in order of decreasing finishing times.
     * 
     * @param v Starting vertex for DFS on transpose
     */
    private void dfs2(int v) {
        visited[v] = true; // Mark current vertex as visited
        for (int neigh : transpose.get(v)) { // Iterate over neighbors of v in transpose
            if (!visited[neigh]) { // If neighbor not visited
                dfs2(neigh); // Recursive DFS on neighbor
            }
        }
    }

    /**
     * Public method to check if graph is strongly connected.
     * 
     * @return true if the graph has exactly one SCC, false otherwise
     */
    public boolean isStronglyConnected() {
        // Step 1: Perform DFS on original graph from all unvisited vertices, fill stack
        Arrays.fill(visited, false); // Reset visited array to false
        for (int i = 0; i < n; i++) { // Iterate over all vertices
            if (!visited[i]) { // If vertex i unvisited
                dfs1(i); // DFS from i, fill stack
            }
        }

        // Step 2: Perform DFS on transpose from stack vertices in pop order, count SCCs
        Arrays.fill(visited, false); // Reset visited array again
        int sccCount = 0; // Counter for number of SCCs
        while (!stack.isEmpty()) { // While stack has vertices
            int v = stack.pop(); // Pop top vertex (highest finish time)
            if (!visited[v]) { // If not visited
                dfs2(v); // DFS on transpose from v (one SCC)
                sccCount++; // Increment SCC count
            }
        }

        return sccCount == 1; // Strongly connected iff 1 SCC
    }

    /**
     * Main method with test cases: strongly connected and not.
     */
    public static void main(String[] args) {
        // Test case 1: Strongly connected directed cycle (0->1->2->0)
        System.out.println("=== STRONGLY CONNECTED (Full Cycle) ===");
        int[][] sccEdges = { { 0, 1 }, { 1, 2 }, { 2, 0 } }; // Edges forming cycle covering all vertices
        grp6 g1 = new grp6(3, sccEdges); // Create graph
        System.out.println("Is strongly connected: " + g1.isStronglyConnected()); // Expected: true

        System.out.println();

        // Test case 2: Not strongly connected (linear: 0->1->2, no return paths)
        System.out.println("=== NOT STRONGLY CONNECTED (Linear) ===");
        int[][] noSccEdges = { { 0, 1 }, { 1, 2 } }; // Edges forming chain
        grp6 g2 = new grp6(3, noSccEdges); // Create graph
        System.out.println("Is strongly connected: " + g2.isStronglyConnected()); // Expected: false
    }
}
