package arland;

/**
 * @author xiangchaolei
 */
public class GetTargetCopy1379 {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return dfs(cloned, target);
    }

    private TreeNode dfs(TreeNode node, TreeNode target){
        if(node==null){
            return null;
        }
        if(node.val==target.val){
            return node;
        }
        TreeNode leftTarget = dfs(node.left, target);
        if(null!=leftTarget){
            return leftTarget;
        }
        TreeNode rightTarget = dfs(node.right, target);
        if(null!=rightTarget){
            return rightTarget;
        }
        return null;
    }



    public static void main(String[] args) {
        // write your code here


        TreeNode n7 = new TreeNode(7);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3);
        TreeNode n6 = new TreeNode(6);
        TreeNode n19 = new TreeNode(19);
        n7.left = n4;
        n7.right = n3;
        n3.left = n6;
        n3.right = n19;


        GetTargetCopy1379 a = new GetTargetCopy1379();
        System.out.println(a.getTargetCopy(n7,n7, n3).val);
    }
}
