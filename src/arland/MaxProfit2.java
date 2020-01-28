package arland;

/**
 * @author xiangchaolei
 */
public class MaxProfit2 {

    public int maxProfit1(int[] prices){

        int n = prices.length;
        if(0 == n){
            return 0;
        }
        int max_k = 2;
        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >= 1; k--) {
                if (i - 1 == -1) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[0];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            }
        }
        return dp[n - 1][max_k][0];
    }


    public int maxProfit(int[] prices) {
        int m = prices.length;
        int[][] p = new int[m+1][m+1];
        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < m+1; j++) {
                p[i][j] = -1;
            }
        }

        int max = 0;
        for (int i = 0; i < m; i++) {
            if(0 == i){
                int a2 = p[i][m-1];
                if(a2==-1){
                    a2 = maxProfitInner(prices, i, m-1, p);
                }
                if(max < a2){
                    max = a2;
                }
                continue;
            }
            int a1 = p[0][i-1];
            if(a1==-1){
                a1 = maxProfitInner(prices, 0, i-1, p);
            }
            int a2 = p[i][m-1];
            if(a2==-1){
                a2 = maxProfitInner(prices, i, m-1, p);
            }
            if(max < a1+a2){
                max = a1+a2;
            }
        }
        return max;
    }

    public int maxProfitInner(int[] prices, int start, int end, int[][] p) {
        if(start>end){
            return 0;
        }
        int m = end - start + 1;
        int[] d = new int[prices.length];
        int[] e = new int[prices.length];

        int[] maxs = new int[m];
        for (int i = start; i < m + start; i++) {
            for (int j = i; j < m + start; j++) {
                if(start == i){
                    d[j] = prices[j] - prices[start]>0?prices[j] - prices[start]:0;
                    maxs[i-start] = Math.max(maxs[i-start], prices[j] - prices[i]);
                }
                else{
                    d[j] = Math.max(e[j-1], prices[j] - prices[i]);

                    maxs[i-start] = Math.max(maxs[i-start], prices[j] - prices[i]);
                }
            }
            e = d;
            d = new int[prices.length];
        }

        int r = 0;
        for (int k = 0; k < m; k++) {
            p[start+k][end] = maxs[k];
            if(r<maxs[k]){
                r = maxs[k];
            }
        }

        return r;
    }

    public static void main(String[] args) {
        // write your code here
        int[] prices1 = new int[]{3,3,5,0,0,3,1,4};
        int[] prices2 = new int[]{1,2,3,4,5};
        int[] prices3 = new int[]{7,6,4,3,1};
        int[] prices4 = new int[]{3,2,6,5,0,3};
        int[] prices5 = new int[]{2,1,2,0,1};


        // write your code here
        MaxProfit2 a = new MaxProfit2();
//        System.out.println(a.maxProfit(prices1));
//        System.out.println(a.maxProfit(prices2));
//        System.out.println(a.maxProfit(prices3));
//        System.out.println(a.maxProfit(prices4));
//        System.out.println(a.maxProfit(prices5));

        System.out.println(a.maxProfit1(prices1));
        System.out.println(a.maxProfit1(prices2));
        System.out.println(a.maxProfit1(prices3));
        System.out.println(a.maxProfit1(prices4));
        System.out.println(a.maxProfit1(prices5));
    }
}
