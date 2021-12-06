package algo.PriorityQueue;

import java.util.*;

public class FiveStarReviews {

    private int reachRating(List<List<Integer>> products, int threshold) {

        // High priority queue =  new PriorityQueue ( (a, b) -> b - a )
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((product1, product2)
                -> (int)(ratingJump(product2) - ratingJump(product1)));
        int steps = 0;
        double currRating = 0.0d;
        for(List<Integer> product : products) {
            pq.add(product);
            currRating += ((double)product.get(0)/product.get(1));
        }
        currRating = currRating*100;

        while(currRating < (threshold*products.size())) {
            steps++;
            List<Integer> highestJump = pq.remove();
            List<Integer> newRating = Arrays.asList(highestJump.get(0)+1, highestJump.get(1)+1);
            currRating = currRating + ratingJump(highestJump);
            pq.add(newRating);
        }

        return steps;
    }

    private double ratingJump(List<Integer> product) {
        double currRating = (100.0d*product.get(0)) / product.get(1);
        double newRating = (100.0d*(product.get(0)+1)) / (product.get(1)+1);
        return newRating-currRating;
    }


    public static void main(String[] args) {

        FiveStarReviews fsw = new FiveStarReviews();
        List<List<Integer>> productRatings= new ArrayList<>();
        List<Integer> rating = new ArrayList<>();
        rating.add(4);
        rating.add(4);
        List<Integer> rating0 = new ArrayList<>();
        rating0.add(1);
        rating0.add(2);
        List<Integer> rating1 = new ArrayList<>();
        rating1.add(3);
        rating1.add(6);
        productRatings.add(rating);
        productRatings.add(rating0);
        productRatings.add(rating1);

        System.out.println(fsw.reachRating(productRatings, 77));
    }
}
