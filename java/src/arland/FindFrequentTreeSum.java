package arland;

import java.util.*;

/**
 * @author xiangchaolei
 */
public class FindFrequentTreeSum {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


    Map<Integer, Integer> count = new HashMap<>();
    Map<TreeNode, Integer> sum = new HashMap<>();
    int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        find(root);
        List<Integer> ret = new ArrayList<>();
        count.keySet().forEach(key->{
            if(count.get(key)==max){
                ret.add(key);
            }
        });
        Integer[] a = ret.toArray(new Integer[0]);
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        return b;
    }

    //返回值和出现次数
    public void find(TreeNode n){
        if(n==null){
            return;
        }

        find(n.left);
        find(n.right);

        int rootSum = 0;
        if(n.left!=null&&n.right!=null){
           rootSum = n.val+sum.get(n.left)+sum.get(n.right);
        }
        else if(n.left!=null){
            rootSum = n.val+sum.get(n.left);
        }
        else if(n.right!=null){
            rootSum = n.val+sum.get(n.right);
        }
        else{
            rootSum = n.val;
        }
        sum.put(n, rootSum);

        if(count.containsKey(rootSum)){
            count.put(rootSum, count.get(rootSum)+1);
            max = Math.max(max, count.get(rootSum));
        }
        else{
            count.put(rootSum,1);
            max = Math.max(max, 1);
        }
    }

    public static void main(String[] args) {
        // write your code here
        FindFrequentTreeSum a = new FindFrequentTreeSum();

        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(14);
        root1.left.left = new TreeNode(1);

        System.out.println(Arrays.toString(a.findFrequentTreeSum(root1)));
    }

}
