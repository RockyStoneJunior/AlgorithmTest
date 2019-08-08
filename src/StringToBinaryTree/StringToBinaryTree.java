package StringToBinaryTree;

import java.util.Stack;

/*
 * @Author: Rocky Stone
 * @Problem: convert string to binary tree
 *
 * @Example: 你需要从一个包括括号和整数的字符串构建一棵二叉树。
 *            输入的字符串代表一棵二叉树。它包括整数和随后的0，1或2对括号。整数代表根的值，一对括号内表示同样结构的子树。
 *            若存在左子结点，则从左子结点开始构建。
 *            输入: "4(2(3)(1))(6(5))"
 *            输出: 返回代表下列二叉树的根节点:
 *
 *                      4
 *                    /   \
 *                   2     6
 *                  / \   /
 *                 3   1 5
 */

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x){
        val = x;
    }
}

public class StringToBinaryTree {
    public static void main(String[] args){
        StringToBinaryTree stringToBinaryTree = new StringToBinaryTree();
        TreeNode tree = stringToBinaryTree.str2tree("4(2(3)(1))(6(5))");
        stringToBinaryTree.printTreePreOrder(tree);
    }

    public TreeNode str2tree(String s){
        if(s == null || s.length() == 0)
            return null;

        Stack<TreeNode> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')') stack.pop();
            else if(s.charAt(i) >= '0' && s.charAt(i) <= '9' || s.charAt(i) == '-'){
                int start = i;

                while(i < s.length() - 1 && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9'){
                    i++;
                }

                TreeNode root = new TreeNode(Integer.valueOf(s.substring(start, i + 1)));

                if(!stack.empty()){
                    TreeNode parent = stack.peek();
                    if(parent.left == null) parent.left = root;
                    else parent.right = root;
                }

                stack.push(root);
            }
        }

        if(stack.isEmpty()) return null;
        return stack.peek();
    }

    void printTreePreOrder(TreeNode tree){

        if(tree == null){
            return;
        }

        System.out.print(tree.val + " ");
        printTreePreOrder(tree.left);
        printTreePreOrder(tree.right);
    }
}