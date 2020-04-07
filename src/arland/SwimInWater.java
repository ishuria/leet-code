package arland;

/**
 * @author xiangchaolei
 */
public class SwimInWater {

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = n*n-1;
        for (int i = 0; i < m; i++) {
            boolean[][] visited = new boolean[n][n];
            visited[0][0] = true;
//            if(dfs(grid, visited)){
//                return i;
//            }
        }
        return m;
    }

    public boolean dfs(int[][] grid, boolean[][] visited, int i, int j){
        int n = grid.length;
        if(i==n-1&&j==n-1){
            return true;
        }
        else if(i==n-1){
            return dfs(grid, visited, i, j+1)||dfs(grid, visited, i, j-1);
        }
        else if(j==n-1){
            return dfs(grid, visited, i+1, j)||dfs(grid, visited, i-1, j);
        }
        else if(i==0&&j==0){
            return dfs(grid, visited, i+1, j)||dfs(grid, visited, i, j+1);
        }
        else if(i==0){
            return dfs(grid, visited, i+1, j)||dfs(grid, visited, i, j+1);
        }
        else if(j==0){
            return dfs(grid, visited, i+1, j)||dfs(grid, visited, i, j+1);
        }
        return false;
    }

    public static void main(String[] args) {
        // write your code here
        SwimInWater a = new SwimInWater();
        System.out.println(a.swimInWater(new int[][]{{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}}));
    }
}
