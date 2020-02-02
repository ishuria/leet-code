package arland;

/**
 * @author xiangchaolei
 */
public class NumSquares {

    public int numSquares(int n) {
        int[] ns = new int[n+1];
        for (int i = 1; i <= n; i++) {
            ns[i] = i*i;
        }

        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            //不超过i的完全平方数

            int index = 1;
            while(ns[index]<=i){
                index++;
            }index--;

            for (int j = index; j>=1 ; j--) {
                if(dp[i-ns[j]]<min){
                    min = dp[i-ns[j]];
                }
            }
            dp[i] = min+1;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        // write your code here
        NumSquares a = new NumSquares();
        System.out.println(a.numSquares(12));
        System.out.println(a.numSquares(13));
    }
}
