package arland;

/**
 * @author xiangchaolei
 */
public class MinPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] d = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0&&j==0){
                    d[i][j] = grid[i][j];
                }
                else if(i==0){
                    d[i][j] = d[i][j-1]+grid[i][j];
                }
                else if(j==0){
                    d[i][j] = d[i-1][j]+grid[i][j];
                }
                else{
                    d[i][j] = Math.min(d[i][j-1], d[i-1][j])+grid[i][j];
                }
            }
        }
        return d[m-1][n-1];
    }

    public static void main(String[] args) {

        int[][] a1 = new int[][]{new int[]{0}};
        int[][] a2 = new int[][]{new int[]{1}};
        int[][] a3 = new int[][]{new int[]{1,3,1},new int[]{1,5,1},new int[]{4,2,1}};

        MinPathSum a = new MinPathSum();
        System.out.println(a.minPathSum(a1));
        System.out.println(a.minPathSum(a2));
        System.out.println(a.minPathSum(a3));
    }

}
