//https://leetcode.com/problems/course-schedule/
class Solution {
    public boolean canFinish(int n, int[][] pre)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean visited[]=new boolean[n];
        boolean path[]=new boolean[n];

        //construct adj list
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList());
        }

        for(int[] course: pre)
        {
            adj.get(course[0]).add(course[1]);
        }

        //perform dfs
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                boolean ans = dfsHelper(i, adj,visited, path);
                if(ans) return false;
            }
        }

        return true;

        
        
    }

    public boolean dfsHelper(int node,ArrayList<ArrayList<Integer>> adj,boolean[] visited,boolean[] path )
    {
        //mark the node as visited and put it path
        visited[node] =true;
        path[node] = true;

        for(Integer child:adj.get(node))
        {
            if(path[child]) return true;

            if(!visited[child])
            {
                boolean ans = dfsHelper(child,adj,visited,path);
                if(ans) return true;

            }
        }

        path[node] = false;
        return false;
    }
}
