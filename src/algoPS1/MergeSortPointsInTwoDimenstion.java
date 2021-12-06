package algoPS1;

public class MergeSortPointsInTwoDimenstion {
    public int[][] sortPoints(int[][] points){
        System.out.println("Before");
        printPoints(points);
        mergeSort(points,0, points.length-1);
        System.out.println("After");
        printPoints(points);
        return points;

    }

    private void printPoints(int[][] points) {
        for(int i=0;i<points.length;i++){
           System.out.print( "["+points[i][0] +"," + points[i][1]+ "]");
        }
        System.out.println();
    }

    private void mergeSort(int[][] points, int low, int high) {
        if (low<high){
            int mid=(low+high)/2;
            mergeSort(points,low,mid);
            mergeSort(points,mid+1,high);
            merge(points,low,mid,high);
        }
        return;
    }

    private void merge(int[][] points, int low, int mid, int high) {
        int[][] helper = new int[points.length][2]; //two dimension space so point { xstart, xend}
        // copy in temp array
        for(int i=0;i<points.length;i++){
            helper[i][0]= points[i][0];
            helper[i][1]= points[i][1];
        }
        // merge two array with different start point,and
        int first=low, second=mid+1, k=low;
        while (first<=mid && second<=high) {
            if (helper[first][0] <= points[second][0]) {
                points[k][0] = helper[first][0];
                points[k][1] = helper[first][1];
                first++;
            } else {
                points[k][0] = helper[second][0];
                points[k][1] = helper[second][1];
                second++;
            }
            k++;
        }
        while(first<=mid){
            points[k][0] = helper[first][0];
            points[k][1] = helper[first][1];
            first++;
            k++;
        }

    }

    public static void main(String[] args){
        MergeSortPointsInTwoDimenstion sort= new MergeSortPointsInTwoDimenstion();
//        int[][] points0= {{5,6},{1,2}};
//        sort.sortPoints(points0);
//
//        int[][] points1= {{10,16},{2,8},{1,6},{7,12}};
//        sort.sortPoints(points1);

        int[][] points2= {{10,16},{2,8},{1,6},{7,12},{9,16},{3,9},{1,3}};
        sort.sortPoints(points2);
//
//        int[][] points5 ={{1,9},{7,16},{2,5},{7,12},{9,11},{2,10},{9,16},{3,9},{1,3}};
//        sort.sortPoints(points5);
    }
}
