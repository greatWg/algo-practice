package algo.PriorityQueue;

import sun.awt.geom.AreaOp;

import java.util.Iterator;
import java.util.PriorityQueue;

public class KthLargestInStream {

    int capacity= 0;
    int size;
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    public  void KThLargest(int k , int[] nums){
        capacity=k;
        size=0;
        for(int i=0 ; i<nums.length; i++){
            minHeap.offer(nums[i]);
            size++;
            if (size> capacity){
                minHeap.poll();
            }

        }
        print(minHeap);
        System.out.println ();

    }

    // return Kth Largest in Stream
    public int add(int val){
        minHeap.offer(val);
        System.out.print  (" Before ..");
        print(minHeap);
        size++;
        if (size> capacity){
            minHeap.poll();
            size--;
        }
        System.out.print  (" After ..");
        print(minHeap);
        return minHeap.peek();

    }
    public void print(PriorityQueue<Integer> queue){
        Iterator<Integer> iterator = queue.iterator();
        while(iterator.hasNext()){
            System.out.print(" "+ iterator.next());
        }
       System.out.println(" ");

    }

   public static void main(String[] args){
        KthLargestInStream stream = new KthLargestInStream();
        int [] array = new int []{4 ,5,8,2};
        // 2 4 5 8
        stream.KThLargest(3 , array);  // 2 4 5 8 // 4 5 8
        System.out.println (" Answer "+ stream.add(3)); // 2 3 4 5 8 // 4 5 8
        System.out.println (" Answer "+ stream.add(5)); // 2 4 5 5 8 // 5 5 8
        System.out.println (" Answer "+ stream.add(10)); //5 10 8
        System.out.println (" Answer "+ stream.add(9)); // 8 9 10
        System.out.println (" Answer "+ stream.add(4)); //  8 9 10
       // System.out.println (" Answer "+ stream.add(9));
      //  System.out.println (" Answer "+ stream.add(10));
       System.out.println (" Answer "+ stream.add(11));
        //output : [null,4,5,5,8,8]

    }
}
