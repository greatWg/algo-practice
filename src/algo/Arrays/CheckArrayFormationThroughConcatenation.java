package algo.Arrays;

import java.util.HashMap;

public class CheckArrayFormationThroughConcatenation {
    public boolean canFormArray(int[] arr, int[][] pieces) {

        HashMap<Integer, Integer> mapOrder = new HashMap<>();

        boolean ans= false;

        for (int i = 0; i < arr.length; i++) {
            mapOrder.put(arr[i], i);
        }

        boolean[] ansArray= new boolean[pieces.length] ;
        for (int i = 0; i < pieces.length; i++) {
            int[] piece = pieces[i];
            if (piece.length == 1 && mapOrder.containsKey(piece[0])) {
                // can concatanate in array
                ansArray[i]= true;

            } else {
                int order = 0;
                int count =0;
                boolean [] combArray= new boolean [piece.length];
                for (int j = 0; j < piece.length; j++) { //4 64

                    if (mapOrder.containsKey(piece[j])) { //4
                        // order matched
                        if (count==0){ // 4
                            order = mapOrder.get(piece[j]);//
                            count++;
                            order++;
                            combArray[j]= true;
                        }else {
                            boolean tempResult= false;
                            if (mapOrder.get(piece[j])== order){ // 64
                                order++;
                                combArray[j]= true;
                            }else{
                                combArray[j]= false;
                            }

                        }
                    }
                }

                ansArray[i]= SummarizeArrayResult(combArray);
            }
        }


        return SummarizeArrayResult(ansArray);

    }

    private boolean SummarizeArrayResult(boolean[] combArray) {
        boolean reasult= false;
        int count =0;
        for(boolean value: combArray){
            if (value){
                count++;
            }

        }
        if (count++ == combArray.length){
            reasult =true;
        }
        return reasult;

    }

    public static void main(String[] args) {

        CheckArrayFormationThroughConcatenation ca = new CheckArrayFormationThroughConcatenation();

//        int[] arr = new int[]{1, 3, 5, 7};
//        int[][] pieces = new int[][]{{2, 4, 6, 8}};
//        boolean result = ca.canFormArray(arr, pieces);
//        System.out.println ("expected fale"+ result);


        int[] arr0 = new int[]{91,4,64,78};
        int[][] pieces0 = new int[][]{{78},{4,64},{91}};
        boolean result0 = ca.canFormArray(arr0, pieces0);
        System.out.println ("expected true :  "+ result0);

//
//        int[] arr1 = new int[]{1, 3, 5, 7};
//        int[][] pieces1 = new int[][]{{2, 4, 6, 8}};
//        boolean result1 = ca.canFormArray(arr1, pieces1);
//        System.out.println ("expected fale"+ result1);


    }







}
