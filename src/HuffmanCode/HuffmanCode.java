package HuffmanCode;

import PrintBinaryTree.TreeNode;
import PrintBinaryTree.TreeOperation;

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.HashMap;
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
        HuffmanNode root = huffmanCode.huffmanCode(new char[]{'a', 'b', 'c', 'd', 'e', 'f' }, new int[]{5, 9, 12, 13, 16, 45});

        huffmanCode.printCode(root, "");
        TreeOperation.show(root);

        //System.out.println(huffmanCode.huffmanDecode(root, "01001111000011111010101010101001010"));


        Map<Character, String> codeMap = huffmanCode.getCodeMap(root, new HashMap<Character, String>(), "");
        System.out.println(codeMap.toString());

        String code = huffmanCode.getCode(codeMap, "abcdef");
        System.out.println(code);
        System.out.println(huffmanCode.huffmanDecode(root, code));
    }


    void printCode(HuffmanNode root, String s) {

        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + ": " + s);
            return;
        }

        printCode((HuffmanNode) root.left, s + "0");
        printCode((HuffmanNode) root.right, s + "1");
    }

    public Map<Character, String> getCodeMap(HuffmanNode root, Map<Character, String> map, String s){

        if (root.left == null && root.right == null) {

            map.put(root.c, s);
            return map;
        }

        getCodeMap((HuffmanNode) root.left, map, s + "0");
        getCodeMap((HuffmanNode) root.right, map, s + "1");

        return map;
    }

    public String getCode(Map<Character, String> codeMap, String s){

        char[] charArr = s.toCharArray();
        String result = new String();

        for(char c : charArr){
            result += codeMap.get(c);
        }

        return result;
    }

    public HuffmanNode huffmanCode(char[] charArr, int[] freqArr) {

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

//            HuffmanNode x = q.peek();
//            q.poll();
//
//            HuffmanNode y = q.peek();
//            q.poll();

            HuffmanNode x = q.poll();

            HuffmanNode y = q.poll();

            HuffmanNode f = new HuffmanNode('-', x.val + y.val, x, y);

            root = f;
            q.add(f);
        }

        return root;
    }

    public String huffmanDecode(HuffmanNode root, String code){

        int len = code.length();
        HuffmanNode currNode = root;
        StringBuffer result = new StringBuffer();

        for(int i = 0; i < len; i++){
            if(code.charAt(i) == '0'){
                currNode = (HuffmanNode) currNode.left;
            }else{
                currNode = (HuffmanNode) currNode.right;
            }

            if(currNode.left == null && currNode.right == null){
                result.append(currNode.c);
                currNode = root;
            }
        }

        return result.toString();
    }
}
