package algo.SpellChecker;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import com.util.inputFileTest;

import algo.SpellChecker.DataStructure.Edge;
import algo.SpellChecker.DataStructure.Node;

public class RadixTree {
	
	Hashtable<String,Integer> dictionary = new Hashtable <String, Integer>();
	Node root= new Node();
	Node SuccessorNode = null; 
	String MatchedPrefix="";
	String MatchedWord="";
	HashMap<Integer, ArrayList<String>> SuggestedWords= new HashMap<Integer, ArrayList<String>>();
			
	public void insert ( Node node, String input ){
		if (node.isLeaf==true){
			node.edges = new Edge[]{new Edge (new Node(), input)};
			node.isLeaf=false;
		}
		else
		{
			Edge commonPrefixEdge = SearchEdge(node.edges, input);
			if (commonPrefixEdge==null)
			{
				Edge[] updatedEdges = new Edge[node.edges.length+1];
				int i=0;
				for(Edge edge :node.edges){
					updatedEdges[i]= edge;
					i++;
				}
				updatedEdges[node.edges.length]=new Edge(new Node(), input);
				node.edges=updatedEdges;
			}
			else
			{
				String lablePrefix= getCommonPrefix(input , commonPrefixEdge.label);
				if (lablePrefix.length()< commonPrefixEdge.label.length()){
					Edge suffixLableEdge=null;
					if (commonPrefixEdge.targetNode.isLeaf==true)
					{
						suffixLableEdge= new Edge(new Node(),commonPrefixEdge.label.substring(lablePrefix.length(), commonPrefixEdge.label.length()));
					}
					else 
					{
						suffixLableEdge= new Edge(commonPrefixEdge.targetNode,commonPrefixEdge.label.substring(lablePrefix.length(), commonPrefixEdge.label.length()));
					}
					Edge newEdge = new Edge( new Node(), input.substring(lablePrefix.length()));
					commonPrefixEdge.targetNode= new Node(new Edge[]{suffixLableEdge, newEdge},false);
					commonPrefixEdge.label=lablePrefix;
				}else 
				if (lablePrefix.length()==commonPrefixEdge.label.length())
				{
					//if (edge.targetNode.isLeaf==true){
						insert(commonPrefixEdge.targetNode, input.substring(lablePrefix.length()));
					//}
				}
			}
		}
	}
	
	private Edge SearchEdge(Edge[] edges, String input) {
		int max=0;
		Edge commonEdge= null; 
		for(Edge edge : edges){
			int i=0;
			while ( i<edge.label.length()&& i<input.length())
			{
				if(edge.label.charAt(i) ==input.charAt(i))
					i++;
					if(i>max)
					{	
						max=i; 
						commonEdge= edge;
					}
				else 
					break;
			}
		}
		return commonEdge;
	}

	private String getCommonPrefix(String searchInput, String text ) 
	{
		int i=0;
		while ( i<searchInput.length()&& i<text.length())
		{
			if(searchInput.charAt(i) ==text.charAt(i))
				i++;
			else 
				break;
		}
		if (i>=0) 
			return searchInput.substring(0, i);
		else 
			return null;
	}
	
	public void PrintTree(Node currentNode) 
	{	
		if(currentNode.edges!=null){
			for(Edge edge: currentNode.edges)
			{
				System.out.print("\t"+ edge.label);
				if (edge.targetNode!=null)
				{
					PrintTree(edge.targetNode);
				}
			}
		}
	}
	
	//lookup
	public boolean lookup(String x)
	{
		// Begin at the root with no elements found
		Node traverseNode = root;
		int elementsFound = 0;
		
		// Traverse until a leaf is found or it is not possible to continue
		while (traverseNode != null && !traverseNode.isLeaf && elementsFound < x.length())
		{
			// Get the next edge to explore based on the elements not yet found in x
			Edge nextEdge = findEdge(traverseNode, x.substring(elementsFound,x.length()));// elementsFound);//=select edge from traverseNode.edges where edge.label is a prefix of x.suffix(elementsFound)
						// x.suffix(elementsFound) returns the last (x.length - elementsFound) elements of x
			
		    // Was an edge found?
		    if (nextEdge != null)
		    {
		    	// Set the next node to explore
		    	traverseNode= nextEdge.targetNode;
		    
		    	// Increment elements found based on the label stored at the edge
		    	elementsFound += nextEdge.label.length();
		    	// MatchedWord Before
		    	MatchedWord+=nextEdge.label;
		    }
		    else
		    {
		    	SetSuccessorInfo(traverseNode, x.substring(0, elementsFound));
		    	// Terminate loop
		    	traverseNode= null;
		    }
		}
		// A match is found if we arrive at a leaf node and have used up exactly x.length elements
		return (traverseNode != null && traverseNode.isLeaf && elementsFound == x.length());
	}	
	
	private void SetSuccessorInfo(Node traverseNode, String matchedPrefix) {
		this.SuccessorNode=traverseNode;
		this.MatchedPrefix= matchedPrefix;
	}

	private Edge findEdge(Node traverseNode, String x) {
		int max=0;
		Edge commonEdge= null; 
		for(Edge nextEdge : traverseNode.edges)
		{
			int i=0;
			while ( i<nextEdge.label.length() && i<x.length())
			{
				if(nextEdge.label.charAt(i) ==x.charAt(i))
				{	
					if(i>=max)
					{	
						max=i; 
						commonEdge= nextEdge;
					}
					else 
						break;
					i++;
				}
				else
				{
					break;
				}
			}
		}
		return commonEdge;
	}

	public HashMap<Integer, ArrayList<String>> GetSuccessorWords(Node successorNode, String prefix, int inputLength)
	{	
		for (Edge edge : successorNode.edges)
		{ 
			String word= prefix+edge.label;
			if( edge.targetNode.isLeaf== true || dictionary.containsKey(word))// && (word.length()>=inputLength-2 || word.length()<=inputLength+2))
			{
				if (SuggestedWords.containsKey(word.length())){
					SuggestedWords.get(word.length()).add(word);}
				else{
					ArrayList<String> list = new ArrayList<String>();
					list.add(word );
					SuggestedWords.put(word.length(),list);
				}
			}else 
			{
				GetSuccessorWords(edge.targetNode, word,inputLength);
			}
		}
		return SuggestedWords;
	}
	
	//delete
	public void delete(){
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RadixTree tree = new RadixTree();
		String[] inputs= new String[]{"AOL","Aachen","Aaliyah","Aaron","Abbas","Abbasid","Abbott"};
		for (String input : inputs){
			System.out.println(" Input: " +input );
			tree.insert(tree.root,input);
			tree.PrintTree(tree.root);
			System.out.println();
		}
	}
	
	// Insert
		public void insert(Node node, String input, String prefix)
		{	
			boolean newBranchCreated= false;
			//if node has no edges create first edge with string 
			if(node.edges==null && node.isLeaf==true)
			{	
				node.edges= new Edge[] {new Edge(new Node(),input)};
				node.isLeaf=false;
			}
			else{
				int i=0;
				while ( i<node.edges.length )
				{
					Edge currentEdge= node.edges[i];
					String newPrefix=getCommonPrefix(input, prefix+currentEdge.label);
					if (newPrefix.equals(""))
					{
						newBranchCreated= true;
					} 
					else if ( newPrefix.equals(currentEdge.label))
					{
						if (currentEdge.targetNode.isLeaf==true){
							currentEdge.targetNode.edges= new Edge[]{new Edge(new Node(), input.substring(newPrefix.length(), input.length()))};
						}else {
							insert(currentEdge.targetNode ,input,newPrefix);
						}
						newBranchCreated= false;
					}else 
					{
						if (newPrefix!=null);
						{	
							newBranchCreated= false;
							String suffix = currentEdge.label.substring(newPrefix.length(), currentEdge.label.length());
							
							Edge newEdge = new Edge(new Node(), input.substring(newPrefix.length(), input.length()));	
							
							if (suffix.equals("")){
								currentEdge.targetNode.edges= new Edge[]{newEdge};
							}
							else {
								Edge suffixEdge = new Edge(new Node(),suffix);;
								if (currentEdge.targetNode.isLeaf==false)
								{	
									suffixEdge.targetNode= currentEdge.targetNode;
								}
								currentEdge.targetNode = new Node(new Edge[]{suffixEdge, newEdge}, false);
							}
							currentEdge.label= newPrefix;
						}
					}
					i++;
				}
				if (newBranchCreated==true)
				{
					Edge[] edges = new Edge[node.edges.length+1];
					int j=0;
					for(Edge edge : node.edges){
						edges[j]= edge;
						j++;
					}
					edges[j]=new Edge(new Node(),input );
					node.edges= edges;
					newBranchCreated= true;
				}
			}
		}

		

}
