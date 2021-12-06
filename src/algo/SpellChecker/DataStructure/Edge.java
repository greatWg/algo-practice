package algo.SpellChecker.DataStructure;

public class Edge 
{
	public Node targetNode;
	public String label;
	
	public Edge(Node targetnode, String label)
	{
		this.label= label;
		this.targetNode= targetnode;
	}
}
