package arland;

/**
 * @author xiangchaolei
 */
public class CalculateMinimumHP {

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m][n];
        for (int i = m-1; i >=0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if(m-1==i&&n-1==j){
                    dp[i][j] = dungeon[i][j]>0?1:dungeon[i][j]*-1+1;
                }
                else if(m-1==i){
                    dp[i][j] = dp[i][j+1] - dungeon[i][j];
                }
                else if(n-1==j){
                    dp[i][j] = dp[i+1][j] - dungeon[i][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i][j+1], dp[i+1][j]) - dungeon[i][j];
                }
                if (dp[i][j] <= 0) {
                    dp[i][j] = 1;
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        // write your code here
        int[][] a1 = new int[][]{
                new int[]{-2,-3,3},
                new int[]{-5,-10,1},
                new int[]{10,30,-5},
        };
        int[][] a2 = new int[][]{
                new int[]{100},
        };

        int[][] a3 = new int[][]{
                new int[]{1,-3,3},
                new int[]{0,-2,0},
                new int[]{-3,-3,-3},
        };
        CalculateMinimumHP a = new CalculateMinimumHP();
        System.out.println(a.calculateMinimumHP(a1));
//        System.out.println(a.calculateMinimumHP(a2));
        System.out.println(a.calculateMinimumHP(a3));
    }
}
