package arland;

/**
 * @author xiangchaolei
 */
public class MinimumDeleteSum {


    public int minimumDeleteSum(String s1, String s2) {

        int n1 = s1.length();
        int n2 = s2.length();

        int[][] dp = new int[n1+1][n2+1];

        int sum = 0;
        for (int i = 1; i <= n1; i++) {
            sum+=(int)s1.charAt(i-1);
            dp[i][0] = sum;
        }
        sum = 0;
        for (int i = 1; i <= n2; i++) {
            sum+=(int)s2.charAt(i-1);
            dp[0][i] = sum;
        }

        dp[0][0] = 0;

        for (int i = 1; i <=n1 ; i++) {

            for (int j = 1; j <=n2 ; j++) {
                if(i==3&&j==3){
                    System.out.println();
                }
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(
                            dp[i][j-1]+s2.charAt(j-1),dp[i-1][j]+s1.charAt(i-1)
                    ));
                }
                else{
                    dp[i][j] = Math.min(
                            dp[i][j-1]+s2.charAt(j-1),dp[i-1][j]+s1.charAt(i-1)
                    );
                }
            }
        }

        return dp[n1][n2];

    }

    public static void main(String[] args) {
        // write your code here


        String s11 = "sea", s12 = "eat";
        String s21 = "delete", s22 = "leet";


        MinimumDeleteSum a = new MinimumDeleteSum();
        System.out.println(a.minimumDeleteSum(s11,s12));
        System.out.println(a.minimumDeleteSum(s21,s22));
    }

}
