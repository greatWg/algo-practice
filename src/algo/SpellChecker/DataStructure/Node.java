package algo.SpellChecker.DataStructure;

public class Node 
{	
	public Edge[] edges= null; 
	public boolean isLeaf= false;
	
	// leaf node 
	public Node()
	{
		this.edges=null;
		this.isLeaf=true;
	}
	
	public Node(Edge[] edges, boolean isLeaf)
	{
		this.edges=edges;
		this.isLeaf=isLeaf;
	}
}
