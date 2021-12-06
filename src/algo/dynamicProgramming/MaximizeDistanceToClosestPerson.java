package algo.dynamicProgramming;

public class MaximizeDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        // At least one seat is empty and one seat is occupied
        // there for at least max distance ==1
        int maxDistance=1 ;
        int tempDistance=0;
        if (seats.length == 2 ){
            return maxDistance;
        }
        else{
            int start=0 ;
            int end= 0;
            boolean seatExists= false;
            int i=0;
            while (i<seats.length )
            {
                if (seats[i]== 1 && seatExists== false){
                    start= i;
                    seatExists= true;
                    if (i!=seats.length-1)
                    {
                        maxDistance=  tempDistance%2 == 0?
                                Math.max(maxDistance, (tempDistance)/2)
                                :Math.max(maxDistance, (tempDistance+1)/2);
                        tempDistance =0;
                    }else{
                        maxDistance= Math.max(maxDistance, (tempDistance));
                    }
                }else if (seats[i]== 1&& seatExists==true)
                {
                    end=i;

                    maxDistance=  tempDistance%2 == 0?
                            Math.max(maxDistance, (tempDistance)/2)
                            :Math.max(maxDistance, (tempDistance+1)/2);

                    start=i;
                    seatExists= false;
                    tempDistance =0;
                }
                else{
                    tempDistance++;
                }
                i++;
            }
            maxDistance= Math.max(maxDistance, (tempDistance));
        }
        return maxDistance;

    }


    /**
     * Two Pointer [Accepted]
     * Intuition
     *
     * As we iterate through seats, we'll update the closest person sitting to our left, and closest person sitting to our right.
     *
     * Algorithm
     *
     * Keep track of prev, the filled seat at or to the left of i, and future, the filled seat at or to the right of i.
     *
     * Then at seat i, the closest person is min(i - prev, future - i), with one exception.
     * i - prev should be considered infinite if there is no person to the left of seat i,
     *
     * and similarly future - i is infinite if there is no one to the right of seat i
     *
     * O(N)
     */
    public int maxDistToClosest_TwoPointers(int[] seats) {
        int N = seats.length;
        int prev = -1, future = 0;
        int ans = 0;

        for (int i = 0; i < N; ++i) {
           //  Keep track of prev, the filled seat at or to the left of i,
            // and future, the filled seat at or to the right of i.
            if (seats[i] == 1) {
                prev = i;
            } else {
                while (future < N && seats[future] == 0 || future < i) {
                    future++;
                }

                int left = prev == -1 ? N : i - prev;
                int right = future == N ? N : future - i;
                ans = Math.max(ans, Math.min(left, right));
            }
        }

        return ans;
    }

    /**
     *  Intuition :
     *
     *  In a group of K adjacent empty seats between two people, the answer is (K+1) / 2.
     *     //
     *     // Time Complexity: O(N)O(N), where NN is the length of seats.
     *     //
     *     //Space Complexity: O(1)O(1)
     */
    public int maxDistToClosest_GroupByZero(int[] seats) {
        int N = seats.length;
        int K = 0; //current longest group of empty seats
        int ans = 0;

        // For each group of K empty seats between two people, we can take into account the candidate answer (K+1) / 2.
        for (int i = 0; i < N; ++i) {
            if (seats[i] == 1) {
                K = 0;
            } else {
                K++;
                ans = Math.max(ans, (K + 1) / 2);
            }
        }
        //For groups of empty seats between the edge of the row and one other person,
        // the answer is K, and we should take into account those answers too.

        // The edge from front
        for (int i = 0; i < N; ++i) {
            if (seats[i] == 1) {
                ans = Math.max(ans, i);
                break;
            }
        }
        // The edge from end
        for (int i = N-1; i >= 0; --i) {
            if (seats[i] == 1) {
                ans = Math.max(ans, (N - 1 - i));
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximizeDistanceToClosestPerson mcp= new MaximizeDistanceToClosestPerson();

//        int[] input0= {1, 0, 0, 0};
//        System.out.println("  maxDistance "+ mcp.maxDistToClosest(input0));//3
//
//        int[] input1= {0, 1};
//        System.out.println("  maxDistance "+ mcp.maxDistToClosest(input1)); //1
//
//        int[] input2= {1,1,0,1,1};
//        System.out.println("  maxDistance "+ mcp.maxDistToClosest(input2)); //1
//
//
//        int[] input3= {1,0,0,0,1,0,1};
//        System.out.println("  maxDistance "+ mcp.maxDistToClosest(input3)); //2
//
//        int[] input4= {0,1,0,0,0,0};
//        System.out.println("  maxDistance "+ mcp.maxDistToClosest(input4)); //4
//
//        int[] input5= {1,1,0,0,0,1,0};
//        System.out.println("  maxDistance "+ mcp.maxDistToClosest(input5)); //2

        //int[] input6= {0,0,1,0,1,1};
        int[] input0= {1, 0, 0, 0};

        int[] input1= {0, 1};

        int[] input2= {1,1,0,1,1};

        int[] input3= {1,0,0,0,1,0,1};

        int[] input4= {0,1,0,0,0,0};

        int[] input5= {1,1,0,0,0,1,0};

        int[] input6= {0,0,1,0,1,1};


        // Calling Group by zero
        System.out.println(" Maxdistance Group by Zero "+ mcp.maxDistToClosest_GroupByZero(input0)); // 3
        System.out.println(" Maxdistance Group by Zero "+ mcp.maxDistToClosest_GroupByZero(input1)); //1
        System.out.println(" Maxdistance Group by Zero "+ mcp.maxDistToClosest_GroupByZero(input2));//1
        System.out.println(" Maxdistance Group by Zero "+ mcp.maxDistToClosest_GroupByZero(input3));//2
        System.out.println(" Maxdistance Group by Zero "+ mcp.maxDistToClosest_GroupByZero(input4)); //4
        System.out.println(" Maxdistance Group by Zero "+ mcp.maxDistToClosest_GroupByZero(input5));//2
        System.out.println(" Maxdistance Group by Zero "+ mcp.maxDistToClosest_GroupByZero(input6)); //2


        //Two Pointers
        System.out.println(" Maxdistance Two Pointers "+ mcp.maxDistToClosest_TwoPointers(input0)); //3
        System.out.println(" Maxdistance Two Pointers "+ mcp.maxDistToClosest_TwoPointers(input1)); //1
        System.out.println(" Maxdistance Two Pointers "+ mcp.maxDistToClosest_TwoPointers(input2)); //1
        System.out.println(" Maxdistance Two Pointers "+ mcp.maxDistToClosest_TwoPointers(input3)); //2
        System.out.println(" Maxdistance Two Pointers "+ mcp.maxDistToClosest_TwoPointers(input4));//4
        System.out.println(" Maxdistance Two Pointers "+ mcp.maxDistToClosest_TwoPointers(input5)); //2
        System.out.println(" Maxdistance Two Pointers "+ mcp.maxDistToClosest_TwoPointers(input6));//2



//        System.out.println("  maxDistance "+ mcp.maxDistToClosest(input0));//3
//

//        System.out.println("  maxDistance "+ mcp.maxDistToClosest(input1)); //1
//
//
//        System.out.println("  maxDistance "+ mcp.maxDistToClosest(input2)); //1
//
//
//
//        System.out.println("  maxDistance "+ mcp.maxDistToClosest(input3)); //2
//
//
//        System.out.println("  maxDistance "+ mcp.maxDistToClosest(input4)); //4
//
//
//        System.out.println("  maxDista
        System.out.println("  maxDistance "+ mcp.maxDistToClosest(input6)); //2
        //

    }

}
