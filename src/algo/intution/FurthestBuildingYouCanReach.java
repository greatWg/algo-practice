package algo.intution;

public class FurthestBuildingYouCanReach {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        for (int i=0; i<heights.length; i++){


        }

        return 0;
    }

    public static void main(String[] args) {

        FurthestBuildingYouCanReach fb= new FurthestBuildingYouCanReach();

        //heights = [4,2,7,6,9,14,12], bricks = 5, ladders = 1
        fb.furthestBuilding(new int[]{4,2,7,6,9,14,12}, 5, 1);

        // 4,12,2,7,3,18,20,3,19], bricks = 10, ladders = 2
        fb.furthestBuilding(new int[]{4,12,2,7,3,18,20,3,19}, 10, 2);

//        fb.furthestBuilding(new int[]{4,2,7,6,9,14,12}, 5, 1);
//        fb.furthestBuilding(new int[]{4,2,7,6,9,14,12}, 5, 1);


    }
}
