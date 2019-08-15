package BalancedBinarySearchTree;

import PrintBinaryTree.TreeNode;
import PrintBinaryTree.TreeOperation;

public class BinarySearchTree {

    public static void main(String[] args){

        TreeOperation.show(new BinarySearchTree().buildBSTFromArray(new int[]{6,7,9,2,10,3,5}));
    }


    public TreeNode buildBSTFromArray(int[] arr){

        TreeNode tree = new TreeNode(arr[0]);

        for(int i = 1; i < arr.length; i++){
            insertTreeNode(tree, arr[i]);
        }

        return tree;
    }

    public void insertTreeNode(TreeNode root, int val){

        if(root == null){
            return;
        }

        if(val < root.val){
            if(root.left != null){
                insertTreeNode(root.left, val);
            }else {
                root.left = new TreeNode(val);
            }

        }else {
            if(root.right != null){
                insertTreeNode(root.right, val);
            }else {
                root.right = new TreeNode(val);
            }
        }
    }
}
