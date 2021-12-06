package algo.trees.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageLevelsBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> output = new ArrayList<Double>() ;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()){
            long sum=0, count=0;
            Queue<TreeNode> temp = new LinkedList<>();
            while(!queue.isEmpty()){
                TreeNode current = queue.remove();
                sum += current.val;
                count++;
                if (current.left != null){
                    temp.add(current.left);
                }
                if (current.right != null ) {
                    temp.add(current.right);
                }
            }
            queue = temp;
            output.add( sum * 1.0 / count);
        }
        return output;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        AverageLevelsBinaryTree tree = new AverageLevelsBinaryTree();
        printAverage(tree.averageOfLevels(root));


        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(5);

        root2.left.left  = new TreeNode(0);
        root2.left.right = new TreeNode(2);

        root2.right.left  = new TreeNode(4);
        root2.right.right = new TreeNode(6);

        printAverage(tree.averageOfLevels(root2));
    }

    private static void printAverage(List<Double> output) {

        System.out.print( "[ ");
        for (Double x : output){
            System.out.print( x+  " , ");
        }
        System.out.print( " ]");
    }
}
