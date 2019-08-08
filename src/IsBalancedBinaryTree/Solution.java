package IsBalancedBinaryTree;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ val = x;}
}

public class Solution {

    public static void main(String[] args){
        Integer num[] = new Integer[]{1,2,2,3,3,null,null,4,4};
        Integer pre[] = new Integer[]{1,2,4,5,6,7,3};
        Integer in[] = new Integer[]{4,2,6,5,7,1,3};

        Solution solution = new Solution();
        TreeNode tree = solution.createBinaryTree(num);
        solution.printTree(tree);

        int height = solution.height(tree);

        System.out.println();
        System.out.println(height);

        TreeNode newtree = solution.buildTreeFromInAndPreOrder(pre,in,0, in.length - 1);
        solution.printTree(newtree);
    }

    /*
     * Calculate the height of the tree
     */
    int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        return 1 + Math.max(left, right);
    }

    /*
     * Create binary tree from array
     */
    TreeNode createBinaryTree(Integer[] nums){

        TreeNode[] pointer = new TreeNode[nums.length];
        pointer[0] = new TreeNode(nums[0]);

        for(int i = 1; i < nums.length; i++){
            if(nums[i] != null){

                pointer[i] = new TreeNode(nums[i]);
                TreeNode parent = pointer[(i - 1) / 2];

                if(i % 2 == 1) {
                    parent.left = pointer[i];
                }else{
                    parent.right = pointer[i];
                }
            }
        }

        return pointer[0];
    }

    void printTree(TreeNode root){
        if(root == null){
            return;
        }

        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    /*
     * Build binary tree from inorder and preorder
     *
     * Start
     */
    private static int preIndex = 0;

    TreeNode buildTreeFromInAndPreOrder(Integer[] in, Integer[] pre, int start, int end){

        if(start > end)
            return null;

        TreeNode node = new TreeNode(pre[preIndex++]);

        if(start == end)
            return node;

        int inIndex = searchIndex(in, start, end, node.val);

        node.left = buildTreeFromInAndPreOrder(in, pre, start, inIndex - 1);
        node.right = buildTreeFromInAndPreOrder(in, pre, inIndex + 1, end);

        return node;
    }

    int searchIndex(Integer[] in, int start, int end, Integer value){

        int j;
        for(j = start; j < end; j++){
            if(in[j].equals(value)){
                return j;
            }
        }

        return j;
    }

    /*
     * Build binary tree from inorder and preorder
     *
     * End
     */
}

