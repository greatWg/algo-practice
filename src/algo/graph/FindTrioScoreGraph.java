package algo.graph;

import java.util.*;

public class FindTrioScoreGraph {

//    products_nodes = 6
//    products_edges = 6
//    products_from = [1,2,2,3,4,5]
//    products_to = [2,4,5,5,5,6]
    public static int getMinScore(int productNodes, List<Integer> productsFrom, List<Integer> productsTo) {
        int minSum = Integer.MAX_VALUE;
        // build graph
        Map<Integer, Set<Integer>> edges= buildGraph(productsFrom, productsTo);
        // get Trio set
        Set<Set<Integer>> trioList=buildTrioSet(edges);
        // get minimum score

        // Traverse trio
        int count = 0;
        for (Set<Integer> trios : trioList) { // get a trio TRio (2, 3,  4) (1 2 3)
            count = 0;
            for (int node : trios) {
                for (int vert : edges.get(node)) { // edge.get(2) (3, 4)
                    if (!trios.contains(vert)) //1   ( trios does not have that vertices = count
                        count++;
                }
            }
            minSum = Math.min(minSum, count);
        }
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
//        int count=0;
//        for(Set<Integer> trio: trioList){ // Trio  (2, 3, 4), ( 1,2,3
//            count=0;
//            for (int node: trio){     // Trio (2, 3, 4)
//                for (int vert: edges.get(node)){ // edge.get(2) (3, 4)
//                    if(!trio.contains(vert)){ //1   ( trios does not have that vertices = count
//                        count++;
//                    }
//                }
//            }
//            minSum= Math.min(minSum, count);
//        }
//        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }

    public static Set<Set<Integer>> buildTrioSet(Map<Integer,Set<Integer>> edges) {
        Set<Set<Integer>> trioSet = new HashSet<>();

        if (edges==null ||edges.isEmpty())
            return trioSet;

        for(Integer node : edges.keySet()){                 // edges has 2 connected nodes on and on
            Set<Integer> connectedNodes1= edges.get(node);  // connected node 1
            for(Integer conNode1: connectedNodes1){
                Set<Integer> connectedNodes2= edges.get(conNode1); //connected node 2
                for (Integer conNode2: connectedNodes2) {
                    if (edges.get(conNode2).contains(node)) {
                        Set<Integer> trio = new HashSet<>();
                        trio.add(node);
                        trio.add(conNode1);
                        trio.add(conNode2);
                        trioSet.add(trio);

                    }
                }
            }
        }

        return trioSet;

    }

    public static Map<Integer,Set<Integer>> buildGraph(List<Integer> productsFrom, List<Integer> productsTo) {
        Map<Integer,Set<Integer>> edges= new HashMap<>();
        for (int i=0;i<productsFrom.size(); i++){
            int source= productsFrom.get(i);
            int target= productsTo.get(i);

            // Add mapping for source to end
            Set<Integer> vertices = edges.getOrDefault(source, new HashSet<>()); // insert source , new hashset
            vertices.add(target);
            edges.put(source,vertices );

            // Add mapping for end to source
            vertices= edges.getOrDefault(target, new HashSet<>());
            vertices.add(source);
            edges.put(target, vertices);

        }
        return edges;

    }

    public static void main(String[] args) {

/**
 5 6 -> products_nodes = 5 products_edges = 6
 1 2 -> products_from[0] = 1 products_to[0] = 2
 1 3 -> products_from[1] = 1 products_to[1] = 3
 2 3 -> products_from[2] = 2 products_to[2] = 3
 2 4 -> products_from[3] = 2 products_to[3] = 4
 3 4 -> products_from[4] = 3 products_to[4] = 4
 4 5 -> products_from[5] = 4 products_to[5] = 5

 Sample Output : 2

 Explanation:

 There are two possible trios: {1,2,3} and {2,3,4}
 The score for {1,2,3} is 0 + 1 + 1 = 2.
 The score for {2,3,4} is 1 + 1 + 1 = 3.
 **/

        Integer[] prodFrom = {1, 2, 2, 3, 4, 5};
        Integer[] prodTo = {2, 4, 5, 5, 5, 6};

        Integer[] prodFrom1 = {1, 1, 2, 2, 3, 4};
        Integer[] prodTo1 = {2, 3, 3, 4, 4, 5};

        System.out.println(3 == getMinScore(6, Arrays.asList(prodFrom), Arrays.asList(prodTo)) ? "Test 1 Passed" : "Test 1 failed");
        System.out.println(2 == getMinScore(5, Arrays.asList(prodFrom1), Arrays.asList(prodTo1)) ? "Test 2 Passed" : "Test 2 failed");
    }






}
