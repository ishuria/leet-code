package arland;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiangchaolei
 */
public class FourSum18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        qsort(nums, 0, n-1);
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i <= n-4; i++) {
            int t = nums[i];
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            List<List<Integer>> sub = threeSum(nums, i+1, target - t);
            if(!sub.isEmpty()){
                for (int i1 = 0; i1 < sub.size(); i1++) {
                    sub.get(i1).add(0, t);
                }
                ret.addAll(sub);
            }
        }
        return ret;
    }

    private List<List<Integer>> threeSum(int[] nums, int start, int target) {
        int n = nums.length;
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = start; i <= n-3; i++) {
            int t = nums[i];
            if(i > start && nums[i] == nums[i-1]){
                continue;
            }
            int l = i+1;
            int r = n-1;
            while(l<r){
                if(nums[l]+t+nums[r]==target){
                    List<Integer> sub = new ArrayList<>();
                    sub.add(t);
                    sub.add(nums[l]);
                    sub.add(nums[r]);
                    ret.add(sub);
                    while(l<r&&nums[l]==nums[l+1]){
                        l++;
                    }
                    l++;
                    while(l<r&&nums[r]==nums[r-1]){
                        r--;
                    }
                    r--;
                }
                else if(nums[l]+t+nums[r]>target){
                    r--;
                }
                else{
                    l++;
                }
            }
        }
        return ret;
    }

    private void qsort(int[] nums, int low, int high){
        if(low<high){
            int p = partition(nums, low, high);
            qsort(nums, low, p-1);
            qsort(nums, p+1, high);
        }
    }

    private int partition(int[] nums, int low, int high){
        int t = nums[low];
        while(low<high){
            while(low<high&&nums[high]>=t){
                high--;
            }
            nums[low]=nums[high];
            while(low<high&&nums[low]<=t){
                low++;
            }
            nums[high]=nums[low];
        }
        nums[low]=t;
        return low;
    }

    private void print(List<List<Integer>> l){
        for (int i = 0; i < l.size(); i++) {
            List<Integer> ll = l.get(i);
            for (int i1 = 0; i1 < ll.size(); i1++) {
                System.out.print(ll.get(i1) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // write your code here
        //nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
        //  [-1,  0, 0, 1],
        //  [-2, -1, 1, 2],
        //  [-2,  0, 0, 2]
        FourSum18 a = new FourSum18();
        a.print(a.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));



        //[-3,-2,-1,0,0,1,2,3]
        //0
        //[[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        a.print(a.fourSum(new int[]{-3,-2,-1,0,0,1,2,3}, 0));

        //[0,0,0,0]
        //0
        a.print(a.fourSum(new int[]{0,0,0,0}, 0));

        //[-1,-5,-5,-3,2,5,0,4]
        //[-5,-5,-3,-1,0,2,4,5]
        //-7
        //[[-5,-5,-1,4],[-5,-3,-1,2]]
        a.print(a.fourSum(new int[]{-1,-5,-5,-3,2,5,0,4}, -7));
    }
}
