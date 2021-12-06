package algo.Arrays.matrix;

public class searchA2DMatrix_II {
    // run time
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0)  return false;
        int m=matrix.length;
        int n= matrix[0].length;

        int r = 0 , c= n-1;

        // RUNTIME: O(m+n)
        while ( r <m  && c>=0 ){
            if(target == matrix[r][c]) {
                return true;
            }else if (target < matrix[r][c]){
                c--;
            }else{
                r++;
            }
        }
        return false;
    }


    public boolean searchMatrix2(int[][] matrix, int target) {
        int m=matrix.length;
        int n= matrix[0].length;

        int startX=0;
        int startY=0;
        int endX=m-1;
        int endY=n-1;

        while (target < matrix[endX][endY] && (endX >startX && endY>startY)){
            endX=endX/2;
            endY=endY/2;
        }
        while (target > matrix[startX][startY] && (startX > endX && startY> endY)){
            startX=(startX + endX)/2;
            startY=(startY + endY)/2;
        }

        for(int i = startX; i <=endX; i++){
            for(int j = startY; j <= endY; j++){
                if (target == matrix[i][j]){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        searchA2DMatrix_II  matrix = new searchA2DMatrix_II();
        int[][] mat= {{1,4}, {2,5}};

//        System.out.println(matrix.searchMatrix(mat, 2));
//
//        int[][] matq= {{-5}};
//        System.out.println(matrix.searchMatrix(matq, -10));

//        int[][] mat2= {{1,1}};
//        System.out.println(matrix.searchMatrix(mat2, 0));

        int[][] mat3= {{1,2, 3,4,5}};
        System.out.println(matrix.searchMatrix(mat3,4));
    }
}

