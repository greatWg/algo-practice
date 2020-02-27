package algo.SpellChecker.DataStructure;

public class Edge 
{
	public Node targetNode;
	public String lable;
	
	public Edge(Node targetnode, String lable)
	{
		this.lable= lable;
		this.targetNode= targetnode;
	}
}
