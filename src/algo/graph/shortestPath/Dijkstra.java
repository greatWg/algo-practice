 package algo.graph.shortestPath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Dijskstra algorithm
 * @author Amita
 *
 */
public class Dijkstra {
	//Dijkstra using priority queue

	public static void computePath(Vertex source){
		source.minDistance=0;
		PriorityQueue<Vertex> vertexQueue= new PriorityQueue<Vertex>();
		vertexQueue.add(source);
 		
		while (!vertexQueue.isEmpty()){
			Vertex u=vertexQueue.poll();
			
			//Visit each edge in existing adjancies
			for ( Edge e : u.adjancies ){
				Vertex v = e.target;
				double weight= e.weight;
				double distanceThroughU= u.minDistance+weight;
				
				if (distanceThroughU< v.minDistance){
					vertexQueue.remove(v);
					v.minDistance= distanceThroughU;
					v.previous=u;
					vertexQueue.add(v);
				}
			}
		}
		
	}
	
	public static List<Vertex> getShortestPathTo(Vertex target){
		List <Vertex> path=new ArrayList<Vertex>();
		
		for (Vertex vertex=target; vertex!=null ; vertex=vertex.previous){
			path.add(vertex);
		}
 		Collections.reverse(path);
 		return path;
 	}
	
	public static void main(String[] args){
		 Vertex v1= new Vertex("Red1");
		 Vertex v2= new Vertex("Green2");
		 Vertex v3= new Vertex("Purple3");
		 Vertex v4= new Vertex("Blue4");
		 Vertex v5= new Vertex("Orange5");
		 Vertex v6= new Vertex("White6");
	
		 v1.adjancies= new Edge[]{ new Edge(v2, 7), 
				 					new Edge(v3,  9),
				 					new Edge(v6,14)};
		 
		 v2.adjancies= new Edge[]{ new Edge(v3, 10), 
									new Edge(v4,  15)};

		 v3.adjancies= new Edge[]{ new Edge(v4, 11), 
				 					new Edge(v6,2)};

		 v4.adjancies= new Edge[]{ new Edge(v5, 6)};
		 
		 v5.adjancies= new Edge[]{ new Edge(v5, 0)};

		 v6.adjancies= new Edge[]{new Edge(v5,9)};
		 
		 Vertex [] vertices= { v1, v2, v3, v4, v5, v6};
		 
		 computePath(v1);
		 for (Vertex v: vertices){
			System.out.println( "distnace to v:"+ v+ ":"+ v.minDistance);
			List<Vertex> path= getShortestPathTo(v);
			System.out.println("Path: "+ path);
		 }
	}

}

