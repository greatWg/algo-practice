package algo.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CreateSortedArraythroughInstructions {
    public int createSortedArray(int[] instructions) {
        //int[] costs = new int[instructions.length];
        int cost=0;
        LinkedList<Integer> list= new LinkedList<Integer>();

        for (int i=0;i<instructions.length; i++){

            int currCost= insertInList(instructions[i], list);
            cost = cost + currCost;

            //System.out.println("cost at i"+  i +" : "+cost);

        }

        return cost;
    }
    private int insertInList(int i, List<Integer>  list){
        Iterator<Integer> iterator= list.iterator();
        int count=0;

        int same=0;
        int curr=0;
        while (iterator.hasNext()&& curr<=i)
        {
            int value = iterator.next();
            if (value<i ){
                count++;

            }
            if (value==i){
                same++;
            }
        }
        int index = count + same;
        System.out.println (" I " + i + " min : "+  count +"  "+ (list.size()-index));
        int cost = Math.min(count, list.size()-(index));

        list.add(index, i);

        return cost;
    }

    public static void main(String[] args) {
        CreateSortedArraythroughInstructions sa= new CreateSortedArraythroughInstructions();
//
        int [] inst = new int []{1,5,6,2};
        System.out.println("expected : 1  actual : "+ sa.createSortedArray(inst));
//
        int [] inst0 = new int []{1,2,3,6,5,4};
        System.out.println("expected : 3  actual : "+ sa.createSortedArray(inst0));

        int [] inst1 = new int []{1,3,3,3,2,4,2,1,2};
        System.out.println("expected : 4  actual : "+ sa.createSortedArray(inst1));
    }
}
