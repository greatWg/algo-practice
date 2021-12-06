package algo.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class AmazonOnlineTest {

    public int  LeastMinTestEffort(List<Integer> complexity, int days){
        int [][] dp = new int[days+1][complexity.size()+1];
        // maximize the complexity by finding maximum value up to including current complexity or not based on number of
        //days need to distribute the test
        for (int i=1;i<=days;i++) {
            for (int j = 1; j <= complexity.size(); j++) {
                dp[i][j]= Math.max( dp [i][j-1], dp[i-1][j-1]+ complexity.get(j-1));
            }
        }
        //printDPArray(dp);
        return dp[days][complexity.size()];
    }


    public int  LeastMinTestEffort_MinDifficulty(List<Integer> complexity, int days){
        int [][] dp = new int[days+1][complexity.size()+1];
        // maximize the complexity by finding maximum value up to including current complexity or not based on number of
        //days need to distribute the test
        for (int i=1;i<=days;i++) {
            for (int j = 1; j <= complexity.size(); j++) {
                dp[i][j]= Math.max( dp [i][j-1], dp[i-1][j-1]+ complexity.get(j-1));
            }
        }
        //printDPArray(dp);
        return dp[days][complexity.size()];
    }

    private void printDPArray(int[][] dp) {
        for (int i=0;i<dp.length; i++){
            for (int j=0;j<dp[0].length; j++){
                System.out.print (dp[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        AmazonOnlineTest testComplexity= new AmazonOnlineTest();
        List<Integer> test0= new ArrayList<Integer>();
        test0.add(1);
        test0.add(5);
        test0.add(2);
        test0.add(3);
        test0.add(4);
        System.out.println(testComplexity.LeastMinTestEffort(test0, 2));
        List<Integer> test1= new ArrayList<Integer>();
        test1.add(5);
        test1.add(6);
        test1.add(2);
        test1.add(7);
        test1.add(1);
        test1.add(8);

        System.out.println(testComplexity.LeastMinTestEffort(test1, 2));


        System.out.println(testComplexity.LeastMinTestEffort(test1, 3));

        System.out.println(testComplexity.LeastMinTestEffort(test1, 4));

        System.out.println(testComplexity.LeastMinTestEffort(test1, 5));

        System.out.println(testComplexity.LeastMinTestEffort(test1, 6));


        //

        System.out.println( "test 2 result ");
        List<Integer> test2= new ArrayList<Integer>();
        test2.add(6);
        test2.add(5);
        test2.add(4);
        test2.add(3);
        test2.add(2);
        test2.add(1);

        System.out.println(testComplexity.LeastMinTestEffort_MinDifficulty(test2, 1));
        System.out.println(testComplexity.LeastMinTestEffort_MinDifficulty(test2, 2));


        System.out.println(testComplexity.LeastMinTestEffort_MinDifficulty(test2, 3));


    }


}
