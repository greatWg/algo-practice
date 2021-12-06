import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Facebook phone interview questions
 */
public class sortIntervals {

    List<Interval> output = new ArrayList<Interval>();

    private Interval getCombineInterval(Interval i1, Interval i2){
        Interval output = new Interval();
        output.start = Math.min(i1.start, i2.start);
        output.end = Math.max(i1.end, i2.end);

        return output;
    }

    public void printIntervals(List<Interval> list){
        StringBuffer sb = new StringBuffer();
        sb.append("[ ");
        for (Interval current : list ){
            sb.append("[ "+ current.start + " , " + current.end + " ] , ");
        }
        sb.append( "]");
        System.out.println(sb.toString().replace( ", ]", "]" ));
    }

    // Have a pointer for each list like i for list1 and j for list2
    // find smallest or merged interval
    // before adding any interval to final list  merge ( previnterval , merged(smallInterval, mergedfromTwoInterval))
    //
    public List<Interval> getSortedInterval(List<Interval> aList, List<Interval> bList){
        int indexA=0, indexB=0;
        int sizeA=aList.size(), sizeB= bList.size();
        Interval prevInterval;
        Interval currInterval;
        List<Interval> temp= new ArrayList<>();
        int count=0;    
        // Check for empty list and set the answer accordingly
        // set the first smallest interval between two list
        if (aList.get(indexA).start<  bList.get(indexB).start) {
            prevInterval = aList.get(indexA);
            temp.add(prevInterval);
            indexA++;
            count++;
        }else {
            prevInterval = bList.get(indexB);
            temp.add(prevInterval);
            indexB++;
            count++;
        }

        while(indexA< sizeA && indexB< sizeB){
            if ((aList.get(indexA).start < bList.get(indexB).start)  && ( aList.get(indexA).end< bList.get(indexB).start)) {
                currInterval=aList.get(indexA);
                if (prevInterval.compare(prevInterval, currInterval)== 0)
                {
                    temp.set(temp.size()-1, getCombineInterval(prevInterval,currInterval));
                }else{
                    temp.add( currInterval);
                }
                indexA++;
                count++;
            } else if (bList.get(indexB).start< aList.get(indexA).start && bList.get(indexB).end< aList.get(indexA).start){
                currInterval=bList.get(indexB);
                if (prevInterval.compare(prevInterval, currInterval)== 0)
                {
                    temp.set(temp.size()-1, getCombineInterval(prevInterval,currInterval));
                }else{
                    temp.add( currInterval);
                }
                indexB++;
                count++;
            }else{
                currInterval=getCombineInterval(aList.get(indexA), bList.get(indexB));
                if (prevInterval.compare(prevInterval, currInterval)== 0)
                {
                    temp.set(temp.size()-1, getCombineInterval(prevInterval,currInterval));
                }else{
                    temp.add(currInterval);
                }
                indexA++;
                indexB++;
                count+=2;
            }
            prevInterval= temp.get(temp.size()-1);

        }
        while (indexA< aList.size() && indexB== bList.size()){
            temp.add(aList.get(indexA));
            indexA++;
            count++;
        }

        while (indexB< bList.size() && indexA== aList.size()){
            temp.add(bList.get(indexB));
            indexB++;
            count++;
        }
        System.out.println ( "Count :"+count);
        return temp;
    }

    public static void main(String[] args){
        sortIntervals sortI = new sortIntervals();

        List<Interval> aList = new ArrayList<Interval>();
        List<Interval> bList = new ArrayList<Interval>();

        // add to List
        aList.add(new Interval(1,2));
        aList.add(new Interval(5,6));
        aList.add(new Interval(8,9));
        aList.add(new Interval(11,13));

        bList.add(new Interval(3,4));
        bList.add(new Interval(7,10));
        bList.add(new Interval(11,12));

        System.out.println("\n**** Given list *****");
        sortI.printIntervals(aList);
        sortI.printIntervals((bList));

        // sort Intervals with prev compare
        System.out.println("\n**** Sorted Intervals by compare previous *****");
        sortI.printIntervals(sortI.getSortedInterval(aList, bList));

        List<Interval> cList = new ArrayList<Interval>();
        List<Interval> dList = new ArrayList<Interval>();

        // add to List
        cList.add(new Interval(1,2));
        cList.add(new Interval(3,7));
        cList.add(new Interval(8,9));
        cList.add(new Interval(11,13));

        dList.add(new Interval(3,4));
        dList.add(new Interval(5,6));
        dList.add(new Interval(8,10));
        dList.add(new Interval(11,12));

        System.out.println("\n**** Given list *****");
        sortI.printIntervals(cList);
        sortI.printIntervals((dList));

        System.out.println("\n**** Sorted Intervals by compare previous *****");
        sortI.printIntervals(sortI.getSortedInterval(cList, dList));

        List<Interval> eList = new ArrayList<Interval>();
        List<Interval> fList = new ArrayList<Interval>();
        // add to List
        eList.add(new Interval(1,2));
        eList.add(new Interval(3,7));
        eList.add(new Interval(8,9));
        eList.add(new Interval(11,13));

        fList.add(new Interval(11,15));
        fList.add(new Interval(16,18));
        fList.add(new Interval(19,20));

        System.out.println("\n**** Given list *****");
        sortI.printIntervals(eList);
        sortI.printIntervals((fList));


        System.out.println("\n**** Sorted Intervals by compare previous *****");
        sortI.printIntervals(sortI.getSortedInterval(eList, fList));


        List<Interval> gList = new ArrayList<Interval>();
        List<Interval> hList = new ArrayList<Interval>();
        // add to List
        gList.add(new Interval(1,2));
        gList.add(new Interval(3,7));
        gList.add(new Interval(8,9));
        gList.add(new Interval(11,14));

        hList.add(new Interval(8,12));
        hList.add(new Interval(13,15));
        hList.add(new Interval(16,18));
        hList.add(new Interval(19,20));

        System.out.println("\n**** Given list *****");
        sortI.printIntervals(gList);
        sortI.printIntervals((hList));

        System.out.println("\n**** Sorted Intervals by compare previous *****");
        sortI.printIntervals(sortI.getSortedInterval(gList, hList));

        List<Interval> iList = new ArrayList<Interval>();
        List<Interval> jList = new ArrayList<Interval>();
        // add to List
        iList.add(new Interval(1,5));
        iList.add(new Interval(10,12));
        iList.add(new Interval(16,18));

        jList.add(new Interval(2,6));
        jList.add(new Interval(8,10));
        jList.add(new Interval(11,20));

        System.out.println("\n**** Given list *****");
        sortI.printIntervals(iList);
        sortI.printIntervals((jList));

        System.out.println("\n**** Sorted Intervals by compare previous *****");
        sortI.printIntervals(sortI.getSortedInterval(iList, jList));
    }
}


class Interval implements Comparator<Interval> {
    int start;
    int end;

    Interval(){}

    Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
    
    @Override
    public int compare(Interval o1, Interval o2) {
        return (o1.end > o2.start)? 0: 1;
    }

    public boolean contains(Interval i1){
        if (i1.start<this.end && i1.end< this.end ) {
            return true;
        }
        else {
            return false;
        }
    }
}