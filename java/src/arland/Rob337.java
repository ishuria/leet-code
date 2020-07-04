package arland;

/**
 * @author xiangchaolei
 */
public class Rob337 {

  public static class TreeNode {
           int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public int rob(TreeNode root) {
        return rob(root, true);
    }

    public int rob(TreeNode root, boolean canRob){
      if(null==root){
          return 0;
      }

        if(canRob){
            return Math.max(
                    //rob
                    root.val + rob(root.left, false) + rob(root.right, false),
                    //not rob
                    rob(root.left, true) + rob(root.right, true)
                    );
        }
        else{
            return rob(root.left, true)+rob(root.right, true);
        }
    }


    public static void main(String[] args) {
        // write your code here

        TreeNode n11 = new TreeNode(3);
        TreeNode n12 = new TreeNode(2);
        TreeNode n13 = new TreeNode(3);
        TreeNode n14 = new TreeNode(3);
        TreeNode n15 = new TreeNode(1);

        n11.left = n12;
        n11.right = n13;
        n12.right = n14;
        n13.right = n15;


        Rob337 a = new Rob337();

        System.out.println(a.rob(n11));
    }
}
