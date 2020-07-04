package arland;

/**
 * @author xiangchaolei
 */
public class FindKthLargest215 {

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        qsort(nums, 0, n-1);
//        int[] nums1 = new int[n];
//        int j = 0;
//        for (int i = 0; i < nums.length; i++) {
//            nums1[j] = nums[i];
//            while(i<n-1&&nums[i]==nums[i+1]){
//                i++;
//            }
//            j++;
//        }
//        return nums1[k-1];
        return nums[k-1];
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
            while(low<high&&nums[high]<=t){
                high--;
            }
            nums[low]=nums[high];
            while(low<high&&nums[low]>=t){
                low++;
            }
            nums[high]=nums[low];
        }
        nums[low]=t;
        return low;
    }

    public static void main(String[] args) {
        // write your code here

        FindKthLargest215 a = new FindKthLargest215();

        System.out.println(a.findKthLargest(new int[]{3,2,1,5,6,4}, 2));//5

        System.out.println(a.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));//4
    }
}
