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

 class Pair 
 {
    TreeNode node; 

    int num; //represents node index 
    Pair(TreeNode _node, int _num) {
        num = _num;
        node = _node; 
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) 
    {
        if(root==null) return 0;

        Deque<Pair> queue = new LinkedList<>();
        int max=0;
        
        queue.addLast(new Pair(root, 0));

         while(!queue.isEmpty())
         {
             int size=queue.size();
             max=Math.max(max, queue.getLast().num - queue.getFirst().num+1);  
            
            
            for(int i=0;i<size;i++)
            {
                 Pair frontNode=queue.removeFirst();
                if(frontNode.node.left!=null)
                {
                    queue.addLast(new Pair(frontNode.node.left, 2*frontNode.num+1));
                }

                if(frontNode.node.right!=null) 
                {
                    queue.addLast(new Pair(frontNode.node.right, 2*frontNode.num+2));
                }

            }

         }

         return max;
        
    }
}
