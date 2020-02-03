package arland;

/**
 * @author xiangchaolei
 */
public class MaxCoins {

    public int maxCoins(int[] nums) {
        int n = nums.length;
        if(0 == n){
            return 0;
        }

        int[] a = new int[nums.length+2];


        int[][] dp = new int[n+2][n+2];

        for (int i = 0; i < n; i++) {
            a[i+1] = nums[i];
        }
        a[0]=1;
        a[n+1]=1;

//        for (int i = 1; i <= n; i++) {
//            dp[i][i] = a[i-1]*a[i]*a[i+1];
//        }
//
        for (int i = 0; i < n+1; i++) {
            dp[i][i+1] = 0;
        }
//
//        dp[n-1][n] = Math.max(dp[n-1][n-1] + a[n-2]*a[n]*a[n+1], dp[n][n] + a[n-1]);



//        for (int i = 0; i < n+2; i++) {
//            for (int j = 0; j < n+2; j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
//
//        System.out.println();

        for (int len = 3; len <= n + 2; len++) {
            for (int i = 0; i <= n + 2 - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MIN_VALUE;
                for (int k = i + 1; k <= j - 1; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + a[i] * a[k] * a[j]);
                }
            }
        }
        return dp[0][n + 1];

    }

    public static void main(String[] args) {
        // write your code here

        int[] a1 = new int[]{3,1,5,8};
        MaxCoins a = new MaxCoins();
        System.out.println(a.maxCoins(a1));
    }
}
