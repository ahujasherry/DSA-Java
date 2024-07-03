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
    public List<Integer> rightSideView(TreeNode root) {
         Queue<TreeNode> queue = new ArrayDeque<>();
        
        if(root!=null)
            queue.add(root);

        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty())
        {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++)
            {
                TreeNode frontNode = queue.poll();
                if(i==0) ans.add(frontNode.val);

                if(frontNode.left!=null) queue.add(frontNode.left);
                if(frontNode.right!=null) queue.add(frontNode.right);

            }
        }

        return  ans;
    }
}
