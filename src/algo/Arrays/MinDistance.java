package algo.Arrays;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class MinDistance {



    /**
     *  O (N^2) as two for loop for searching one over the other variable
     * @param arr
     * @param x
     * @param y
     * @return
     */
    private static int minDistance(int[] arr, int x, int y) {

        int minD= Integer.MAX_VALUE;
        int N = arr.length;
        for (int i=0; i<N; i++){
            for(int j=i+1; j<N; j++)
            if ((x == arr[i] && y == arr[j] || y == arr[i] && x == arr[j]) && minD > Math.abs(i - j)) {
                 minD=Math.abs(i - j);
            }
        }
        return minD;
    }

    private static int minDistance_N_runtime(int[] arr,int  X, int Y){
        int n = arr.length;
        int min_dist= Integer.MAX_VALUE;
        int i=0, j=0;

        while(i < n && j < n)
        {
            if(arr[i] == X) //if we get X
            {
                while( j < n && arr[j] != Y) // we simply loop till we get Y
                    j++;
                if(j < n && arr[j] == Y)
                    min_dist = Math.min(min_dist,Math.abs(i-j));//we update the minimum distance if required
                i = j; // important step because as we got X,Y pair we can stand at present position and loop forward for another pair
            }
            else if(arr[i] == Y)
            {
                while( j < n && arr[j] != X)
                    j++;
                if(j < n && arr[j] == X)
                    min_dist = Math.min(min_dist,Math.abs(i-j));
                i = j;
            }
            else
                i++;
        }
        return  min_dist;
    }

    public static void main(String[] args) {
        MinDistance min= new MinDistance();
        int[] input= {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
        int[] search= {3, 6};

        System.out.println(" ###### run time O(N)  #########");

        long start =System.nanoTime();
        int dist=  minDistance( input, search[0], search[1]);
        long end =System.nanoTime();
        System.out.println("3 6expected : " + 4 + " actual:  "+ dist + "  time : "+ (end-start) );

        start =System.nanoTime();
        dist=  minDistance( input, 3, 5);
        end =System.nanoTime();
        System.out.println(" 3 5 --> expected : " + 1 + " actual:  "+ dist + "  time : "+ (end-start));

        System.out.println(" ###### run time O(N)  #########");

        start =System.nanoTime();
        dist=  minDistance_N_runtime( input, 3, 6);
        end =System.nanoTime();
        System.out.println(" 3 5 --> expected : " + 1 + " actual:  "+ dist + "  time : "+ (end-start));

        start =System.nanoTime();
        dist=  minDistance_N_runtime( input, 3, 5);
        end =System.nanoTime();
        System.out.println(" 3 5 --> expected : " + 1 + " actual:  "+ dist + "  time : "+ (end-start));
    }
}
