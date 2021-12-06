package algo.Stacks;

import java.util.Stack;

public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {

        int[] output = new int[] {};
        Stack<Integer> stack = new Stack<Integer>();

        if (asteroids.length>0) {
            //stack.push(asteroids[0]);
            for (int i = 0; i < asteroids.length; i++) {
                stack.push(asteroids[i]);
            }
            int prev  = stack.pop();
            while(!stack.empty()){
                int current  = stack.pop();
                if (prev> current){ // 1

                }else if (prev< current){ // -5<10

                }else{
                   // prev
                }


            }
        }
        return output;

    }

    public static void main(String[] args) {
        AsteroidCollision ac= new AsteroidCollision();
        int[] ast= {5,10,-5};
        System.out.println("Asteroids:  "+ ac.asteroidCollision(ast));

        int[] ast1= {5,10,-5};
        System.out.println("Asteroids:  "+ ac.asteroidCollision(ast));


        int[] ast2= {5,10,-5};
        System.out.println("Asteroids:  "+ ac.asteroidCollision(ast));

        int[] ast3= {5,10,-5};
        System.out.println("Asteroids:  "+ ac.asteroidCollision(ast));

        int[] ast4= {5,10,-5};
        System.out.println("Asteroids:  "+ ac.asteroidCollision(ast));
    }
}