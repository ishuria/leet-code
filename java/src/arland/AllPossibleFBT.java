package arland;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author xiangchaolei
 */
public class AllPossibleFBT {

    Map<Integer, List<TreeNode>> m = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> ret = new ArrayList<>();
        if(N==0){
            return null;
        }
        if(1==N){
            ret.add(new TreeNode(0));
            return ret;
        }
        //根节点
        N-=1;
        for (int i = 1; i <=N-1; i++) {
            if(i%2==0||(N-i)%2==0){
                continue;
            }
            List<TreeNode> lefts = allPossibleFBT(i);
            List<TreeNode> rights = allPossibleFBT(N-i);
            for (int j = 0; j < lefts.size(); j++) {
                for (int k = 0; k < rights.size(); k++) {
                    TreeNode node = new TreeNode(0);
                    node.left = lefts.get(j);
                    node.right = rights.get(k);
                    ret.add(node);
                }
            }
        }
        m.put(N, ret);
        return m.get(N);
    }

    private TreeNode buildSubTree(int N){
        if(N==0){
            return null;
        }
        if(1==N){
            return new TreeNode(0);
        }

        TreeNode node = new TreeNode(0);
        N-=1;
        for (int i = 1; i <= N-1; i++) {
            int leftNumber = i;
            int rightNumber = N-i;

            if(leftNumber==2||rightNumber==2){
                continue;
            }

            TreeNode left = buildSubTree(leftNumber);
            TreeNode right = buildSubTree(rightNumber);
            node.left = left;
            node.right = right;
        }
        return node;
    }

    private void printTree(List<TreeNode> t){
        for (int i = 0; i < t.size(); i++) {
            Queue<TreeNode> q = new LinkedBlockingQueue<>();
            TreeNode n = t.get(i);
            q.add(n);
            System.out.print("[");
            System.out.print(n.val + ",");
            while(!q.isEmpty()){
                TreeNode temp = q.poll();
                if(temp.left!=null){
                    q.offer(temp.left);
                    System.out.print(temp.left.val + ",");
                }
                else{
                    System.out.print(  "null,");
                }
                if(temp.right!=null){
                    q.offer(temp.right);
                    System.out.print(temp.right.val + ",");
                }
                else{
                    System.out.print(  "null,");
                }
            }
            System.out.print("],");
            System.out.println();
        }
    }

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    public static void main(String[] args) {
        // write your code here

        AllPossibleFBT a = new AllPossibleFBT();
        //[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
        a.printTree(a.allPossibleFBT(7));
    }


}
