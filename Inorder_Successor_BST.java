static node inOrderSuccessor(
    node root,
    node n)
{
     
    node succ = null;

    while (root != null) 
    {
        //potential successor
        if (root.data > n.data ) 
        {
            succ = root;

            //try smaller values
            root = root.left;
        }
        else if (n.data > root.data)
            root = root.right;
        else
            break;
    }
    return succ;
}
