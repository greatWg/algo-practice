package algo.graph;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

public class GraphBridges {

    private int V;
    private LinkedList<Integer> adj[];
    static final int NIL = -1;
    int time= 0;

    public GraphBridges(int v){
        V=v;
        adj = new LinkedList[V];
        int[] Vertex= new int [V];
        for (int i=0; i<V; i++){
            adj[i] =  new LinkedList<Integer>();
        }
    }

    private void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);

    }

    void DFSBridges(int u, int[] parent, int[] low, int[] disc, boolean[] visited){


        visited[u]= true;
        Iterator<Integer> list= adj[u].iterator();
        low[u]= disc[u] =  ++time;

        while (list.hasNext()){
            int v= list.next();

            if (!visited[v]){

                parent[v]= u;
                DFSBridges(v, parent, low, disc, visited);

                low[u] = Math.min(low[u], low[v]);

                if (disc[u] < low[v]){
                    System.out.println("edge: {"+u + " "+ v + "}" );
                }
            }
            else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

    }

    void Bridges(){
        boolean visited[] = new boolean[V];
        int low[]= new int[V];
        int disc[] = new int [V];
        int parent[] = new int [V];
        int bridges[] = new int [V];

        for ( int i=0; i<V; i++){
            parent[i]=NIL;
            visited[i]= false;
        }

        for ( int i=0; i<V; i++){
            if(visited[i]== false){
                DFSBridges(i, parent, low, disc, visited);
            }
        }
    }

    public static void main(String args[]){

        //https://www.geeksforgeeks.org/bridge-in-a-graph/?ref=lbp
        System.out.println("Bridge for graph one");

        GraphBridges g1 = new GraphBridges(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        g1.Bridges();
        System.out.println();

        System.out.println("Bridge in Second graph");
        GraphBridges g2 = new GraphBridges(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        g2.Bridges();
        System.out.println();

        System.out.println("Articulation points in Third graph ");
        GraphBridges g3 = new GraphBridges(7);
        g3.addEdge(0, 1);
        g3.addEdge(1, 2);
        g3.addEdge(2, 0);
        g3.addEdge(1, 3);
        g3.addEdge(1, 4);
        g3.addEdge(1, 6);
        g3.addEdge(3, 5);
        g3.addEdge(4, 5);
        g3.Bridges();
        System.out.println();

        //https://leetcode.com/discuss/interview-question/436073/
        System.out.println("Articulation points in Fourth graph ");
        GraphBridges g4 = new GraphBridges(7);
        g4.addEdge(0, 1);
        g4.addEdge(0, 2);
        g4.addEdge(2, 3);
        g4.addEdge(1, 3);
        g4.addEdge(2, 5);
        g4.addEdge(5, 6);
        g4.addEdge(3, 4);
        g4.Bridges();
        System.out.println();

        System.out.println("Articulation points in Fifth graph ");
        //https://www.hackerearth.com/practice/algorithms/graphs/articulation-points-and-bridges/tutorial/
        GraphBridges g5 = new GraphBridges(6);
        g5.addEdge(0, 1);
        g5.addEdge(0, 5);
        g5.addEdge(1, 3);
        g5.addEdge(2, 1);
        g5.addEdge(3, 4);
        g5.addEdge(2, 3);
        g5.addEdge(2, 4);
        g5.Bridges();

    }
}
