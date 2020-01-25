package arland;

/**
 * @author xiangchaolei
 */
public class UniquePathsWithObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length==1&&obstacleGrid[0].length==1){
            return 1 - obstacleGrid[0][0];
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] d = new int[m][n];
        int max = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0&&j==0){
                    max = d[0][0] = 1;
                }
                else if(i==0){
                    if(obstacleGrid[i][j-1] == 1){
                        d[i][j] = 0;
                    }
                    else{
                        d[i][j] = obstacleGrid[i][j]==0?d[i][j-1]:0;
                    }
                }
                else if(j==0){
                    if(obstacleGrid[i-1][j] == 1){
                        d[i][j] = 0;
                    }
                    else{
                        d[i][j] = obstacleGrid[i][j]==0?d[i-1][j]:0;
                    }
                }
                else{
                    d[i][j] = obstacleGrid[i][j]==0?d[i-1][j] + d[i][j-1]:0;
                }
                if(max < d[i][j]){
                    max = d[i][j];
                }
            }
        }
        return d[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] d1 = new int[][]{new int[]{0,1}};
        int[][] d2 = new int[][]{new int[]{0,0}};
        int[][] d3 = new int[][]{new int[]{0}};
        int[][] d4 = new int[][]{new int[]{1}};
        UniquePathsWithObstacles a = new UniquePathsWithObstacles();
        System.out.println(a.uniquePathsWithObstacles(d1));
        System.out.println(a.uniquePathsWithObstacles(d2));
        System.out.println(a.uniquePathsWithObstacles(d3));
        System.out.println(a.uniquePathsWithObstacles(d4));
    }

}
