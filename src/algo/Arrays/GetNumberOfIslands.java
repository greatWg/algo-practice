package algo.Arrays;

public class GetNumberOfIslands {

    int ROW= 5, COL=5;

    public int getIslandsCountNoDiagnolCheck(int[][] array , int rowLen, int columnLen){
        int numberofIslands= 0;
        for (int i=0; i<rowLen; i++){
            for(int j=0; j<columnLen; j++){
                if (array[i][j]== 1){
                    System.out.println( "row column  " + i + " "+ j+ " "+ array[i][j]+ " ");
                    if ((i>0 && array[i-1][j] == 1 ) || (j>0 && array [i][j-1]== 1 )){
                        break;
                    }
                    else{
                        numberofIslands++;
                        //System.out.print( "    count  " +numberofIslands);
                    }
                }
            }
        }
        return numberofIslands;
    }

    public int howManyIslands(){

        int [][] array4 = {{0,0,1,1},{0,0,0,1}, {1,0,0,0}, {0,0,0,0}};
        GetNumberOfIslands countIslands = new GetNumberOfIslands();

        int [][] array5 = { {1,1,0,0,0},
                            {0,1,0,0,1},
                            {1,0,0,1,1},
                            {0,0,0,0,0},
                            {1,0,1,0,1}};

        //return countIslands.getIslandsCountNoDiagnolCheck(array4, 4, 4);
        //return countIslands.getIslandsCountNoDiagnolCheck(array5, 5, 5);

        return countIslands.countIslandsByDFS(array5, ROW, COL);

    }

    public int countIslandsByDFS(int map[][], int ROW, int COL){
        int count = 0;
        boolean visited[][] = new boolean[ROW][COL];

        for (int i=0; i<ROW; i++){
            for (int j=0; j<COL; j++){
                if (map[i][j]== 1 && !visited[i][j]) {
                    DFS(map, i, j, visited);
                    ++count;
                }
            }
        }
        return count;
    }

    private void DFS(int[][] map, int row, int column, boolean[][] visited) {
        int [] rowNbr = new int [] {-1, -1, -1, 0, 0, 1, 1, 1 };
        int [] colNbr = new int [] {-1, 0, 1, -1, 1, -1, 0, 1 };

        visited[row][column]= true;
        for (int k=0; k<8; ++k){
            if (isSafe(map, row+rowNbr[k], column+ colNbr[k], visited)){
                DFS(map, row+rowNbr[k], column+ colNbr[k], visited);
            }
        }
    }

    private boolean isSafe(int[][] map, int row, int column, boolean[][] visited) {
        return((row>=0 && row< ROW )&& (column>=0 && column<COL) && (map[row][column]== 1 && !visited[row][column]));
    }
}
