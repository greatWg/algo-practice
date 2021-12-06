package algo.Miscelleneous;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Main {


    private void imeLibrary(){
        Instant now = Instant.now();
        Instant time = now.minus(Duration.ofDays(62));
        System.out.println(" now and  "+ now + "then : + "+  time ) ;
        System.out.println(" now and  "+ now.toEpochMilli()  + "then : + "+  time.toEpochMilli()) ;
    }


    public static void main(String[] args) {

//        GetNumberOfIslands countIslands = new GetNumberOfIslands();
//        System.out.println("number of Islands : " + countIslands.howManyIslands());

        ArrayList<String> list = new ArrayList<>();
        list.add ("TEST");
        list.add ("TIE");
        list.add ("TOM");
        list.add ("TOMMY");
        list.add ("TRING");
        list.add ("TRISH");
        list.add ("TINA");

        GetTotalScoreOfWordList getTotalScoreOfWordList = new GetTotalScoreOfWordList();
        List<String> wordList = getTotalScoreOfWordList.readFile("./WordList.csv");

        getTotalScoreOfWordList.printList(wordList);

      //  System.out.println("wordListScore:  "+ getTotalScoreOfWordList.getScore(wordList));

        Main m = new Main();
        m.imeLibrary();

//        MergeSort mergeSort = new MergeSort();
//
//
////        int[] output = mergeSort.sort( 0, 5);
////        mergeSort.printArray(output);
//
//        Solution sol = new Solution();
//        int[] nums = {5,4,1,2,3};
//        sol.sortArray(nums);


        //int [][] array = {{1,0,0,0},{1,1,0,1}, {0,1,0,0}, {1,1,1,1}};
        //       MatrixTopStartRightEnd  matrix= new MatrixTopStartRightEnd();
        //       matrix.printMatrix(array);
        //

        System.out.println("\n\n**********");
        System.out.println("**** Matrix ****");
        System.out.println("********** \n");
        int [][] array1 = {{1,0,0,0},{1,1,0,1}, {0,1,0,0}, {1,1,1,1}};
//        MatrixTopStartRightEnd matrix= new MatrixTopStartRightEnd();
//        matrix.printMatrix(array1);
//        matrix.getPath(array1);

    }
}
