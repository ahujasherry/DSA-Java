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

//https://leetcode.com/problems/minimum-distance-between-bst-nodes/
class Solution 
{
    int prev = -1;
    int min_diff = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root)
    {
        minDiffInBSTUtil(root);
        return min_diff;
        
    }

    public void minDiffInBSTUtil(TreeNode root)
    {
        if(root==null) return ;

        minDiffInBST(root.left);

        if(prev!=-1)
        {
            min_diff = Math.min(min_diff, Math.abs(root.val - prev));
        }

        prev = root.val;

        minDiffInBST(root.right);
    }
}
