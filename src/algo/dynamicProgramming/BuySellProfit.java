package algo.dynamicProgramming;

public class BuySellProfit {
    public int maxProfit(int[] prices) {
        //int minPrice = Integer.MAX_VALUE;
        int n = prices.length;
        int maxProfit= 0;

        for (int i=1;i<n; i++){
            if(prices[i]> prices[i-1]){
                maxProfit += prices[i]- prices [i-1];
                System.out.println( "maxProfit " + maxProfit +  " when i:  " +i );
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BuySellProfit bsp= new BuySellProfit();
        System.out.println ( " #### Expected: " + (5-1) + " actual : " +  bsp.maxProfit(new int [] {1,2,3,4,5}) + " ####");

    }
}
