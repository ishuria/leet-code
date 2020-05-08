package arland;

/**
 * @author xiangchaolei
 */
public class LongestCommonSubsequence1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1+1][n2+1];
        for (int i = 0; i < n1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < n2; i++) {
            dp[0][n2] = 0;
        }

        for (int i = 1; i <=n1 ; i++) {
            for (int j = 1; j <= n2 ; j++) {
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        // write your code here
        LongestCommonSubsequence1143 a = new LongestCommonSubsequence1143();
        System.out.println(a.longestCommonSubsequence("abcde", "ace"));
        System.out.println(a.longestCommonSubsequence("abc", "abc"));
        System.out.println(a.longestCommonSubsequence("abc", "def"));
    }
}
