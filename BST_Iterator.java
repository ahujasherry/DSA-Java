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
class BSTIterator {

    ArrayList<Integer> list;
    int n;
    int index;

    public  void inOrder(TreeNode root)
    {
        if(root==null) return;

        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);

    }


    public BSTIterator(TreeNode root) 
    {
        list= new ArrayList<>();

        inOrder(root);

        index=-1;
        n = list.size();
        System.out.println("s -"+n);
    }
    
    public int next() 
    {
        return list.get(++index);
    }
    
    public boolean hasNext() 
    {
        if(index +1 < n) return true;
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
