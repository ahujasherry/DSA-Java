class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) 
    {
        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        PathsUtil(root, path, ans);
        return ans;
    }
    
    public static void PathsUtil(Node root,ArrayList<Integer> path,ArrayList<ArrayList<Integer>> ans  )
    {
        if(root==null) return;
        
        path.add(root.data);
        
        if(root.left==null && root.right==null)
        {
            ans.add(new ArrayList(path));
            path.remove(path.size()-1);
            return;
        }
        
        PathsUtil(root.left, path, ans);
        PathsUtil(root.right,path,ans);
        path.remove(path.size()-1);
        
        
    }
}
