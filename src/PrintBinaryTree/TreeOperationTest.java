package PrintBinaryTree;

public class TreeOperationTest {
    public static void main(String[] args) {
        // 根据给定的数组创建一棵树
        TreeNode root = ConstructTree.constructTree(new Integer[] {1, 2, 3, 4, 5 ,6, 7});
        // 将刚刚创建的树打印出来
        TreeOperation.show(root);

        System.out.println();
        System.out.println();

        root = ConstructTree.constructTree(new Integer[] {5,4,8,11,null,13,4,7,2,null,null,null,1});
        TreeOperation.show(root);
    }
}