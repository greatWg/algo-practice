package algoPS1;

import java.util.HashSet;

public class MaximalNetworkRank {

     // Runtime == o(n^2) - second for loop
    public int maximalNetworkRank(int n, int[][] roads) {
        HashSet[] graph = new HashSet[n];
        int[] degree = new int[n];
        for(int i = 0;i<n;i++){
            graph[i] = new HashSet<>();
        }
        for(int i = 0;i<roads.length;i++){
            graph[roads[i][0]].add(roads[i][1]);
            graph[roads[i][1]].add(roads[i][0]);
            degree[roads[i][0]]++;
            degree[roads[i][1]]++;
        }

        int max = 0;
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                int curr = degree[i] + degree[j];
                if(graph[j].contains(i))
                    curr--;
                max = Math.max(max,curr);
            }
        }
        return max;
    }

    public static void main (String[] args){


//        5536. Maximal Network Rank
//        Input: n = 4, roads = [[0,1],[0,3],[1,2],[1,3]]
//        Output: 4
//        Explanation: The network rank of cities 0 and 1 is 4 as there are 4 roads that are connected to either 0 or 1. The road between 0 and 1 is only counted once.
//
//        Input: n = 5, roads = [[0,1],[0,3],[1,2],[1,3],[2,3],[2,4]]
//        Output: 5
//        Explanation: There are 5 roads that are connected to cities 1 or 2.
//
//        Input: n = 8, roads = [[0,1],[1,2],[2,3],[2,4],[5,6],[5,7]]
//        Output: 5
//        Explanation: The network rank of 2 and 5 is 5. Notice that all the cities do not have to be connected.

        // Hint : Try every pair of different cities and calculate its network rank.
        // The network rank of two vertices is almost the sum of their degrees.
        // How can you efficiently check if there is a road connecting two different cities?
    }


}
