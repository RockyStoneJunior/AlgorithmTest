package BalancedBinarySearchTree;

import PrintBinaryTree.TreeNode;
import PrintBinaryTree.TreeOperation;

class AVLNode extends TreeNode {
    public int height;

    AVLNode(int val) {
        super(val);
        height = 1;
    }

    AVLNode() {
        height = 1;
    }
}

public class BalancedBinarySearchTree {

    AVLNode root;

    public static void main(String[] args) {
        BalancedBinarySearchTree tree = new BalancedBinarySearchTree();
        tree.root = tree.insert(tree.root, 10);
        TreeOperation.show(tree.root);
        System.out.print("\n\n\n");

        tree.root = tree.insert(tree.root, 20);
        TreeOperation.show(tree.root);
        System.out.print("\n\n\n");

        tree.root = tree.insert(tree.root, 30);
        TreeOperation.show(tree.root);
        System.out.print("\n\n\n");

        tree.root = tree.insert(tree.root, 40);
        TreeOperation.show(tree.root);
        System.out.print("\n\n\n");

        tree.root = tree.insert(tree.root, 50);
        TreeOperation.show(tree.root);
        System.out.print("\n\n\n");

        tree.root = tree.insert(tree.root, 25);
        TreeOperation.show(tree.root);
        System.out.print("\n\n\n");
    }

    AVLNode rightRotate(AVLNode y) {

        AVLNode x = (AVLNode) y.left;
        AVLNode T2 = (AVLNode) x.right;

        y.left = T2;
        x.right = y;

        x.height = Math.max(height(((AVLNode) x.left)), height(((AVLNode) x.right))) + 1;
        y.height = Math.max(height(((AVLNode) y.left)), height(((AVLNode) y.right))) + 1;

        return x;
    }

    AVLNode leftRotate(AVLNode x) {

        AVLNode y = (AVLNode) x.right;
        AVLNode T2 = (AVLNode) y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(((AVLNode) x.left)), height(((AVLNode) x.right))) + 1;
        y.height = Math.max(height(((AVLNode) y.left)), height(((AVLNode) y.right))) + 1;

        return y;
    }

    int height(AVLNode node){
        if(node == null){
            return 0;
        }

        return node.height;
    }

    int getBalance(AVLNode node) {
        if (node == null) {
            return 0;
        }

        return height((AVLNode) node.left) - height(((AVLNode) node.right));
    }

    AVLNode insert(AVLNode node, int val) {

        if (node == null) {
            return new AVLNode(val);
        }

        if (val < node.val) {
            node.left = insert((AVLNode) node.left, val);
        } else if (val > node.val) {
            node.right = insert((AVLNode) node.right, val);
        } else {
            return node;
        }

        node.height = Math.max(height((AVLNode) node.left), height(((AVLNode) node.right))) + 1;

        int balance = getBalance(node);

        if (balance > 1 && val < node.left.val) {
            return rightRotate(node);
        }

        if (balance < -1 && val > node.right.val) {
            return leftRotate(node);
        }

        if (balance > 1 && val > node.left.val) {
            node.left = leftRotate((AVLNode) node.left);
            return rightRotate(node);
        }

        if (balance < -1 && val < node.right.val) {
            node.right = rightRotate((AVLNode) node.right);
            return leftRotate(node);
        }

        return node;
    }
}
