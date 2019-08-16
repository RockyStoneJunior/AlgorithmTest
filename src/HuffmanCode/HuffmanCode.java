package HuffmanCode;

import PrintBinaryTree.TreeNode;
import PrintBinaryTree.TreeOperation;

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;


//class HuffmanNode {
//    char c;
//    int data;
//
//    HuffmanNode left;
//    HuffmanNode right;
//
//    HuffmanNode(){
//
//    }
//
//    HuffmanNode(char c, int data, HuffmanNode left, HuffmanNode right){
//        this.c = c;
//        this.data = data;
//        this.left = left;
//        this.right = right;
//    }
//}

class HuffmanNode extends TreeNode {
    char c;

    HuffmanNode(){

    }

    HuffmanNode(char c, int data, HuffmanNode left, HuffmanNode right){
        this.c = c;
        this.val = data;
        this.left = left;
        this.right = right;
    }
}

class MyComparator implements Comparator<HuffmanNode>{

    public int compare(HuffmanNode x, HuffmanNode y){
        return x.val - y.val;
    }
}

public class HuffmanCode {

    public static void main(String[] args) {
        HuffmanCode huffmanCode = new HuffmanCode();
        huffmanCode.huffmanCode(new char[]{'a', 'b', 'c', 'd', 'e', 'f' }, new int[]{5, 9, 12, 13, 16, 45});
    }


    void printCode(HuffmanNode root, String s) {

        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + ": " + s);
            return;
        }

        printCode((HuffmanNode) root.left, s + "0");
        printCode((HuffmanNode) root.right, s + "1");
    }

    public Map<Character, String> huffmanCode(char[] charArr, int[] freqArr) {

        if(charArr.length != freqArr.length){
            return null;
        }

        int n = charArr.length;

        PriorityQueue<HuffmanNode> q = new PriorityQueue<>(n, new MyComparator());

        for(int i = 0; i < n; i++){
            q.add(new HuffmanNode(charArr[i], freqArr[i], null, null));
        }

        HuffmanNode root = null;

        while(q.size() > 1){

            HuffmanNode x = q.peek();
            q.poll();

            HuffmanNode y = q.peek();
            q.poll();

            HuffmanNode f = new HuffmanNode('-', x.val + y.val, x, y);

            root = f;
            q.add(f);
        }

        printCode(root, "");

        TreeOperation.show(root);

        return null;
    }
}
