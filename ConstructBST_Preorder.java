class Solution {
    public TreeNode fun(TreeNode root, int val) 
    {
        if(root==null)
        {
            TreeNode node = new TreeNode(val);
            return node;
        }

        if(val<root.val)
        {
            root.left = fun(root.left, val);
        }else
        {
            root.right = fun(root.right,val);
        }

        return root;
        
    }

    public TreeNode bstFromPreorder(int[] preorder) 
    {
        TreeNode root = fun(null, preorder[0]);
        for (int i = 1; i < preorder.length; i++) 
        {
            fun(root, preorder[i]);
        }
        return root;
    }
}
