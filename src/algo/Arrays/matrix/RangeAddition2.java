package algo.Arrays.matrix;

public class RangeAddition2 {

    public int maxCount(int m, int n, int[][] ops) {
        // initial matrix
        int count = 0;
        long max = 0;
        long [][] matrix =  null;
        int size = 0;

        int a = 0, b = 0;
        int[] opsRow;

        if ( ops == null  || ops.length==0 ){
            return m*n;
        } else{
            size = ops.length;
            if (size==1){
                int[] row = ops[0];;
                return row[0]* row[1];
            }

            matrix= new long[m][n];
            for (int k = 0; k < size; k++) {
                opsRow = ops[k];
                a = opsRow[0];
                b = opsRow[1];

                for (int i = 0; i < a; i++) {
                    for (int j = 0; j < b; j++) {
                        matrix[i][j] = matrix[i][j] + 1;

                        if (max == matrix[i][j]) {
                            count++;
                        } else if (max < matrix[i][j]) {
                            max = matrix[i][j];
                            count = 1;
                        }
                    }
                }
            }
            //printMatrix(matrix, m, n);

            return count;
        }

    }

    public int maxCountOPS(int m, int n, int[][] ops){
        int count = 0;
        long max = 0;
        long [][] matrix =  null;
        int size = 0;

        int a = 0, b = 0;
        int[] opsRow;

        if ( ops == null  || ops.length==0 ){
            return m*n;
        } else{
            size = ops.length;
            if (size==1){
                int[] row = ops[0];;

                    return row[0]* row[1];

            }else {
                opsRow=findMinOps(ops);
                return opsRow[0]*opsRow[1];
            }
        }

    }

    private int[] findMinOps(int[][] ops) {
        int minMultiplication=0;
        int[] opsRow=null;
        int[] temp;
        for(int i =0; i< ops.length ; i++){
            temp = ops[i];
            int currentMultiplication= ( temp[0]* temp[1]);
            if (minMultiplication==0 || currentMultiplication< minMultiplication) {
                minMultiplication = currentMultiplication;
                opsRow = temp;
            }
        }
        return opsRow;
    }

    public void printMatrix(long [][] matrix ,int m, int n ){
        for (int i=0; i< m; i++){
            for (int j=0; j< n; j++){
                System.out.print(matrix[i][j]+  "  ");
            }
            System.out.println();
        }
    }

//    Time complexity : O(x)O(x). Single traversal of all operations is done. xx refers to the number of operations.
//
//    Space complexity : O(1)O(1). No extra space is used.

    /**
     *  0 0 0           1 1 0            2 2 1
     *  0 0 0 - 2x2-->  1 1 0 ---3x3-->  2 2 1
     *  0 0 0           0 0 0            1 1 1
     *
     *
     * Intersected row and column is right multiplier for given range addition
     *
     *
     * Optimal:     // Do I need to perform operation?
     *             // after operation what value will be present
     *             // minimum from rows  and minimum of columns
     * @param m row
     * @param n column
     * @param ops operation
     * @return
     */

    public int maxCountByIntersectionOps(int m, int n ,int[][] ops){
            // Do I need to perform operation?
            // after operation what value will be present
            // minimum from rows  and minimum of columns
            for (int[] op: ops) {

                m = Math.min(m, op[0]); // minimum (rowcount, ops.x)
                n = Math.min(n, op[1]); // minimum (columncount, ops.y)
//                printXi(ops[0]);
//                printXi(ops[1]);
            }
            //System.out.println("value is "+ m +" "+n );
            return m * n;

    }

     public void printXi(int[] opsX){
         for (int i: opsX) {
             System.out.print(" "+  i);
         }
     }


    public static void main(String[] args) {
        RangeAddition2 addition2 = new RangeAddition2();
        int[][] ops =  new int[][] {{2,2},{3,3}};

        System.out.println( "size is "+ addition2.maxCount( 3,3 , ops));

        int [][] ops1 = new int[0][];
        System.out.println( "size is "+ addition2.maxCount( 3,3 , ops1));

        int [][] ops2 = new int [][]{{1,1}};
        System.out.println( "size is "+ addition2.maxCount( 1,1 , ops2));

        int [][] ops3 = new int [0][];
        System.out.println( "size is "+ addition2.maxCount( 40000,40000 , ops3));

        int [][] ops4 = new int [][]{{19999,19999}};
        System.out.println( "size is" + addition2.maxCount( 39999,39999 , ops4));

        int [][] ops5 = new int [][] {{16,1}, {14,3}, {14,2}, {4,1}, {10,1}, {11,1}, {8,3},{16,2},{13,1},{8,3},{2,2},{9,1},{3,1},{2,2},{6,3}};
        System.out.println( "size is " + addition2.maxCount( 18,3 , ops5));


        // Find count min operation

        int[][] ops0 =  new int[][] {{2,2},{3,3}};
        System.out.println( "min ops size is "+ addition2.maxCountOPS( 3,3 , ops0));

        int [][] ops11 = new int[0][];
        System.out.println( "min ops size is "+ addition2.maxCountOPS( 3,3 , ops11));

        int [][] ops12 = new int [][]{{1,1}};
        System.out.println( "min ops size is "+ addition2.maxCountOPS( 1,1 , ops12));

        int [][] ops13 = new int [0][];
        System.out.println( "min ops size is "+ addition2.maxCountOPS( 40000,40000 , ops13));

        int [][] ops14 = new int [][]{{19999,19999}};
        System.out.println( "min ops size is " + addition2.maxCountOPS( 39999,39999 , ops14));


        int [][] ops15 = new int [][] {{16,1}, {14,3}, {14,2}, {4,1}, {10,1}, {11,1}, {8,3},{16,2},{13,1},{8,3},{2,2},{9,1},{3,1},{2,2},{6,3}};
        System.out.println( "min ops size is " + addition2.maxCountOPS( 18,3 , ops15));


        System.out.println( "Intersection optimize method" );

        // Find count min operation row column intersection

        int[][] ops20 =  new int[][] {{2,2},{3,3}};
        System.out.println( "min ops intersection size is "+ addition2.maxCountByIntersectionOps( 3,3 , ops20));

        int [][] ops21 = new int[0][];
        System.out.println( "min ops intersection size is "+ addition2.maxCountByIntersectionOps( 3,3 , ops21));

        int [][] ops22 = new int [][]{{1,1}};
        System.out.println( "min ops intersection size is "+ addition2.maxCountByIntersectionOps( 1,1 , ops22));

        int [][] ops23 = new int [0][];
        System.out.println( "min ops intersection size is "+ addition2.maxCountByIntersectionOps( 40000,40000 , ops23));

        int [][] ops24 = new int [][]{{19999,19999}};
        System.out.println( "min ops intersection size is " + addition2.maxCountByIntersectionOps( 39999,39999 , ops24));


        int [][] ops25 = new int [][] {{16,1}, {14,3}, {14,2}, {4,1}, {10,1}, {11,1}, {8,3},{16,2},{13,1},{8,3},{2,2},{9,1},{3,1},{2,2},{6,3}};
        System.out.println( "min ops intersection size is " + addition2.maxCountByIntersectionOps( 18,3 , ops25));



    }



}
