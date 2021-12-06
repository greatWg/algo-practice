public class MatrixTopStartRightEnd {

   public void getPath(int[][] array){

    int n = array[0].length;
    array [0][0]= 1;


   // Mark reachable (from top left) nodes
   // in first row and first column.
       for (int j=1; j <n ; j++){
           if(array[0][j]!= 0){
               array[0][j]= array[0][j-1];
           }
       }
       for (int i=1; i<n ; i++){
           if(array[i][0]!= 0){
               array[i][0]= array[i-1][0];
           }
       }
       System.out.println("\n ******");
       printMatrix(array);
       System.out.println("******\n");

       for (int i= 1;i<n ; i++) {
           for (int j = 1; j < n; j++) {
               if (array[i][j] != 0) {
                   array[i][j] = Math.max(array[i][j - 1], array[i - 1][j]);
                   //array[i][j]=2 ;
               }
           }
       }
       printMatrix(array);
   }


    public void printMatrix(int [][] array){

       for (int i= 0;i<array[0].length ; i++){
           for (int j=0; j<array[0].length ; j++) {
               System.out.print(array[i][j] + " ");
           }
           System.out.println("\n");
       }

    }
}
