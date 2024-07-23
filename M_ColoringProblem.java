import java.util.*;
class Solution 
{
    public static boolean graphColoring(List < Integer > [] G, int[] color, int i, int C) 
  {
        int n = G.length;
        if (solve(i, G, color, n, C) == true) return true;
        return false;
    }
  
    private static boolean isSafe(int node, List < Integer > [] G, int[] color, int n, int col) 
  {
        for (int it: G[node]) {
            if (color[it] == col) return false;
        }
        return true;
    }
  
    private static boolean solve(int node, List < Integer > [] G, int[] color, int n, int m) 
  {
        if (node == n) return true;

        //try every color on each node
        for (int i = 1; i <= m; i++)
        {
            if (isSafe(node, G, color, n, i)) 
            {
                color[node] = i;
                if (solve(node + 1, G, color, n, m) == true) return true;
                color[node] = 0;
            }
        }
        return false;
    }
  
    public static void main(String[] args) 
  {
        int N = 4, M = 3;

        //adjancy list
        List < Integer > [] G = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            G[i] = new ArrayList < > ();
        }
        G[0].add(1);
        G[1].add(0);
        G[1].add(2);
        G[2].add(1);
        G[2].add(3);
        G[3].add(2);
        G[3].add(0);
        G[0].add(3);
        G[0].add(2);
        G[2].add(0);

        //track current color of each vertex
        int[] color = new int[N];
    
        boolean ans = graphColoring(G, color, 0, M);
        if (ans == true)
            System.out.println("1");
        else
            System.out.println("0");
    }
}
