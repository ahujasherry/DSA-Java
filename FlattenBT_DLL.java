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

//Convert BT into DLL usign in order and in space. Treat next, prev pointers as right, left of the tree
class Solution {
    
    TreeNode prev = null;
    TreeNode head = null;
    public void flatten(TreeNode root) 
    {
        if(root==null) return root;

        flatten(root.left);

        if(prev==null) head= prev;
        else{
            root.left= prev;
            prev.right = root;
        }

        prev = head;

        flatten(root.right);
        
    }
}
