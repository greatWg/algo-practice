package algo.trees;

import java.util.*;

public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        //Edges and nodes are given

        // base cases
        if (n < 2) {
            ArrayList<Integer> centroids = new ArrayList<>();
            for (int i = 0; i < n; i++)
                centroids.add(i);
            return centroids;
        }

        // so either adjancey list or adjancy matrix need to create in order to represent tree
        //HashMap<Integer,e>
         List<Set<Integer>> adjancie= new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            adjancie.add(new HashSet<>());
        }
        // add adjancies in each not
        for(int[] edge: edges){
            adjancie.get(edge[0]).add(edge[1]);
            adjancie.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves= new ArrayList<>();
        for(int i=0;i<adjancie.size(); i++ ){
           if (adjancie.get(i).size()==1){
               leaves.add(i);
           }
        }

        // Trim the leaves until reaching the centroids
        int remaingNodes= n;
        while(remaingNodes>2){
            remaingNodes-= leaves.size();
            ArrayList<Integer> newLeaves= new ArrayList<Integer>();
            // remove the current leaves along with the edges
            for(Integer leaf : leaves){
                for(Integer adj: adjancie.get(leaf)){
                    adjancie.get(adj).remove(leaf);
                    if(adjancie.get(adj).size()==1){
                        newLeaves.add(adj);
                    }
                }

            }
            leaves=newLeaves    ;

        }
       return leaves;

    }

    public static void main(String[] args) {
        MinimumHeightTrees mht= new MinimumHeightTrees();
        
        int [][] edges =  {{3,0},{3,1},{3,2},{3,4},{5,4}};
       System.out.println("expected  { 3, 4} actual : "+ mht.findMinHeightTrees(6, edges ));

        int [][] edges0 =  {{1,0},{1,2},{1,3}};
        System.out.println("expected  { 1} actual : "+ mht.findMinHeightTrees(4, edges0 ));

        int [][] edges1 =  {};
        System.out.println("expected  {0} actual : "+mht.findMinHeightTrees(1, edges1 ));

        int [][] edges2 =  {{0,1}};
        System.out.println("expected  {0,1} actual : "+mht.findMinHeightTrees(2, edges2) );
    
    }
}
