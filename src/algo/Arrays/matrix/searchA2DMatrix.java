package algo.Arrays.matrix;

public class searchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length != 0) {
            int rowIndex = 0;

            int m = matrix.length;
            int n = matrix[0].length;
            // Found the row matrix[i-1][0] >target < matrix[i][0] -- > i-1 row
            for (int i = 0; i < m-1 ; i++) {
                if (target== matrix[i][0] || target== matrix[i+1][0]) {
                    return true;
                }
                if (matrix[i][0] < target && target < matrix[i + 1][0]) {
                    rowIndex = i;
                    break;
                }
                else{
                    rowIndex=i+1;
                }
            }

            // Found the column by binary search in the selected - Left column - mid column - right column

            int colStart = 0;
            int colEnd = n - 1;
            int columnIndex = 0;
            // Found the value = return true else false
            while (colStart <= colEnd) {
                int colMid = (colStart + colEnd) / 2;
                if (matrix[rowIndex][colMid] == target) {
                    columnIndex = colMid;
                    System.out.println(" [row, column] " + rowIndex + "," + columnIndex);
                    return true;
                } else if (target > matrix[rowIndex][colMid]) {
                    colStart = colMid + 1;
                } else {
                    colEnd = colMid - 1;
                }
            }
        }


        return false;
    }

    public static void main(String[] args) {
        searchA2DMatrix sm= new searchA2DMatrix();
        int[][] input = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int target = 3;

        System.out.println(sm.searchMatrix(input, target)); //true
        int target0 = 13;
        System.out.println(sm.searchMatrix(input, target0)); // false

        int target1 = 16;
        System.out.println(sm.searchMatrix(input, target1)); // true

        int target01 = 30;
        System.out.println(sm.searchMatrix(input, target01)); // true

        int[][] input1= new int[][]{};
        int target2 = 0;
        System.out.println(sm.searchMatrix(input1, target2)); // false

        int[][] input2= new int[][]{{1}};
        int target3 = 1;
        System.out.println(sm.searchMatrix(input2, target3)); // true


        int[][] input3= new int[][]{{1},{3}};
        int target4 = 3;
        System.out.println(sm.searchMatrix(input3, target4)); // true


    }
}
