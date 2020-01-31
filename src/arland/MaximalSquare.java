package arland;

/**
 * @author xiangchaolei
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if(0 == m){
            return 0;
        }
        int n = matrix[0].length;
        int max = 0;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if(matrix[i][0]=='1'){
                dp[i][0] = 1;
                max = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if(matrix[0][i]=='1'){
                dp[0][i] = 1;
                max = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][j]=='1'){
                    dp[i][j] = Math.min(
                            Math.min(
                                    dp[i-1][j], dp[i][j-1]
                            ),
                            dp[i-1][j-1]
                    )+1;
                }
                if(dp[i][j]>max){
                    max = dp[i][j];
                }
            }
        }
        return max*max;
    }

    public static void main(String[] args) {
        // write your code here

        char[][] a1 = new char[][]{
                new char[]{'1','0','1','0','0'},
                new char[]{'1','0','1','1','1'},
                new char[]{'1','1','1','1','1'},
                new char[]{'1','0','0','1','0'},
        };
        MaximalSquare a = new MaximalSquare();
        System.out.println(a.maximalSquare(a1));
    }
}
