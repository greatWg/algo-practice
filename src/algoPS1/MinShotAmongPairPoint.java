package algoPS1;

public class MinShotAmongPairPoint {

    public int findMinArrowShots(int[][] points) {
        int minShots=0;
        if (points.length == 1 ){
            return 1;
        }
        else {
            System.out.println("Before");
            printPoints(points);
            // sort the points ByXstartOrder(
            int[][] sortedPoints =this.mergeSort(points, 0, points.length-1);
            System.out.println("after");
            printPoints(points);
            int length= sortedPoints.length;
            int[] prevPoint= null;
            // if prepoint and current point have common point then set to prevpoint =shared point
            // else increment minshots  and set currentpoint to prevpoint
            for (int i=0; i<length; i++){
                if (prevPoint == null){
                    prevPoint= points[i] ;
                    minShots++;
                }
                else {
                    if (areSharablePoint(prevPoint, points[i]) )
                    {
                        prevPoint = normalizePoint(prevPoint, points[i]);
                    }
                    else {
                        prevPoint =  points[i];
                        minShots++;
                    }
                }
            }
        }
        return minShots;

    }


    private boolean areSharablePoint(int[] prevPoint, int[] point) {
        if (prevPoint[1]>=point[0]){
            return true;
        }
        return false;
    }

    private int[] normalizePoint(int[] point, int[] point1) {
        int[] mergedPoint= new int[2];
        mergedPoint[0]=Math.max(point[0], point1[0]);
        mergedPoint[1]=Math.min(point[1], point1[1]);
        return mergedPoint;
    }

    private void printPoints(int[][] points) {
        for(int i=0;i<points.length;i++){
            System.out.print( "["+points[i][0] +"," + points[i][1]+ "]");
        }
        System.out.println();
    }

    private int[][] mergeSort(int[][] points, int low, int high) {
        if (low<high) {
            int mid = (low + high )/ 2;
            mergeSort(points, low, mid);
            mergeSort(points, mid + 1, high);
            merge(points, low, mid, high);
        }
        return points;
    }

    private int[][] merge (int[][] points, int low, int middle, int high){
        int[][] helper= new int[points.length][2];

        for(int i=low;i<points.length;i++){
            helper[i][0]=points[i][0];
            helper[i][1]=points[i][1];
        }

        //Two list have i and j start pointer

        int i=low,
                j=middle+1,
                k=low;
        //Copy all elements of list 1 and list 2 in sorted order. Some of the list elements may left
        //as they greater than last element of list 2.
        while (i<=middle && j<=high){
            if (helper[i][0]<= helper[j][0]){
                points[k][0]=helper[i][0];
                points[k][1]=helper[i][1];
                i++;
            }
            else{
                points[k][0]=helper[j][0];
                points[k][1]=helper[j][1];
                j++;
            }
            k++;
        }
        //copy the rest of the left side of the array into target array
        while(i<=middle){
            points[k][0]=helper[i][0];
            points[k][1]=helper[i][1];
            i++;
            k++;
        }
        return points;
    }


    /**
     * points = [[10,16],[2,8],[1,6],[7,12]]  // 2
     *
     * points = [[1,2],[3,4],[5,6],[7,8]] //4
     *
     * [[1,2],[2,3],[3,4],[4,5]]  // 2
     *
     * [[1,2]]  // 1
     *
     * [2,3],[2,3]]  // 1
     *
     * [Xstart, Xend]
     *
     * @param args
     */
    public static void main(String[] args){
        
        int[][] points0= {{10,16},{2,8},{1,6},{7,12}};

        int[][] points1= {{1,2},{3,4},{5,6},{7,8}};

        int[][] points2= {{1,2},{2,3},{3,4},{4,5}};

        int[][] points3= {{1,2}};

        int[][] points4= {{2,3},{2,3}};
        
        int[][] points5 ={{1,9},{7,16},{2,5},{7,12},{9,11},{2,10},{9,16},{3,9},{1,3}};

        MinShotAmongPairPoint pairPoint= new MinShotAmongPairPoint();

//        System.out.println(" " + pairPoint.findMinArrowShots(points0));
//        System.out.println(" " + pairPoint.findMinArrowShots(points1));
//        System.out.println(" " + pairPoint.findMinArrowShots(points2));
//        System.out.println(" " + pairPoint.findMinArrowShots(points3));
//        System.out.println(" " + pairPoint.findMinArrowShots(points4));
        System.out.println(" " + pairPoint.findMinArrowShots(points5));
//        List<List<Integer>> points = new ArrayList<>();
//        List<Integer> point1= new ArrayList<Integer>();
//        point1.add(10);
//        point1.add(16);
//
//        List<Integer> point2= new ArrayList<Integer>();
//        point2.add(2);
//        point2.add(8);
//
//        List<Integer> point3= new ArrayList<Integer>();
//        point3.add(1);
//        point3.add(6);
//
//        List<Integer> point4= new ArrayList<Integer>();
//        point4.add(7);
//        point4.add(12);
//
//        points.add(point1);
//        points.add(point2);
//        points.add(point3);
//        points.add(point4);
//
//
//        List<List<Integer>> points1 = new ArrayList<>();
//        List<Integer> point11= new ArrayList<Integer>();
//        point11.add(1);
//        point11.add(2);
//
//        List<Integer> point12= new ArrayList<Integer>();
//        point12.add(2);
//        point12.add(3);
//
//        List<Integer> point13= new ArrayList<Integer>();
//        point13.add(3);
//        point13.add(4);
//
//        List<Integer> point14= new ArrayList<Integer>();
//        point14.add(4);
//        point14.add(5);
//
//        points1.add(point11);
//        points1.add(point12);
//        points1.add(point13);
//        points1.add(point14);
//
//        List<List<Integer>> points2 = new ArrayList<>();
//        List<Integer> point21= new ArrayList<Integer>();
//        point21.add(1);
//        point21.add(2);
//
//        List<Integer> point22= new ArrayList<Integer>();
//        point22.add(3);
//        point22.add(4);
//
//        List<Integer> point23= new ArrayList<Integer>();
//        point23.add(4);
//        point23.add(6);
//
//        List<Integer> point24= new ArrayList<Integer>();
//        point24.add(7);
//        point24.add(8);
//
//        points2.add(point11);
//        points2.add(point12);
//        points2.add(point13);
//        points2.add(point14);
//
//        List<List<Integer>> points3 = new ArrayList<>();
//        List<Integer> point31= new ArrayList<Integer>();
//        point31.add(1);
//        point31.add(2);
//
//        points3.add(point31);
//
//        List<List<Integer>> points4 = new ArrayList<>();
//        List<Integer> point41= new ArrayList<Integer>();
//        point41.add(2);
//        point41.add(3);
//
//        List<Integer> point42= new ArrayList<Integer>();
//        point42.add(2);
//        point42.add(3);
//
//        points4.add(point41);
//        points4.add(point42);
//
//        System.out.println(" " +     findMinArrowShots( points4).toString());

    }
}
