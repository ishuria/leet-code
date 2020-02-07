package arland;

/**
 * @author xiangchaolei
 */
public class CombinationSum4 {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<=target&&nums[i]>0){
                dp[nums[i]] = 1;
            }

        }
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i-nums[j]>0){
                    dp[i] += dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        // write your code here

        int[] a1 = {1, 2, 3};
        int t1 = 4;

        int[] a2 = {9};
        int t2 = 3;
        CombinationSum4 a = new CombinationSum4();
        System.out.println(a.combinationSum4(a1,t1));
        System.out.println(a.combinationSum4(a2,t2));


    }
}
