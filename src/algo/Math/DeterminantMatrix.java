package algo.Math;

public class DeterminantMatrix {

    public int determinant(int [][] array, int n){

// Not working
        int [][] subMatrix= new int[10][10];

        int det=0;
        if (n==1){
            return array[0][0]- array[0][1];
        }

        if (n==2){
            // a b   ==> ad-bc
            // c d
            return  (array[0][0]* array[1][1]) - (array[1][0] * array[0][1]);
        }
        else{
            for (int c=0; c<n; ++c){ // co-efficient
                int subi=0;

                for (int i=1; i<n; ++i) { // sub matrix row 1 2
                    int subj=0;
                    for (int j=0; j<n; ++j) { // sub matrix column 0 1 2
                        if (j==c){
                            continue;
                        }else {
                            subMatrix[subi][subj] = array[i][j];
                            subj++;
                        }

                    }
                    subi++;
                }

                det = (int) (det +( Math.pow(-1, c) * (array[0][c] * determinant(subMatrix, n-1))));
            }

            return  det;
        }


    }

    int determinant0( int[][] matrix, int n) {
        int det = 0;
        int[][] submatrix= new int[n-1][n-1];

        if (n == 2)
            return ((matrix[0][0] * matrix[1][1]) - (matrix[1][0] * matrix[0][1]));
        else {
            for (int x = 0; x < n; x++) {
                int subi = 0;
                for (int i = 1; i < n; i++) {
                    int subj = 0;
                    for (int j = 0; j < n; j++) {
                        if (j == x)
                            continue;
                        submatrix[subi][subj] = matrix[i][j];
                        subj++;
                    }
                    subi++;

                }
                det = det + ((int)Math.pow(-1, x) * matrix[0][x] * determinant0(submatrix, n - 1 ));
            }
        }
        return det;
    }

    public static void main(String[] args) {
        DeterminantMatrix dm = new DeterminantMatrix();
        int[][] array = {{1,2}, {3,4}};
        //System.out.println("expected: -2 and actual: " + dm.determinant(array, 2));

        int[][] array0 = {{3,2,1}, {2,5,2}, {2,2,2 }};
        //System.out.println("expected: -2 and actual: " + dm.determinant(array0 , 3));

        int[][] array1 = {{1,2,3,4},{5,6,7,8}, {9,10,11,12}, {13,14,15, 16}};
        //System.out.println("expected: -2 and actual: "+ dm.determinant(array , 4));


        int[][] array2 = {{1,2,3,4},{5,6,7,8}, {9,10,16,12}, {13,14,15, 11}};
        //
        System.out.println("expected: -2 and actual: " + dm.determinant0(array, 2));
        System.out.println("expected: 12 and actual: " + dm.determinant0(array0, 3));

        System.out.println("expected: 0 and actual: " + dm.determinant0(array1, 4));

        System.out.println("expected: 100 and actual: " + dm.determinant0(array2, 4));
    }
}
