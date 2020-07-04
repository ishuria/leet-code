package arland;

/**
 * @author xiangchaolei
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class GetAllElements {

     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
         //遍历1中的元素，并加入列表
        List<Integer> list1 = new ArrayList<>();
        dfs(root1, list1);
         //遍历2中的元素，并加入列表
        List<Integer> list2 = new ArrayList<>();
        dfs(root2, list2);
        //合并列表排序
        list1.addAll(list2);

        int[] elements = new int[list1.size()];
        for (int i = 0; i < list1.size(); i++) {
            elements[i] = list1.get(i);
        }

        int[] heap = new int[elements.length+1];

        System.arraycopy(elements, 0, heap, 1, elements.length);

//        heapSort(heap);
        qsort(elements, 0, elements.length-1);

        List<Integer> r = new ArrayList<>(elements.length);
        for (int i = 1; i < heap.length; i++) {
            r.add(heap[i]);
        }
        return r;
    }

    private void dfs(TreeNode root1, List<Integer> list){
         if(root1==null){
             return;
         }
         list.add(root1.val);
         dfs(root1.left, list);
         dfs(root1.right, list);
    }

    private void heapsort(int[] e){
         //e的第一个元素为空，从1-n
        for (int i = (e.length-1)/2; i >=1 ; i--) {
            adjustheap(e, i, e.length-1);
        }
        for (int i = e.length-1; i >=1 ; i--) {
            swap(e, i, 1);
            adjustheap(e, 1, i-1);
        }
    }

    private void swap(int[] e, int i1, int i2){
         int t = e[i1];
         e[i1] = e[i2];
         e[i2] = t;
    }

    private void adjustheap(int[] e, int s, int m){
         int t = e[s];
        for (int i = s*2; i <=m ; i*=2) {
            if(i<m&&e[i+1]>e[i]){
                i++;
            }
            if(e[i]<=t){
                break;
            }
            e[s] = e[i];
            s = i;
        }
        e[s] = t;
    }

    private void qsort(int[] e, int low, int high){
         if(low<high){
             int p = partition(e, low, high);
             qsort(e, low, p-1);
             qsort(e, p+1, high);
         }
    }

    private int partition(int[] e, int low, int high){
         int t = e[low];
         while (low<high){
             while (low<high&&e[high]>=t)high--;
             e[low] = e[high];
             while (low<high&&e[low]<=t)low++;
             e[high] = e[low];
         }
         e[low]=t;
         return low;
    }

    public static void main(String[] args) {
        // write your code here

        GetAllElements a = new GetAllElements();

        int[] heap = new int[]{1,0,1,2,4,3};
        int[] heap1 = new int[heap.length+1];
        System.arraycopy(heap, 0, heap1, 1, heap.length);
        a.qsort(heap, 0, heap.length-1);
        System.out.println(Arrays.toString(heap));

        a.heapsort(heap1);
        System.out.println(Arrays.toString(heap1));

    }
}