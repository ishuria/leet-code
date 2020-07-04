package arland;

/**
 * @author xiangchaolei
 */
public class CherryPickup {

    public int cherryPickup(int[][] grid) {


        int n = grid.length;

        int[][] d = new int[n][n];

        for (int i = 1; i < n; i++) {
            if(grid[0][i]==-1){
                break;
            }
            else if(grid[0][i]==0){
                d[0][i] = d[0][i-1];
            }
            else{
                //grid[0][i]==1
                d[0][i] = d[0][i-1]+1;
            }
        }

        for (int i = 1; i < n; i++) {
            if(grid[i][0]==-1){
                break;
            }
            else if(grid[i][0]==0){
                d[i][0] = d[i-1][0];
            }
            else{
                //grid[0][i]==1
                d[i][0] = d[i-1][0]+1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if(grid[i-1][j]==-1){
                }

                else if(grid[i][0]==0){
                    d[i][0] = d[i-1][0];
                }
                else{
                    //grid[0][i]==1
                    d[i][0] = d[i-1][0]+1;
                }


            }
        }
        return 0;
    }

    public static void main(String[] args) {
        // write your code here
        CherryPickup a = new CherryPickup();
        System.out.println(a.cherryPickup(new int[][]{
                {0, 1, -1},
                {1, 0, -1},
                {1, 1,  1}
        }));
    }
}
