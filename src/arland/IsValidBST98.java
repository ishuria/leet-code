package arland;

/**
 * @author xiangchaolei
 */
public class IsValidBST98 {


    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public boolean isValidBST(TreeNode root) {
        return inner(root, null, null);
    }

    private boolean inner(TreeNode root, Integer lower, Integer upper){
        if(root==null){
            return true;
        }
        if(lower!=null&&root.val<=lower){
            return false;
        }
        if(upper!=null&&root.val>=upper){
            return false;
        }
        if(!inner(root.left, lower, root.val)){
            return false;
        }
        if(!inner(root.right, root.val, upper)){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // write your code here

        IsValidBST98 a = new IsValidBST98();

        TreeNode r12 = new TreeNode(2);
        TreeNode r11 = new TreeNode(1);
        TreeNode r13 = new TreeNode(3);
        r12.left=r11;
        r12.right=r13;
        System.out.println(a.isValidBST(r12));

        TreeNode r25 = new TreeNode(5);
        TreeNode r21 = new TreeNode(1);
        TreeNode r24 = new TreeNode(4);
        TreeNode r23 = new TreeNode(3);
        TreeNode r26 = new TreeNode(6);
        r25.left=r21;
        r25.right=r24;
        r21.left = r23;
        r21.right = r26;
        System.out.println(a.isValidBST(r25));

        //[10,5,15,null,null,6,20]

        TreeNode r310 = new TreeNode(10);
        TreeNode r35 = new TreeNode(5);
        TreeNode r315 = new TreeNode(15);
        TreeNode r36 = new TreeNode(6);
        TreeNode r320 = new TreeNode(20);
        r310.left=r35;
        r310.right=r315;
        r315.left = r36;
        r315.right = r320;
        System.out.println(a.isValidBST(r310));

    }


}
