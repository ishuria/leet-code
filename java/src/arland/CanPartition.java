package arland;

/**
 * @author xiangchaolei
 */
public class CanPartition {

    public boolean canPartition(int[] nums) {

        int n = nums.length;
        if (0==n||1==n){
            return false;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }

        boolean[][] dp = new boolean[sum+1][n+1];

        for (int j = 1; j <= sum; j++) {
            for (int i = 1; i <= n; i++) {
                dp[nums[i-1]][i] = true;
            }
        }
        //当求和为0时，全部都是false

        //当一个数都没有时，全部都是false

        //对每一样东西，可以选择放或者不放
        for (int j = 1; j <= sum; j++) {
            for (int i = 1; i <= n; i++) {
                //dp[i][j]代表前i个数字，生成了和为j的集合
                //如果前i-1个数字已经可以组成和为j的集合或者前i-1和数字可以组成和为j-nums[i-1]
                if(j-nums[i-1]>=1){
                    dp[j][i] = dp[j][i-1]||dp[j-nums[i-1]][i-1]||dp[j][i];
                }
                else{
                    dp[j][i] = dp[j][i-1]||dp[j][i];
                }
            }
        }

//        for (int j = 1; j <= sum; j++) {
//            for (int i = 1; i <= n; i++) {
//                System.out.print(dp[j][i]+" ");
//            }
//            System.out.println();
//        }

        return dp[sum/2][n];
    }



    public static void main(String[] args) {
        // write your code here
        int[] a1 = {1, 5, 11, 5};
        int[] a2 = {1, 2, 3, 5};
        int[] a3 = {1, 2, 5};

        CanPartition a = new CanPartition();
        System.out.println(a.canPartition(a1));
        System.out.println(a.canPartition(a2));
        System.out.println(a.canPartition(a3));
    }
}
