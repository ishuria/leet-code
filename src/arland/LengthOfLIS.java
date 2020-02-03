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
            dp[i] = 1;
        }


        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if(nums[j]<nums[i]){
                    if(max<dp[j]){
                        max = dp[j];
                    }
                }
            }
            dp[i] = max+1;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if(max<dp[i]){
                max = dp[i];
            }
        }
        return max;
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
