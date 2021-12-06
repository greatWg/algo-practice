package algo.TrinaryTree;
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
			System.out.println("The tree does not exist");
		}
		else{
			System.out.println(root.key);
			preorder(root.left);
			preorder(root.right);
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
		
		Node n= tree.delete( root, 5);
		System.out.println( "after delete");
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
	}
	


}
