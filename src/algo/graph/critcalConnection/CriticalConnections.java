package algo.graph.critcalConnection;

import java.util.*;

public class CriticalConnections {


	int[]low ,disc;
	int time=1;
	List<List<Integer>> ans = new ArrayList<>();
	Map<Integer,List<Integer>> edgeMap = new HashMap<>();
	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		disc = new int[n];
		low = new int[n];
		for (int i = 0; i < n; i++){
			edgeMap.put(i, new ArrayList<Integer>());
		}
		for (List<Integer> conn : connections) {
			int u = conn.get(0); int v = conn.get(1);
			edgeMap.get(u).add(v);
			edgeMap.get(v).add(u);
		}
		dfs(0, -1);
		return ans;
	}
	// prev - curr -- next Node in tree
	public void dfs(int curr, int prev) {
		disc[curr] = low[curr] = time++;
		for (int next : edgeMap.get(curr)) {
			// tree edge == node not visited
			if (disc[next] == 0) {
				dfs(next, curr);
				low[curr] = Math.min(low[curr], low[next]);
			} // Back edge == node visited
			else if (next != prev)
				low[curr] = Math.min(low[curr], disc[next]);
			// if discovery < low
			if (low[next] > disc[curr])
				ans.add(Arrays.asList(curr, next));
		}
	}

	/***
	 * Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
	 * Output: [[1,3]]
	 * Explanation: [[3,1]] is also accepted.
	 * @param args
	 */
	public static void main(String[] args ){
		CriticalConnections connections = new CriticalConnections();
		List<List<Integer>> conns= new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		list.add(0);list.add(1);
		conns.add(list);
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);list1.add(2);
		conns.add(list1);

		List<Integer> list2 = new ArrayList<>();
		list2.add(2);list2.add(0);
		conns.add(list2);

		List<Integer> list3 = new ArrayList<>();
		list3.add(1);list3.add(3);
		conns.add(list3);
		List<List<Integer>> res= connections.criticalConnections(4,conns);

		for (List<Integer> curr: res){
			System.out.print("[");
			for (int c: curr){
				System.out.print(c +" ,");
			}
			System.out.print("] ,");
		}
	}
	
}
