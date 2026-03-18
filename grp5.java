
/**
 * Program to detect cycle in undirected graph using Union-Find (Disjoint Set
 * Union) data structure.
 * Efficient for sparse graphs. Cycle exists if adding edge connects same
 * component.
 */
class UnionFind {
    private int[] parent; // Parent array for set representatives
    private int[] rank; // Rank array for union by rank optimization

    /**
     * Constructor for UnionFind.
     * 
     * @param n Number of vertices
     */
    public UnionFind(int n) {
        parent = new int[n]; // Initialize parent array of size n
        rank = new int[n]; // Initialize rank array of size n (all 0 initially)
        for (int i = 0; i < n; i++) { // Loop to set each vertex as its own parent
            parent[i] = i; // Each vertex starts in its own set
        }
    }

    /**
     * Find root parent of vertex with path compression.
     * 
     * @param x Vertex to find root for
     * @return Root parent
     */
    public int find(int x) {
        if (parent[x] != x) { // If not root (path compression)
            parent[x] = find(parent[x]); // Recursively find root and compress path
        }
        return parent[x]; // Return root
    }

    /**
     * Union two vertices by rank.
     * 
     * @param x First vertex
     * @param y Second vertex
     * @return true if already same set (cycle), false otherwise
     */
    public boolean union(int x, int y) {
        int rootX = find(x); // Find root of x
        int rootY = find(y); // Find root of y
        if (rootX == rootY) { // Same set: cycle detected
            return true; // Indicate cycle
        }
        // Merge smaller rank to larger
        if (rank[rootX] < rank[rootY]) { // Attach smaller rank rootX to rootY
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) { // Attach rootY to rootX
            parent[rootY] = rootX;
        } else { // Equal rank: attach rootY to rootX, increase rootX rank
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        return false; // No cycle
    }
}

/**
 * Graph class using DSU for cycle detection in undirected graphs.
 */
public class grp5 {
    private UnionFind dsu; // DSU instance

    /**
     * Constructor builds DSU and checks for cycles during edge addition.
     * 
     * @param n     Vertices count
     * @param edges List of undirected edges {{u,v}, ...}
     */
    public grp5(int n, int[][] edges) {
        dsu = new UnionFind(n); // Create DSU for n vertices
        boolean cycle = false; // Flag for cycle
        for (int[] edge : edges) { // Iterate each edge
            int u = edge[0]; // First endpoint
            int v = edge[1]; // Second endpoint
            if (dsu.union(u, v)) { // Attempt union; true if cycle
                cycle = true; // Set cycle flag
                break; // Early exit (cycle found)
            }
        }
        System.out.println("Cycle detected: " + cycle); // Output result
    }

    /**
     * Get DSU for further use if needed.
     */
    public UnionFind getDsu() {
        return dsu; // Return DSU instance
    }

    /**
     * Main method with test cases.
     */
    public static void main(String[] args) {
        // Test 1: No cycle (tree: 3 vertices, 2 edges)
        System.out.println("=== NO CYCLE GRAPH (Tree) ===");
        int[][] noCycleEdges = { { 0, 1 }, { 1, 2 } }; // Edges forming tree
        new grp5(3, noCycleEdges);

        // Test 2: Has cycle (triangle)
        System.out.println("=== HAS CYCLE GRAPH (Triangle) ===");
        int[][] cycleEdges = { { 0, 1 }, { 1, 2 }, { 2, 0 } }; // Triangle cycle
        new grp5(3, cycleEdges);

        // Test 3: Larger with cycle
        System.out.println("=== LARGER GRAPH WITH CYCLE ===");
        int[][] largeEdges = { { 0, 1 }, { 1, 2 }, { 2, 0 }, { 3, 4 } }; // Cycle 0-1-2, separate 3-4
        new grp5(5, largeEdges);
    }
}
