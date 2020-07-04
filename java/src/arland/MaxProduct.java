package arland;

/**
 * @author xiangchaolei
 */
public class MaxProduct {

    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(1 == n){
            return nums[0];
        }

        int max = nums[0], min = nums[0];

        int r = nums[0];

        for (int i = 1; i < n; i++) {
            if(nums[i] < 0){
                int t = max;
                max = min;
                min = t;
            }
            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);

            r = Math.max(r, max);
        }
        return r;
    }


    public static void main(String[] args) {
        // write your code here
        MaxProduct a = new MaxProduct();
        int[] a1 = new int[]{2,3,-2,4};
        int[] a2 = new int[]{-2,0,-1};
        int[] a3 = new int[]{-2,3,-4};
        int[] a4 = new int[]{2,-1,1,1};


        System.out.println(a.maxProduct(a1));
        System.out.println(a.maxProduct(a2));
        System.out.println(a.maxProduct(a3));
        System.out.println(a.maxProduct(a4));
    }
}
