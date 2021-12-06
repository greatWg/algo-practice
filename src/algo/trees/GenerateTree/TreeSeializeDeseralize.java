package algo.trees.GenerateTree;

import java.util.ArrayList;
import java.util.List;

public class TreeSeializeDeseralize {

    String[] data;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return "";
        }
        //inorder traversal
        List<String> data= new ArrayList<String>();
        this.preTraversal(root,data);
        return String.join(",", data);
    }

    public void preTraversal(TreeNode root,List<String> data){
        if (root==null){
            return;
        }
        else{
            data.add(""+root.val);
            preTraversal(root.left, data);
            preTraversal(root.right, data);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //List<Integer> list= new ArrayList<Integer>();
        if (data == null || data.equals("") ){
            return null;
        }

        String[] array = data.split(",");
        TreeNode root = null ;

        for (int i=0; i< array.length; i++){

            if (root == null){
                root = new TreeNode(Integer.parseInt(array[i].trim()));
            }else{
                preOrderTraversal(root, Integer.parseInt(array[i].trim()));
            }
        }
        return root;
    }

    public void preOrderTraversal(TreeNode root, int value){

        if (value > root.val ){
            if (root.right==null){
                root.right=  new TreeNode(value);
            }else {
                preOrderTraversal( root.right, value);
            }
        }
        if (value < root.val ){
            if (root.left==null){
                root.left=  new TreeNode(value);
            }
            else {
                preOrderTraversal( root.left, value);
            }
        }
    }

    public static void main(String[] args){
        //Your Codec object will be instantiated and called as such:
        TreeSeializeDeseralize ser = new TreeSeializeDeseralize();
        TreeSeializeDeseralize deser = new TreeSeializeDeseralize();

        // input is [2, 1,3]
        TreeNode root = new TreeNode(1);
        root.left=  new TreeNode(2);
        root.right= new TreeNode(3 );
        String tree = ser.serialize(root);
        System.out.println ( "tree :  "+ tree);
        TreeNode ans = deser.deserialize(tree);
        System.out.println ( "ans is ");
    }

}



