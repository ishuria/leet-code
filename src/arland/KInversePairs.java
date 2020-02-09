package arland;

/**
 * @author xiangchaolei
 */
public class KInversePairs {


    public int kInversePairs(int n, int k) {

        long M = 1000000007;

        if(0==k){
            return 1;
        }

        long[][] dp = new long[n+1][k+1];


        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= k ; j++) {
                for (int l = 0; l <= i-1 && j-l >=0; l++) {
                    dp[i][j] += dp[i-1][j-l];
                }
                dp[i][j]%=M;
            }
        }

        return (int)(dp[n][k]%M);
    }

    public static void main(String[] args) {
        // write your code here
        int n1=3,k1=0;
        int n2=3,k2=1;
        int n3=3,k3=2;
        int n4=1000,k4=1000;

        KInversePairs a = new KInversePairs();
        System.out.println(a.kInversePairs(n1,k1));//1
        System.out.println(a.kInversePairs(n2,k2));//2
        System.out.println(a.kInversePairs(n3,k3));//2
        System.out.println(a.kInversePairs(n4,k4));//663677020
    }
}
