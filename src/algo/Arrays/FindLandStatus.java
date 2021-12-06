package algo.Arrays;

public class FindLandStatus {
    private int runTimeCount=0;
    public int[] getLandStatus(int[] terrain, int[] fountains){
        int [] landStatus= new int [terrain.length];

        if (fountains.length==0){
            return landStatus;
        }
        else {
            for (int index : fountains){
                // set wet where is fountain
                landStatus[index] = 1;
                spreadLeft( landStatus, terrain, terrain[index],index);
                spreadRight(landStatus, terrain, terrain[index],index);
                runTimeCount++;
            }
            return landStatus;
        }
    }

    private void spreadLeft(int[] landStatus, int[] terrain, int height, int currentIndex) {
         int index = currentIndex-1;
         while(index>=0 && terrain[index] <= height){
             // spread  wet land
             landStatus[index]=1;
             index--;
             runTimeCount++;
         }
    }

    private void spreadRight(int[] landStatus, int[] terrain, int height, int currentIndex) {
        int index = currentIndex+1;
        while(index < terrain.length && terrain[index] <= height){
            // spread  wet land
            landStatus[index]=1;
            index++;
            runTimeCount++;
        }
    }


    /**
     *  3 1 2 3 5 1 2 2 4 3  4 // terrain
     *        4   6   8   10   // fountains
     *  1 1 1 1 0 1 1 1 0 1  0 // wet(1) and dry(0) lands
     *
     * @param args
     */
    public static void main(String args[]){

        int terrain[] = new int [] {3, 1, 2 , 1,  3,  5, 1, 2, 2, 4,  3, 4 };
        int fountains[] = new int [] {4, 6, 8, 10};

        int expectedLandStatus[] = new int [] { 1, 1, 1, 1, 1,  0, 1, 1, 1, 0,  1, 0};
        FindLandStatus fl= new FindLandStatus();
        int [] landStatus = fl.getLandStatus(terrain, fountains);

        printSummary(terrain, fountains, expectedLandStatus, landStatus, fl.runTimeCount);

        int terrain1[] = new int [] {3, 1, 2 , 1,  3,  2, 1, 2, 2, 4,  3, 4 };
        int fountains1[] = new int [] {4, 6, 8, 10};
        int expectedLandStatus1[] = new int [] { 1, 1, 1, 1, 1,  1, 1, 1, 1, 0,  1, 0};
        FindLandStatus fl1= new FindLandStatus();
        int [] landStatus1 = fl1.getLandStatus(terrain1, fountains1);

        printSummary(terrain1, fountains1, expectedLandStatus1, landStatus1, fl1.runTimeCount);

        int terrain2[] = new int [] {3, 1, 2 , 1,  3,  2, 1, 2, 2, 2,  3, 2 };
        int fountains2[] = new int [] {4, 6, 8, 10};
        int expectedLandStatus2[] = new int [] { 1, 1, 1, 1, 1,  1, 1, 1, 1, 1,  1, 1};
        FindLandStatus fl2= new FindLandStatus();
        int [] landStatus2 = fl2.getLandStatus(terrain2, fountains2);

        printSummary(terrain2, fountains2, expectedLandStatus2, landStatus2, fl2.runTimeCount);

        int terrain3[] = new int [] {2, 1, 2 , 1,  2,  2, 2, 2, 2, 2,  2, 2 };
        int fountains3[] = new int [] {4, 6, 8, 10};
        int expectedLandStatus3[] = new int [] { 1, 1, 1, 1, 1,  1, 1, 1, 1, 1,  1, 1};
        FindLandStatus fl3= new FindLandStatus();
        int [] landStatus3 = fl3.getLandStatus(terrain3, fountains3);

        printSummary(terrain3, fountains3, expectedLandStatus3, landStatus3, fl3.runTimeCount);
    }

    private static void printSummary(int[] terrain, int[] fountains, int[] expectedLandStatus, int[] landStatus, int runtimecount) {

        for (int value : expectedLandStatus){
            System.out.print(value + " ");
        }
        System.out.println(" //Expected run status \n");
        for (int value : landStatus){
           System.out.print(value + " ");
        }

        System.out.println(" // Actual run status \n");
        System.out.println( "terrain length : "+ terrain.length);
        System.out.println( "fountain length : "+ fountains.length);

        System.out.println("Expected count: "+  terrain.length * fountains.length  + " Runtime count:  "  + runtimecount );
    }
}
