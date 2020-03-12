package arland;

/**
 * @author xiangchaolei
 */
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(0 == n){
            return 0;
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max+1;
        }
        int r = dp[0];
        for (int i = 0; i < n; i++) {
            r = Math.max(r, dp[i]);
        }
        return r;
    }

    public static void main(String[] args) {
        // write your code here

        int[] a1 = new int[]{10,9,2,5,3,7,101,18};
        int[] a2 = new int[]{2,2};
        int[] a3 = new int[]{1,3,6,7,9,4,10,5,6};

        LengthOfLIS a = new LengthOfLIS();
        System.out.println(a.lengthOfLIS(a1));
        System.out.println(a.lengthOfLIS(a2));
        System.out.println(a.lengthOfLIS(a3));
    }
}
