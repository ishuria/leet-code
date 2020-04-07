package arland;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiangchaolei
 */
public class GenerateTrees95 {

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> r = new ArrayList<>();
      if(n==0){
          return r;
      }
      if(n==1){
          r.add(new TreeNode(n));
          return r;
      }

        return innerGenerate(1,n);
    }

    private List<TreeNode> innerGenerate(int start, int end){
        List<TreeNode> r = new ArrayList<>();
      if(start>end){
          r.add(null);
          return r;
      }
        List<TreeNode> left = new ArrayList<>();
        List<TreeNode> right = new ArrayList<>();

        for (int i = start; i <=end; i++) {
            left = innerGenerate(start, i-1);
            right = innerGenerate(i+1, end);
            for (int i1 = 0; i1 < left.size(); i1++) {
                for (int i2 = 0; i2 < right.size(); i2++) {TreeNode T = new TreeNode(i);
                    T.left = left.get(i1);
                    T.right = right.get(i2);
                    r.add(T);
                }
            }
        }
        return r;
    }

    public static void main(String[] args) {
        // write your code here
        GenerateTrees95 a  = new GenerateTrees95();
        System.out.println(a.generateTrees(3));
    }
}
