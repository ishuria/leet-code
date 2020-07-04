package arland;

import java.util.*;

/**
 * @author xiangchaolei
 */
public class ThreeSum15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        int n = nums.length;
        qsort(nums, 0, n-1);
        for (int i = 0; i < n; i++) {
            int t = nums[i];
            if(t>0){
                break;
            }
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int l = i+1;
            int r = n-1;
            while(l<r){
                int sum = t + nums[l]+nums[r];
                if(sum==0){
                    List<Integer> sub = new ArrayList<>(3);
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
                else if(sum>0){
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
        nums[low] = t;
        return low;
    }


//    public List<List<Integer>> threeSum(int[] nums) {
//        int n = nums.length;
//        qsort(nums, 0, n-1);
//        List<List<Integer>> r = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            List<List<Integer>> twoSumList = twoSum(nums, i);
//            if(twoSumList.size()>0){
//                for (int i1 = 0; i1 < twoSumList.size(); i1++) {
//                    twoSumList.get(i1).add(nums[i]);
//                }
//                r.addAll(twoSumList);
//            }
//        }
//
//        for (int i = 0; i < r.size(); i++) {
//            Collections.sort(r.get(i));
//        }
//
//        Set<String> s = new HashSet<>();
//        for (int i = 0; i < r.size(); i++) {
//            String key = key(r.get(i));
//            if(s.contains(key)){
//                r.remove(i);
//                i--;
//            }
//            else{
//                s.add(key);
//            }
//        }
//
//        return r;
//    }

    private String key(List<Integer> l){
        char[] c = new char[l.size()];
        for (int i = 0; i < l.size(); i++) {
            c[i] = l.get(i).toString().charAt(0);
        }
        return new String(c);
    }

    public List<List<Integer>> twoSum(int[] nums, int i) {
        int target = 0 - nums[i];
        List<List<Integer>> r = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            List<Integer> rr = new ArrayList<>();
            for (int k = 0; k < j; k++) {
                if((nums[j]+nums[k])==target){
                    rr.add(nums[j]);
                    rr.add(nums[k]);
                    r.add(rr);
                    break;
                }
            }
        }
        return r;
    }

    private void print(List<List<Integer>> lists){
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> l = lists.get(i);
            for (int i1 = 0; i1 < l.size(); i1++) {
                System.out.print(l.get(i1)+" , ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // write your code here
        int[] nums1 = {-1, 0, 1, 2, -1, -4};

        int[] nums2 = {0,0,0,0};

        int[] nums3 = {-1,0,1,0};//-1,0,0,1

        int[] nums4 = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};

        ThreeSum15 a = new ThreeSum15();
        a.print(a.threeSum(nums1));
        a.print(a.threeSum(nums2));
        a.print(a.threeSum(nums3));
        a.print(a.threeSum(nums4));
    }

}
