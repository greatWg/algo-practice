package com.Interview;

public class GridTopLeftBottomRight {
    int [][] dpGrid ;
    // Combinatorial problems
    // Grid of m x n
    //  i/j
    //      0--1---2---3---4----5
    //   0  1  1   1   1   1    1
    //   1  1  2   3   4   5    6
    //   2  1  3   6   10  15   21
    //   3  1  4   10  20  35   56
    //   4  1  5   15  35  70   116
    //   5  1  6   21  56  116  252
    //
    // m - number of rows
    // n - number of columns
    public int totalPathToDestination(int m, int n ){
        dpGrid = new int [m][n];
        int countPath=0;
        if ( m == 1 && n == 1){
            countPath=m;
        }
        for (int i =0; i<m; i++){
            for (int j=0;j<n; j++){
                if (i==0 || j==0 ){
                    dpGrid[i][j]= 1;
                }
                else {
                    countPath = dpGrid[i][j-1] + dpGrid[i-1][j];
                    dpGrid[i][j] = countPath;
                }
            }
        }
        return countPath;
    }

    public static void main(String args[]){
        GridTopLeftBottomRight grid = new GridTopLeftBottomRight();

        int count = grid.totalPathToDestination(2,2);
        System.out.println("number of ways "+ count);

        count = grid.totalPathToDestination(3,3);
        System.out.println("number of ways "+ count);

        count = grid.totalPathToDestination(4,4);
        System.out.println("number of ways "+ count);

        count = grid.totalPathToDestination(5,5);
        System.out.println("number of ways "+ count);

        count = grid.totalPathToDestination(6,6);
        System.out.println("number of ways "+ count);
    }



}