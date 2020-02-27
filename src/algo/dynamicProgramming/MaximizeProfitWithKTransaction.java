package algo.dynamicProgramming;

import java.util.LinkedList;

public class MaximizeProfitWithKTransaction {
	
	public static void main (String[] args) {
		 int[] input = new int [] {10, 22, 5, 75, 65, 80};
		 
		 int prices[] = {2, 5, 7, 1, 4, 3, 1, 3};

		 int numberOfTransaction= 3;
		 MaximizeProfitWithKTransaction profit = new MaximizeProfitWithKTransaction();
//		 
//		 for (int i=0 ;i<= numberOfTransaction; i++) {
//			 System.out.println("****Profit when k"+ i+" Profit: "+ profit.maxProfit(prices, i));
//		 }
//
//		 for (int i=0 ;i<= numberOfTransaction; i++) {
//			 System.out.println("****Profit when k"+ i+" Profit: "+ profit.maxProfit(input, i));
//		 }
		 
		 //Single run time maximize Profit
		 System.out.println("Max Profit "+ profit.MaxProfitSingleTransaction(input));
		 System.out.println("Max Profit "+ profit.MaxProfitSingleTransaction(prices));
				
	}

	/**
	 * Formula:
	 * 		 T[i][j] = Math.max(T[i][j-1], prices[j] + maxDiff);
     *       maxDiff = Math.max(maxDiff, T[i-1][j] - prices[j]);
	 * @param prices : prices
	 * @param K  : number of Transactions 
	 * @return maximum profit
	 */
	public int maxProfit(int prices[], int K) {
		 System.out.println("Vlaue of K"+K);
	        if (K == 0 || prices.length == 0) {
	            return 0;
	        }
	        int T[][] = new int[K+1][prices.length];

	        for (int i = 1; i < T.length; i++) { // row
	            int maxDiff = -prices[0];
	            for (int j = 1; j < T[0].length; j++) { // column
	            	// same row previous column
	                T[i][j] = Math.max(T[i][j-1], prices[j] + maxDiff);
	                System.out.print(" Max ("+ T[i][j-1] +","+ prices[j]+"+"+maxDiff+")");
	                System.out.print(" Maxdiff ("+ maxDiff +", " + T[i-1][j] +"-"+ prices[j]+" )");
	                // max ( previous row same column - 
	                maxDiff = Math.max(maxDiff, T[i-1][j] - prices[j]);
	                System.out.println( "   ->" + T[i][j]);
	            }
	            System.out.println( "   New row" + i);
	        }
	        PrintTransaction(T);
	        printActualSolution(T, prices);
	        return T[K][prices.length-1];
	    }
	 
	private void PrintTransaction(int[][] Trans) {
		  int rows= Trans.length;
		  int columns=Trans[0].length;
		  for( int i=0; i<rows; i++) {
			  for ( int j=0; j<columns; j++) {
				  System.out.print( Trans[i][j]+ "\t");
			  } 
			  System.out.println();
		  }
		  
		
	  }

	public void printActualSolution(int T[][], int prices[]) {
	        int i = T.length - 1;
	        int j = T[0].length - 1;

	        LinkedList<Integer> stack = new LinkedList<Integer>();
	        while(true) {
	            if(i == 0 || j == 0) {
	                break;
	            }
	            if (T[i][j] == T[i][j-1]) {
	                j = j - 1;
	            } else {
	                stack.addFirst(j);
	                int maxDiff = T[i][j] - prices[j];
	                for (int k = j-1; k >= 0; k--) {
	                    if (T[i-1][k] - prices[k] == maxDiff) {
	                        i = i - 1;
	                        j = k;
	                        stack.addFirst(j);
	                        break;
	                    }
	                }
	            }
	        }
	        
	        while(!stack.isEmpty()) {
	            System.out.println("Buy at price " + prices[stack.pollFirst()]);
	            System.out.println("Sell at price " + prices[stack.pollFirst()]);
	        }

	  }

	public int MaxProfitSingleTransaction(int[] prices)
	{
		int maxProfit=0, tempProfit=0, tempBuyPrice= prices[0];
		int sellPrice=0, buyPrice=0;
		
		for (int i=1; i<prices.length; i++) {
			
			tempProfit = prices[i] - tempBuyPrice;
			System.out.println(" (Max, Temp)Profit " + "( "+maxProfit +","+tempProfit+" )");
			maxProfit = Math.max( maxProfit, tempProfit);

			if (maxProfit == tempProfit ) {
				sellPrice = prices[i];
				buyPrice= tempBuyPrice;	
				
			}	
			if (prices[i]< buyPrice && i!= prices.length-1){
				tempBuyPrice = prices[i];
			}
			System.out.print("buyPrice , sellPrice " + " ("+ tempBuyPrice+ " -->"+ sellPrice+ ")");
			System.out.print("Price[i] "+ prices[i]);
		}
		System.out.println("\n Buy at "+buyPrice + " sell at "+ sellPrice + " with MaxProfit "+ maxProfit);
		return maxProfit;
	}
}
