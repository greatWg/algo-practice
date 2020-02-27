package algo.graph.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphTree {
	
	Node rootnode;
	ArrayList<Node> nodes= new ArrayList<Node>();
	int[][] adjMatrix;
	int size;
	
	public void setRootNode(Node n){
		  this.rootnode=n;
	}
	
	public Node getRootNode(){
		return this.rootnode;
	}
	
	public  void addNode(Node n){
		nodes.add(n);
	}
	
	public void connectNode(Node start, Node end){
		//initialize adjMatrix
		if (adjMatrix==null){
			size= nodes.size();
			adjMatrix= new int[size][size];
		}
		
		int startIndex= nodes.indexOf(start);
		int endIndex= nodes.indexOf(end);
		adjMatrix[startIndex][endIndex]=1;
		adjMatrix[endIndex][startIndex]=1;
	}
	
	//retrieve unvisited child node
	public Node getUnvisitedChildNode(Node n){
		
		int index= nodes.indexOf(n);
		int j=0;
		while(j<size){
			if(adjMatrix[index][j]==1 && ((Node)nodes.get(j)).visited==false){
				return (Node)nodes.get(j);
			}
			j++;
		}
		return null;
	}
	  
	//Utility methods for clearing visited property of node
	private void clearNodes()
    {
		int i=0;
        while(i<size)
        {
        	Node n=(Node)nodes.get(i);
        	n.visited=false;

        	i++;
        }
     }
	
     //Utility methods for printing the node's label
	private void printNode(Node n)
	{
		System.out.print(n.label+" ");
	}  
	
	/**
	 * Breadth First Search Traversal: Queue
	 */
	private void BFSTraversal( ){
		//Use Queue as data structure
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(this.rootnode);
		printNode(this.rootnode);
		this.rootnode.visited=true;
		while(!queue.isEmpty()){
			Node n=(Node)queue.remove();
			Node child=null;
			while( (child=getUnvisitedChildNode(n))!=null){
				child.visited=true;
				printNode(child);
				queue.add(child);
			}
		}
		//clear visited property of nodes
		clearNodes();
	
	}
	/**
	 * Depth First Search Traversal:
	 */
	private void DFSTraversal(){
		Stack<Node> stack= new Stack<Node>();
		stack.push(this.rootnode); //push() : Pushes an item onto the top of this stack
		rootnode.visited= true;
		printNode(this.rootnode);
		while (!stack.empty()){
			Node n=(Node) stack.peek();//peek(): Looks at the object at the top of this stack without removing it from the stack.
			Node child=getUnvisitedChildNode(n);
			if(child!= null){
				child.visited=true;
				printNode(child);
				stack.push(child);
			}else
			{
				stack.pop(); //pop(): Removes the object at the top of this stack and returns that object as the value of this function.
			}
		}
		clearNodes();
	}
	
	public static void main(String[] args){
		 //Lets create nodes as given as an example in the article
	     Node nA=new Node('A');
	     Node nB=new Node('B');
	     Node nC=new Node('C');
	     Node nD=new Node('D');
	     Node nE=new Node('E');
	     Node nF=new Node('F');
	 
	     //Create the graph, add nodes, create edges between nodes
	     GraphTree g=new GraphTree();
	     g.addNode(nA);
	     g.addNode(nB);
	     g.addNode(nC);
	     g.addNode(nD);
	     g.addNode(nE);
	     g.addNode(nF);
	     g.setRootNode(nA);
	     
	     g.connectNode(nA,nB);
	     g.connectNode(nA,nC);
	     g.connectNode(nA,nD);
	     
	     g.connectNode(nB,nE);
	     g.connectNode(nB,nF);
	     //g.connectNode(nC,nF);
	     
	     System.out.println ("------A-----");

	     System.out.println ("--B---C---D--");

	     System.out.println ("-E--F--------");
	     //Perform the traversal of the graph
	     System.out.println("DFS Traversal of a tree is ------------->");
	     g.DFSTraversal();
	     
	     System.out.println("\nBFS Traversal of a tree is ------------->");
	     g.BFSTraversal();
    }
}
