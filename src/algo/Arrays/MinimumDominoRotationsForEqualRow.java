package algo.Arrays;

import java.util.HashMap;

public class MinimumDominoRotationsForEqualRow {

    public int minDominoRotations(int[] A, int[] B) {
        int minRotation=-1;

        HashMap<Integer, Integer > mapA = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer > mapB = new HashMap<Integer, Integer>();
        int maxOccurA=0;
        int maxOccurB=0;
        int freqvValueA=0;
        int freqvValueB=0;

        if (A.length == B.length) {

            for (int i = 0; i < A.length; i++) {
                int currOccur = addKey(A[i], mapA);
                if (maxOccurA < currOccur) {
                    maxOccurA = currOccur;
                    freqvValueA = A[i];
                }
            }
            for (int i = 0; i < B.length; i++) {
                int currOccur = addKey(B[i], mapB);
                if (maxOccurB < currOccur) {
                    maxOccurB = currOccur;
                    freqvValueB = B[i];
                }
            }

            int maxFreqValue = Math.max(freqvValueA, freqvValueB);
            if (mapA.containsKey(maxFreqValue) && mapB.containsKey(maxFreqValue)) {
                minRotation=0;
                if (mapA.get(maxFreqValue) > mapB.get(maxFreqValue)) {
                    for (int i = 0; i < A.length; i++) {
                        if (A[i] == maxFreqValue) {
                            continue;
                        } else if ((A[i] != maxFreqValue && B[i] == maxFreqValue)) {
                            minRotation++;

                        } else {
                            return -1;

                        }

                    }
                } else {
                    for (int i = 0; i < B.length; i++) {
                        if (B[i] == maxFreqValue) {
                            continue;
                        } else if ((B[i] != maxFreqValue && A[i] == maxFreqValue)) {
                            minRotation++;

                        } else {
                            return -1;

                        }
                    }


                } //System.out.println(" freq "+ freqvValue+" max occur"+maxOccur);

            }
        }
        return minRotation;
    }
        //System.out.println(" freq "+ freqvValue+" max occur"+maxOccur);




    private int addKey(int i, HashMap<Integer,Integer> map) {
        if (map.containsKey(i)){
            map.put(i, map.get(i)+1);

        }else {
            map.put(i, 1);
        }
        return map.get(i);
    }

    void printArray(int[] A){
        for (int i: A){
            System.out.print( i+ " ,");
        }

    }
    public static void main(String[] args) {
        MinimumDominoRotationsForEqualRow minRotate= new MinimumDominoRotationsForEqualRow();
        int[] A = {2,1,2,4,2,2};
        int[] B = {5,2,6,2,3,2};

//        minRotate.printArray(A);
//        minRotate.printArray(B);
//
//        System.out.println ("\n"+ minRotate.minDominoRotations(A, B));
//
//        int[] A1 = {3,5,1,2,3};
//        int[] B1 = {3,6,3,3,4};
//
//        minRotate.printArray(A1);
//        minRotate.printArray(B1);
//        System.out.println ("\n"+minRotate.minDominoRotations(A1, B1));
//
//        int[] A2 = {1,2,1,1,1,2,2,2};
//        int[] B2 = {2,1,2,2,2,2,2,2};
//        minRotate.printArray(A2);
//        minRotate.printArray(B2);
//        System.out.println ("\n"+minRotate.minDominoRotations(A2, B2));

        int[] A3={1,3,2,3,4,1,1,4,1};
        int[] B3= {5,1,5,5,2,3,5,3,1};

        minRotate.printArray(A3);
        minRotate.printArray(B3);
        System.out.println ("\n"+minRotate.minDominoRotations(A3, B3));

    }
}
