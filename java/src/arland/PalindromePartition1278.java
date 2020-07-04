package arland;

/**
 * @author xiangchaolei
 */
public class PalindromePartition1278 {

    public int palindromePartition(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n+1][k+1];


        dp[1][1] = 0;
        //pre i to 1 p
        for (int i = 2; i <= n; i++) {
            dp[i][1] = cost(s.substring(0, i));
        }

        int min = 1000000;
        //i>=j
        for (int i = 2; i <=n ; i++) {
            for (int j = 2; j <=k&&j<=i ; j++) {
                //l>=j-1
                dp[i][j] = 1000000;
                for (int l = i-1; l >=j-1 ; l--) {
                    dp[i][j] = Math.min(dp[i][j], dp[l][j-1] + cost(s.substring(l, i)));
                }
                min = Math.min(min, dp[i][j]);
            }
        }
        return dp[n][k];
    }

    private int cost(String s){
        int n = s.length();
        int cost = 0;
        for (int i = 0; i < n/2; i++) {
            if(s.charAt(i)!=s.charAt(n-i-1)){
                cost++;
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        // write your code here
        PalindromePartition1278 a = new PalindromePartition1278();
        System.out.println(a.palindromePartition("abc",2));
        System.out.println(a.palindromePartition("aabbc",3));
        System.out.println(a.palindromePartition("leetcode",8));
    }
}
