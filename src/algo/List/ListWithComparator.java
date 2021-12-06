package algo.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListWithComparator {

    public List<String> insertListByComparator(List<String> number){

        Collections.sort(number, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1)-Integer.parseInt(o2);
            }
        });

        return number;
    }

    public List<String> SortNoComparator(List<String> number){
        Collections.sort(number);
        return number;
    }

    public static void main(String[] args) {
        ListWithComparator lc= new ListWithComparator();
        List<String> number= new ArrayList<>();

        number.add("88");
        number.add("32");
        number.add("99");
        number.add("40");

        System.out.println("before ");

        lc.printList(number);


        System.out.println(" \n No comparator ");
        long start= System.nanoTime();
        lc.SortNoComparator(number);
        long end = System.nanoTime();
        System.out.println( "Time : "+  (end-start));
        lc.SortNoComparator(number);




        System.out.println(" \n After comparator ");
        start= System.nanoTime();
        lc.insertListByComparator(number);
        end = System.nanoTime();
        System.out.println( "Time : "+  (end-start));
        lc.printList(number);
    }

    private void printList(List<String> numbers) {
        for(String number: numbers){
            System.out.print (" "+ number);
        }
    }
}
