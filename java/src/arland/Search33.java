package arland;

/**
 * @author xiangchaolei
 */
public class Search33 {


    public int search(int[] nums, int target) {
        int n = nums.length;
        if(0==n){
            return -1;
        }
        if (n == 1)
            return nums[0] == target ? 0 : -1;
        int low = min(nums);
        int high = low-1;
        if(low==0){
            high = nums.length-1;
        }
        if(target>nums[n-1]){
            return midsearch(nums, 0, high, target);
        }
        else{
            return midsearch(nums, low, n-1, target);
        }
    }

    private int midsearch(int[] nums, int low, int high, int target){
        while(low<=high){
            int m = (low+high)/2;
            if(nums[m] == target){
                return m;
            }
            if(nums[m]>target){
                high = m-1;
            }
            else{
                low = m+1;
            }
        }
        return -1;
    }

    private int min(int[] nums){
        int left = 0, right = nums.length-1;
        if (nums[left] < nums[right])
            return 0;

        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] > nums[pivot + 1])
                return pivot + 1;
            else {
                if (nums[pivot] < nums[left])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        // write your code here

        Search33 a = new Search33();

        int[] a1 = {4,5,6,7,0,1,2};

        System.out.println(a.search(a1, 3));


        int[] a2 = {1};

        System.out.println(a.search(a2, 1));

        int[] a3 = {1,3};

        System.out.println(a.search(a3, 3));

        int[] a4 = {6,7,8,1,2,3,4,5};

        System.out.println(a.search(a4, 6));

    }
}
