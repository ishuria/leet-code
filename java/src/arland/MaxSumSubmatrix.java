package arland;
//TODO
/**
 * @author xiangchaolei
 */
public class MaxSumSubmatrix {

    public int maxSumSubmatrix(int[][] matrix, int k) {

        int n = matrix.length;
        if(0==n){
            return 0;
        }
        int m = matrix[0].length;

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            int max = 1;
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += matrix[j][0];
                if(sum<=k){
                    max = Math.max(max, sum);
                }
            }
            dp[i][0] = max;
        }

        for (int i = 0; i < m; i++) {
            int max = -1;
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += matrix[0][j];
                if(sum<=k){
                    max = Math.max(max, sum);
                }
            }
            dp[0][i] = max;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {

                int a = matrix[i-1][j-1] + matrix[i][j-1]+matrix[i-1][j]+matrix[i][j];

                int b = -1;
                for (int l = 0; l < i-1; l++) {
                    for (int o = 0; o < j-1; o++) {
                        int c = matrix[l][o] + matrix[i][o]+matrix[l][j]+matrix[i][j];
                        if(c<=k){
                            b=Math.max(b,c);
                        }
                    }
                }

                if(a<=k&&b<=k){
                    dp[i][j] = Math.max(a,b);
                }
                else if(a<=k){
                    dp[i][j] = a;
                }
                else if(b<=k){
                    dp[i][j] = b;
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        return dp[n-1][m-1];
    }


    public static void main(String[] args) {
        // write your code here
        int[][] a1 = {{1,0,1},{0,-2,3}};
        int k1 = 2;

        int[][] a2 = {{2,2,-1}};
        int k2 = 3;


        int[][] a3 = {{2,2,-1}};
        int k3 = 0;

        MaxSumSubmatrix a = new MaxSumSubmatrix();
        System.out.println(a.maxSumSubmatrix(a1,k1));
        System.out.println(a.maxSumSubmatrix(a2,k2));
        System.out.println(a.maxSumSubmatrix(a3,k3));
    }
}
