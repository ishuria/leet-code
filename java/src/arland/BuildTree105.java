package arland;

import sun.reflect.generics.tree.Tree;

import java.util.Arrays;

/**
 * @author xiangchaolei
 */
public class BuildTree105 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildInner(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildInner(int[] preorder,
                               int preStart, int preEnd,
                               int[] inorder,
                               int inStart, int inEnd) {
        int n = preEnd - preStart + 1;

        if (n == 0) {
            return null;
        }

        if (n == 1) {
            return new TreeNode(preorder[preStart]);
        }
        int root = preorder[preStart];
        TreeNode t = new TreeNode(root);
        int rootIndex = 0;

        for (int i = inStart; i < inStart + n; i++) {
            if (root == inorder[i]) {
                rootIndex = i;
            }
        }

        int leftSize = rootIndex - inStart;

        int rightSize = n - leftSize - 1;

        System.out.println();

        System.out.println(Arrays.toString(Arrays.copyOfRange(preorder, preStart + 1, preStart + leftSize + 1)));
        System.out.println(Arrays.toString(Arrays.copyOfRange(inorder, inStart, inStart + leftSize)));

        t.left = buildInner(preorder, preStart + 1, preStart + leftSize, inorder, inStart, inStart + leftSize - 1);


        System.out.println();

        System.out.println(Arrays.toString(Arrays.copyOfRange(preorder, preStart + leftSize + 1, preStart + leftSize + rightSize + 1)));
        System.out.println(Arrays.toString(Arrays.copyOfRange(inorder, rootIndex + 1, rootIndex + rightSize + 1)));

        t.right = buildInner(preorder, preStart + leftSize + 1, preStart + leftSize + rightSize, inorder, rootIndex + 1, rootIndex + rightSize);
        return t;
    }


    public static void main(String[] args) {
        // write your code here

        int[] p1 = {3, 9, 20, 15, 7};
        int[] i1 = {9, 3, 15, 20, 7};

        BuildTree105 a = new BuildTree105();
        TreeNode t = a.buildTree(p1, i1);
        return;
    }
}
