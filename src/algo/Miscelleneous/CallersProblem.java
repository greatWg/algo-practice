package algo.Miscelleneous;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*

 VMWPS
 Given a function that returns all the callers of a given function, determine if function Z
 is eventually called by function A.

 Keep in mind recursive calls and loops are allowed between A and Z.

 BONUS:

 If there is one, can you print the sequence of calls from A to Z? (If there are many, print the one with less function calls.)

 What is the complexity of your solution?

 Sample run:

 assert isCalled("A", "Z") == True;


    Frontend  - (Customer facing )
            - Code medium to product - Application development
- Infrastructure - (Most important )



    Longest palindrome string


    Started at 11:
    Very creative thinkers
    Very sharp at checking the quality
*/

public class CallersProblem {
    static List<String> getCallers(String funcName) {
        Map<String, List<String>> map = new HashMap<>();
        map.put("A", Arrays.asList());
        map.put("B" ,Arrays.asList("A", "B", "C"));
        map.put("C" ,Arrays.asList("A", "B"));
        map.put("D" ,Arrays.asList("C"));
        map.put("Z" ,Arrays.asList("D", "B"));
        map.put("ami", Arrays.asList("D", "B"));


        return map.get(funcName);
    }

    static Boolean isCalled(String startFunc, String funcName)
    {
        // Z - D B -- >C ->  A- B C - (A
        // Z -> B ->C ->A
        // A - >Empty - false
        // Implement Adjancie list and

        //  Z -D - Z- B -> C --> A- B-C - --> Z<-
        /*TODO*/
        Queue<String>  queue= new LinkedList<String> ();
        queue.add(funcName);
        Set<String> set = new HashSet<>();

        while (!queue.isEmpty())
        {
            String element = queue.poll(); // Z  D  B
            set.add(element);
            List<String> connectedCaller=  getCallers(element); // z --> d, b.  -- D --> C
            if (connectedCaller.size()> 0){
                for( int i=0;  i< connectedCaller.size(); i++){ // D
                    if (connectedCaller.get(i) != startFunc ){ // D !=A , B!=A.    C!=A
                        if (!set.contains(connectedCaller.get(i))){
                            queue.add( connectedCaller.get(i)); //C
                        }
                    }else{
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void Test() {
        IsTrue(isCalled("A", "Z"), "A to Z is True ");
        IsFalse(isCalled("Z", "A"), "Z to A is False");
        IsFalse(isCalled("A", "A"), "A to A is False");
        IsTrue(isCalled("B", "B"), "B to B is True ");
        IsTrue(isCalled("B", "Z"), "B to Z is True ");
    }

    static void IsFalse(Boolean test, String testCaseName) {
        IsTrue(!test, testCaseName);
    }

    static void IsTrue(Boolean test, String testCaseName) {
            if (test) {
                System.out.println(testCaseName + " - PASS");
            }
            else {
                System.out.println(testCaseName + " - FAIL");
            }
        }

    public static void main(String[] args) {
        CallersProblem.Test();
    }



}




