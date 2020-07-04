package arland;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author xiangchaolei
 */
public class DistributeCoins {



    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
    }

    int ans = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }


    private int dfs(TreeNode root){
        if(null==root){
            return 0;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        ans += Math.abs(l)+Math.abs(r);
        return root.val+l+r-1;
    }

    public static void main(String[] args) {
        // write your code here
    }

}
