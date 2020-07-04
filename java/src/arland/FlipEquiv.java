package arland;

/**
 * @author xiangchaolei
 */
public class FlipEquiv {

     public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
         if(root1.val!=root2.val){
             return false;
         }
         return flipEquiv(root1.left, root2.right)&&flipEquiv(root1.right, root2.left);
    }

    public static void main(String[] args) {
        // write your code here



    }

}
