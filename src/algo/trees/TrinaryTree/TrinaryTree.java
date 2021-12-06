package algo.trees.TrinaryTree;
public class TrinaryTree 
{	
	Node root = null;
	Node current;
	Node parent;
	
	//insert node in tree
	public void insert(Node node, int value)
	{
		// if value is less than current node value then search correct position in left tree. 
		if (value< node.key)
		{
			 if(node.left ==null){
				 node.left= new Node(value);
			 }
			 else{
				 insert (node.left, value);
			 } 
		}
		// if value is equal current node value then set value for current node.
		else if (value ==node.key)
		{
			 if (node.middle ==null){
				node.middle = new Node(value);
			 }
			 else {
				 insert(node.middle, value);
			 }
		}
		// if value is greater than current node value then search correct position in right tree.
		else
		{
			 if(node.right ==null){
				 node.right= new Node(value);
			 }
			 else{
				 insert (node.right, value);
			 } 
		}
	}
	// Delete node from the tree. 
	public Node delete(Node node, int value )
	{
		 if (node == null) 
		 {
			 System.out.println("The tree  does not have value "+ value);
			 
		 }
		 //if value is less than current node value then search the node for deletion in left subtree of current node. 
		 else if (value < node.key) 
		 {
			 node.left = delete( node.left, value);
		 } 
		 //if value is greater than current node value then search the node for deletion in right subtree of current node.
		 else if (value > node.key)
		 {
			 node.right = delete( node.right, value);
		 } 
		//if value is equal current node value then delete the correct node and reconstruct tree.
		 else
		 {
			 if (node.middle != null) 
			 {
				 node.middle = delete( node.middle,value);
			 } 
			 if (node.right != null) 
			 {
				 node.key = minValue(node.right).key;
				 node.right = delete(node.right,minValue(node.right).key);
			 } 
			 else
			 {
				 node = node.left;
			 }
		 }
		 return node;
	}
	
	//Find the correct minimum value in right subtree of root node.
	public Node minValue(Node node) 
	 {
		
         if (node!= null){
        	 while(node.left!=null){
        		return minValue(node.left);
        	 }
         } 
         return node;
	 }
   
	private void preorder(Node root )
	{
		if (root==null)
		{
			//System.out.println("The tree does not exist");
		}
		else{
			System.out.print(root.key + "  ");
			preorder(root.left);
			preorder(root.right);
		}
	}

    private void inOrder(Node root )
    {

        if (root !=null){
            inOrder(root.left);
            System.out.print( root.key + " " );
            inOrder(root.right);
        }
    }


    private void postOrder(Node root) {
        if (root !=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print( root.key + " " );
        }

    }


    /**
	 * @param args
	 */
	public static void main(String[] args) {

		TrinaryTree tree= new TrinaryTree();
		
		//Insert root node
		Node root =  new Node (5);
		tree.insert(root, 4);
		tree.insert(root, 9);
		tree.insert(root, 5);
		tree.insert(root, 11);
		tree.insert(root, 7);
		tree.insert(root, 2);
		tree.insert(root, 2);

        System.out.println("The preOrder tree traversal " ); // 5 4 2 9 7 11
        tree.preorder(root);
        System.out.println(" " );



		Node n= tree.delete( root, 5);
		System.out.println( "  after delete");
		tree.preorder(root);
		
		n= tree.delete(root, 1);
		System.out.println( "after delete");
		tree.preorder(root);
		
//		n= tree.delete( root, 2);
//		System.out.println( "after delete");
//		tree.preorder(root);
//		
//		n= tree.delete( root, 11);
//		System.out.println( "after delete");
//		tree.preorder(root);



        TrinaryTree tree1 = new TrinaryTree();

        //         1
        //       /   \
        //      2     3
        //    /   \
        //   4     5
        tree1.root= new Node (1);
        tree1.root.left = new Node(2);
        tree1.root.right = new Node(3);
        tree1.root.left.left = new Node(4);
        tree1.root.left.right = new Node(5);

        System.out.println("\n The IN ORDER tree traversal Left  Root Right" ); // 4 2 5 1 3
        tree.inOrder(tree1.root);
        System.out.println(" " );

        System.out.println("\n The PRE ORDER tree traversal  Root left Right" ); // 1  2  4  5  3
        tree.preorder(tree1.root);
        System.out.println(" " );

        System.out.println("\n The POST ORDER tree traversal  left right root  " ); // 4 5 2 3 1
        tree.postOrder(tree1.root);
        System.out.println(" " );
	}



}
