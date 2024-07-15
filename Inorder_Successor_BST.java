static node inOrderSuccessor(
    node root,
    node n)
{
     
    
  
    node succ = null;
 
    // Start from root and search for
    // successor down the tree
    while (root != null) 
    {
        if (n.data < root.data) 
        {
            succ = root;
            root = root.left;
        }
        else if (n.data > root.data)
            root = root.right;
        else
            break;
    }
    return succ;
}
