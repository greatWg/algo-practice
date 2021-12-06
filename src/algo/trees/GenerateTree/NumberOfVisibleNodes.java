package algo.trees.GenerateTree;

import java.io.IOException;
import java.util.*;

public class NumberOfVisibleNodes {

    class Node {
        int data;
        Node left;
        Node right;
        Node() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    // Add any helper functions you may need here
    int count=0;
    int data= 0;

    int visibleNodes(Node root) {
        // Write your code here
        // dfs ()

        if (root == null) {
            return 0;
        }

        Queue<Node> q= new LinkedList<>();
        List<Integer> res = new ArrayList<Integer>() ;
        q.add(root);

        while (!q.isEmpty()){
            //n = len(q)
            for (int i = 0; i < q.size(); i++) {
                Node node = q.remove();
                if (i == 0) {
                    res.add(node.data);
                   // printQueue(q);
                }
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
        }
        printList(res);
        return res.size();
//        int value = Integer.MIN_VALUE;
//        //int count = 0;
//       // Set<Node> nodes = calVisibleNode (root, value);
//        this.count=0;
//        preOrder(root,value);
//        //System.out.println (" node : "+  nodes.size());
//
//        return count;
    }

    private void printList(List<Integer> res) {
        for(int val: res){
            System.out.print( " "+  val );
        }
    }

    private void printQueue(Queue<Node> q) {
        Queue<Node> r= q;
        for (int i=0; i< r.size(); i++){
            System.out.print( " "+ q.remove().data );
        }
        System.out.println();
    }

    private void preOrder(Node root, int maxValue) {
        if (root== null){
            return;
        }

        if (root.data>=maxValue && root.data!= this.data){
            count++;
            maxValue= Math.max( root.data,maxValue);
            System.out.println(" : "  + root.data);
        }
        preOrder(root.left, maxValue);
        preOrder(root.right, maxValue);

    }

    public static void main(String[] args) {
        NumberOfVisibleNodes visibleNodesnode = new NumberOfVisibleNodes();
        try {
            visibleNodesnode.run();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void run() throws IOException {


        Queue<Node> q= new LinkedList<>();
        List<Integer> res = new ArrayList<Integer>() ;
        Node root_1 = new Node(8);
        root_1.left = new Node(3);
        root_1.right = new Node(10);
        root_1.left.left = new Node(1);
        root_1.left.right = new Node(6);
        root_1.right.right = new Node(14);
        root_1.left.right.left = new Node(4);
        root_1.left.right.right = new Node(7);
        root_1.right.right.left = new Node(13);
        int expected_1 = 4;
        int output_1 = visibleNodes(root_1);
        check(expected_1, output_1);

        Node root_2 = new Node(10);
        root_2.left = new Node(8);
        root_2.right = new Node(15);
        root_2.left.left = new Node(4);
        root_2.left.left.right = new Node(5);
        root_2.left.left.right.right = new Node(6);
        root_2.right.left = new Node(14);
        root_2.right.right = new Node(16);

        int expected_2 = 5;
        int output_2 = visibleNodes(root_2);
        check(expected_2, output_2);



        Node root_3 = new Node(5);
        root_3.left = new Node(3);
        root_3.right = new Node(10);

        root_3.left.left = new Node(20);
        root_3.left.right = new Node(21);
        root_3.right.left = new Node(1);
        // Add your own test cases here

        int expected_3 = 4;
        int output_3 = visibleNodes(root_3);
        check(expected_3, output_3);


    }

    int test_case_number = 1;
    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }

}
