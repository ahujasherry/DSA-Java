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

    
    public boolean findTarget(TreeNode root, int k) 
    {
        return help(root, k, root);
    }
    private boolean help(TreeNode root, int k, TreeNode root2) {
        if(root == null) return false;

        //brute force
        if(find(root2, k - root.val, root))    return true;
        return help(root.left, k, root2) || help(root.right, k, root2); 
    }
    
    private boolean find(TreeNode root, int target, TreeNode org) {
        if(root == null) return false;
        if(root.val == target && root != org) return true;
        if(root.val < target)    return find(root.right, target, org);
        return find(root.left, target, org);
    }
        
    
}
