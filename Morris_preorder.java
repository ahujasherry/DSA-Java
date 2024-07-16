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
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) 
    {
        List<Integer> ans = new ArrayList();
        TreeNode curr= root;

        while(curr!=null){

            //if no left subtree, print and go to right
            if(curr.left==null)
            {
                ans.add(curr.val);
                curr = curr.right;
            }else{
                //find rightmost and create connectio with curr
                TreeNode prev = curr.left;
                while(prev.right!=null && prev.right!=curr)
                {
                    prev = prev.right;
                }

                //first time, create thread
                if(prev.right==null)
                {
                    prev.right = curr;
                    ans.add(curr.val);
                    curr= curr.left;
                }else{
                    //remove connection, left subtree already visited
                    curr= curr.right;
                }

            }
        }

        return ans;
        
    }
}
