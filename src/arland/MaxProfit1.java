package arland;

/**
 * @author xiangchaolei
 */
public class MaxProfit1 {

    //dp[i][k][0] 今天是第i天，还能交易k次，手中未持有股票
    //dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + price[i])

    //dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - price[i])

    public int maxProfit1(int[] prices) {
        int m = prices.length;
        int dp0 = 0;
        int dp1 = 0;
        for (int i = 0; i < m; i++) {
            if(0 == i){
                dp0 = 0;
                dp1 = 0-prices[0];
            }
            else{
                dp0 = Math.max(dp0, dp1 + prices[i]);
                dp1 = Math.max(dp1, 0 - prices[i]);
            }
        }
        return dp0;
    }

    public int maxProfit(int[] prices) {
        int m = prices.length;
        int[] d = new int[m];
        int[] e = new int[m];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                if(0 == i){
                    d[j] = prices[j] - prices[0]>0?prices[j] - prices[0]:0;
                }
                else{
                    d[j] = Math.max(e[j-1], prices[j] - prices[i]);
                }
                if(d[j]>max){
                    max = d[j];
                }
            }
            e = d;
            d = new int[m];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices1 = new int[]{7,1,5,3,6,4};
        int[] prices2 = new int[]{7,6,4,3,1};
        // write your code here
        MaxProfit1 a = new MaxProfit1();
        System.out.println(a.maxProfit(prices1));
        System.out.println(a.maxProfit(prices2));

        System.out.println(a.maxProfit1(prices1));
        System.out.println(a.maxProfit1(prices2));
    }
}
