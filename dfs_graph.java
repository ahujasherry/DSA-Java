import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BuyAndSell
{


    public static void main(String[] args)
    {
        List<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            adj.add(new ArrayList<>());

        }

        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);

        ArrayList < Integer > ans = dfsOfGraph(5, adj);
        int n = ans.size();
        for(int i = 0;i<n;i++) {
            System.out.print(ans.get(i)+" ");
        }



    }

    private static ArrayList<Integer> dfsOfGraph(int V, List<ArrayList<Integer>> adj)
    {
        boolean visited[]= new boolean[V+1];
        visited[0] = true;
        ArrayList<Integer>  ans  =  new ArrayList<>();
        dfs(0, adj, visited,ans);
        return ans;
    }

    private static void dfs(int node, List<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> list)
    {

        visited[node] = true;
        list.add(node);

        for (Integer child: adj.get(node))
        {
            if(!visited[child])
            {
                dfs(child, adj, visited, list);
            }



        }


    }


}
