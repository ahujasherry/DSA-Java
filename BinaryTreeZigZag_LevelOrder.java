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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        List<List<Integer>> zigZag = new ArrayList<>();
        if (root == null)
            return zigZag;

        traverse(root, zigZag);
        return zigZag;
        
    }


    static void traverse(TreeNode node, List<List<Integer>> arr) 
    {
		/* if tree has only root node */
        if (node.left == null && node.right == null) {
            ArrayList<Integer> sub = new ArrayList<>();
            sub.add(node.val);
            arr.add(sub);
            return;
        }


		/* 
				Initialize the queue used to traverse bfs
		*/
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(node);
        int level = 0;

        while (!q.isEmpty()) 
        {
		
            int size = q.size();
            ArrayList<Integer> sub = new ArrayList<>();

            for (int i = 0; i < size; i++) 
            {
                TreeNode n = q.poll();
                if (n.left != null)     q.add(n.left);
                if (n.right != null)    q.add(n.right);
                sub.add(n.val);
                
            }
			
            /* 
				check if current level is odd or even :
				if it is odd then reverse the sub list and add to our answer
			*/
            if (level % 2 != 0)     Collections.reverse(sub);
            
            arr.add(sub);
            level++;
        }
    }
}
