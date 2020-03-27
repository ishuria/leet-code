package arland;

/**
 * @author xiangchaolei
 */
public class LongestArithSeqLength {


    public int longestArithSeqLength(int[] A) {

        if(A == null || A.length < 3)
            return 0;
        int[][] dp = new int[A.length][20010];
        int max = 0;
        for(int i = 1; i < A.length; i++){
            for(int j = 0; j < i; j++){
                int distance = A[i] - A[j] + 10000;
                if(dp[j][distance] > 0){
                    dp[i][distance] = (dp[i][distance] > dp[j][distance]+1) ? dp[i][distance] : dp[j][distance]+1;
                }
                else{
                    dp[i][distance] = 2;
                }
                max = max > dp[i][distance] ? max : dp[i][distance];
            }
        }
        return max;

    }

    public static void main(String[] args) {
        // write your code here
        LongestArithSeqLength a = new LongestArithSeqLength();

        System.out.println(a.longestArithSeqLength(new int[]{3,6,9,12}));
        System.out.println(a.longestArithSeqLength(new int[]{9,4,7,2,10}));
        System.out.println(a.longestArithSeqLength(new int[]{20,1,15,3,10,5,8}));
    }
}
