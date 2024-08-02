/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution 
{
    
    
    public int maxPathSum(TreeNode root) 
    {
        int max[]=new int[1];
        max[0]=Integer.MIN_VALUE;
        maxPathSumHelper(root,max);
        return max[0];
    }
    
   
    public static int maxPathSumHelper(TreeNode root,int[] max)
    {
        if(root==null) return 0;
        
        int left=Math.max(maxPathSumHelper(root.left,max),0 );
        int right=Math.max(maxPathSumHelper(root.right,max),0 );
        
        //will track max global value including root
        int pathSumIncRoot = left + right + root.val;

        //update max
        max[0]=Math.max(max[0], pathSumIncRoot);
        
        //return max of left or right subtree sum including root as max path sum to parent 
        //since path can be only from one side
        return  Math.max(left,right) +root.val;
        
    }
}
