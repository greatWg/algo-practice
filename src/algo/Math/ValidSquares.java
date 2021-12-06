package algo.Math;

import java.util.HashSet;
import java.util.Set;

public class ValidSquares {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        Set<Integer> set = new HashSet<>();
        set.add(dist(p1,p2));
        set.add(dist(p1,p3));
        set.add(dist(p1,p4));
        set.add(dist(p2,p3));
        set.add(dist(p2,p4));
        set.add(dist(p3,p4));

        return set.size() == 2 && !set.contains(0);

    }
    public int dist(int[] p, int[] q){
        return (q[0]-p[0])*(q[0]-p[0]) + (q[1]-p[1])*(q[1]-p[1]);
    }

    public static void main(String[] args) {
        ValidSquares vs= new ValidSquares();

        System.out.println(vs.validSquare(new int []{1,0}, new int []{-1,0}, new int []{0,1}, new int[]{0,-1})); // 2 4
        System.out.println(vs.validSquare(new int []{1,0}, new int []{0,1}, new int []{0,-1}, new int[]{-1,0}));// 2 4
        System.out.println(vs.validSquare(new int []{6987,-473}, new int []{6985,-473}, new int []{6986,-472}, // 2,4
                new int[]{6986,-474}));
        System.out.println(vs.validSquare(new int []{0,0}, new int []{5,0}, new int []{5,4}, new int[]{0,4})); // 16, 25, 41
        System.out.println(vs.validSquare(new int []{0,1}, new int []{1,2}, new int []{0,2}, new int[]{0,0})); // 1, 2, 4 5


    }
}
