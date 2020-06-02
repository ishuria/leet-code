package arland;

/**
 * @author xiangchaolei
 */
public class IntegerBreak343 {

    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[i-j]*j, j*(i-j)));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        // write your code here
        IntegerBreak343 a = new IntegerBreak343();
        System.out.println(a.integerBreak(2));
        System.out.println(a.integerBreak(3));
        System.out.println(a.integerBreak(10));
    }
}
