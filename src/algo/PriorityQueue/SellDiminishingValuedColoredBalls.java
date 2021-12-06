package algo.PriorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SellDiminishingValuedColoredBalls {
    //Maths Formula - (x+1) + (x+2) + ... + (n-1) + n => (1 + 2 + 3 + ...+ (n-1) + n) - (1 + 2 + 3 + ... + (x-1) + x) => (n * (n+1)/2) - (x * (x+1)/2)
    //
    // 2 4 6 6 9 10

    //You will get the profit in this sequence -
     //       10, 9, 9, 8, 8, 7, 7, 6, 6, 6, 6, 5, 5, 5, 5, 4, 4, 4, 4, 4, 3, 3, 3

    /**
     *  // 2 4 6 6 9 10
     *
     * //You will get the profit in this sequence -
     *  10, 9, 9, 8, 8, 7, 7, 6, 6, 6, 6, 5, 5, 5, 5, 4, 4, 4, 4, 4, 3, 3, 3
     *
     * group 1 - 10 => 10
     * group 2 - 9, 9, 8, 8, 7, 7 => 2 * (9 + 8 + 7)
     * group 3 - 6, 6, 6, 6, 5, 5, 5, 5 => 4 * (6 + 5)
     * group 4 - 4, 4, 4, 4, 4 => 1 * (5)
     * group 5 - 3, 3, 3 => 1 * (3)
     *
     * @param inventory
     * @param orders
     * @return
     */
    public int maxProfit(int[] inventory, int orders) {
        //base case
        if(inventory== null || inventory.length==0)
            return 0;

        //sort in ascending order
        Arrays.sort(inventory);

        long sum=0;
        int count=1, n=inventory.length-1;

        while(orders>0){

            int diff = 0;
            int amount = 0;
            if(n-1 >= 0){
                diff = inventory[n]-inventory[n-1];
                amount = count * diff;
            }

            if(n>0 && diff>0 && orders >= amount){


                sum +=  count * findProfit(inventory[n],inventory[n-1]);
                orders -= amount;

            }else if(n == 0 || diff > 0){

                long q = orders/count;
                sum += count * findProfit(inventory[n],inventory[n]-q);
                amount = count * (int)q;
                orders -= amount;

                long r = orders % count;
                sum +=  r * (inventory[n]- q);

                orders -= r;
            }

            sum %= 1_000_000_007;
            n--;
            count++;
        }


        return (int)sum;
    }

    private long findProfit(long x, long y){
        return (x*(x+1)/2)-(y*(y+1)/2);
    }


    private PriorityQueue<Long> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    private long maxSum = 0;
    public int maxProfitDiscuss(int[] inventory, int orders) {
        if(inventory == null || inventory.length == 0 || orders == 0)
            return 0;

        for (int item : inventory)
            maxHeap.add(Long.valueOf(item));

        for (int i = 0; i < orders; i++){
            if(maxHeap.isEmpty() || maxHeap.peek() <= 0)
                continue;
            long curr = maxHeap.poll();
            maxSum+= curr;
            maxHeap.add(curr-1);
        }
        return (int)(maxSum%1000000007);
    }

    public static void main(String[] args) {
        SellDiminishingValuedColoredBalls sd= new SellDiminishingValuedColoredBalls();

        int [] inventory= new int [] {2,5};
        System.out.println("exp: 14 and actual is : " + sd.maxProfit(inventory, 4));


        int [] inventory0= new int [] {3,5};
        System.out.println("exp: 19 and actual is : " + sd.maxProfit(inventory0, 6));


        int [] inventory1= new int [] {2,8,4,10,6};
        System.out.println("exp: 110 and actual is : " + sd.maxProfit(inventory1, 20));

        int [] inventory2= new int [] {1000000000};
        System.out.println("exp: 21 and actual is : " + sd.maxProfit(inventory2, 1000000000));
        System.out.println("exp: 21 and actual is : " + sd.maxProfitDiscuss(inventory2, 1000000000));

//        int [] inventory0= new int [] {1000000000};
//        System.out.println("exp: 21 and actual is : " + sd.maxProfit(inventory0, 1000000000));
    }

}
