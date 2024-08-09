import java.util.*;

public class BipartiteGraph {

    // Function to check if the graph is bipartite using BFS
    public static boolean isBipartite(int V, List<List<Integer>> adj) {
        // Array to store color assignments: -1 (not colored), 0 (one color), 1 (another color)
        int[] color = new int[V];
        Arrays.fill(color, -1); // Initialize all nodes as uncolored

        // Check each component of the graph
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!bfsCheckBipartite(i, adj, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    // BFS to check for bipartiteness
    private static boolean bfsCheckBipartite(int start, List<List<Integer>> adj, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 0; // Start coloring the starting node with color 0

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int currentColor = color[node];
            int nextColor = 1 - currentColor; // Alternate color

            for (int neighbor : adj.get(node)) {
                if (color[neighbor] == -1) {
                    // If the neighbor is not colored, color it with the alternate color
                    color[neighbor] = nextColor;
                    queue.add(neighbor);
                } else if (color[neighbor] == currentColor) {
                    // If the neighbor has the same color, the graph is not bipartite
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Example usage
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges (0-1, 1-2, 2-3, 3-0)
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(0);
        adj.get(0).add(3);

        if (isBipartite(V, adj)) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
    }
}
