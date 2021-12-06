package algo.PriorityQueue;

import java.util.PriorityQueue;

public class PQTestClass {

    void PqTest(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add (5);
        PrintQueue(pq.toArray());
        pq.add (15);
        PrintQueue(pq.toArray());
        pq.add (1);
        PrintQueue(pq.toArray());
        pq.add (3);
        PrintQueue(pq.toArray());

        PriorityQueue<Integer> test = new PriorityQueue<>();
        //2, 4, 7, 1, 5, 3
        test.add(2);
        test.add(4);
        test.add(7);
        PrintQueue(test.toArray());
        test.add(1);
        test.add(5);
        test.add(3);
        PrintQueue(test.toArray());
    }

    private void PrintQueue(Object[] pq) {
        for (Object i: pq){
            System.out.print(" "+ (int)i );
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PQTestClass test= new PQTestClass();
        test.PqTest();

    }
}
