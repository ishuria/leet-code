package arland;

/**
 * @author xiangchaolei
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[] dp = new int[amount+1];
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            dp[i] = -1;
        }

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < n; j++) {
                if(i-coins[j] >= 0){
                    if(dp[i]==-1){
                        if(dp[i-coins[j]]!=-1){
                            dp[i] = dp[i-coins[j]]+1;
                        }
                    }
                    else{
                        if(dp[i-coins[j]]!=-1){
                            dp[i] = Math.min(dp[i-coins[j]]+1,dp[i]);
                        }
                    }
                }
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        // write your code here
        int[] a1 = new int[]{1, 2, 5};
        int b1=11;

        int[] a2 = new int[]{2};
        int b2=3;

        int[] a3 = new int[]{2};
        int b3=1;


        int[] a4 = new int[]{186,419,83,408};
        int b4=6249;


        CoinChange a = new CoinChange();
        System.out.println(a.coinChange(a1,b1));
        System.out.println(a.coinChange(a2,b2));
        System.out.println(a.coinChange(a3,b3));
        System.out.println(a.coinChange(a4,b4));
    }
}
