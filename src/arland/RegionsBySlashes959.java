package arland;

/**
 * @author xiangchaolei
 */
public class RegionsBySlashes959 {

    public int regionsBySlashes(String[] grid) {
        int n = grid.length+1;
        boolean[][][][] m = new boolean[n][n][n][n];
        boolean[][] i_visited = new boolean[n][n];
        boolean[][] j_visited = new boolean[n][n];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                char c = grid[i].charAt(j);
                if(c==' '){
                    m[i][j][i][j] = true;
                    m[i][j][i+1][j] = true;

                    m[i][j+1][i][j] = true;
                    m[i][j+1][i+1][j] = true;
                }
                else if(c=='\\'){
                    m[i][j][i+1][j] = true;

                    m[i][j+1][i][j] = true;
                }
                else if(c=='/'){
                    m[i][j][i][j] = true;

                    m[i][j+1][i+1][j] = true;
                }
            }
        }
        int region = 0;
        int[] firstNotVisited = getFirstNotVisited(i_visited, j_visited);
        while(firstNotVisited.length>0){
            dfs(m, i_visited, j_visited, firstNotVisited[0], firstNotVisited[1], firstNotVisited[2]==0);
            region++;
            firstNotVisited = getFirstNotVisited(i_visited, j_visited);
        }
        return region;
    }

    private int[] getFirstNotVisited(boolean[][] i_visited, boolean[][] j_visited){
        int n = i_visited.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n; j++) {
                if(!i_visited[i][j]){
                    return new int[]{i, j, 0};
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1; j++) {
                if(!j_visited[i][j]){
                    return new int[]{i, j, 1};
                }
            }
        }
        return new int[0];
    }

    private void dfs(boolean[][][][] m, boolean[][] i_visited, boolean[][] j_visited, int i, int j, boolean is_i){
        if(is_i){
            i_visited[i][j]=true;
            int n = i_visited.length;
            for (int k = 0; k < n; k++) {
                for (int l = 0; l < n; l++) {
                    if(m[i][j][k][l]&&!j_visited[k][l]){
                        dfs(m, i_visited, j_visited, k, l, false);
                    }
                }
            }
        }
        else{
            j_visited[i][j]=true;
            int n = i_visited.length;
            for (int k = 0; k < n; k++) {
                for (int l = 0; l < n; l++) {
                    if(m[k][l][i][j]&&!i_visited[k][l]){
                        dfs(m, i_visited, j_visited, k, l, true);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // write your code here
        RegionsBySlashes959 a = new RegionsBySlashes959();
        System.out.println(a.regionsBySlashes(new String[]{" /", "/ "}));//2
        System.out.println(a.regionsBySlashes(new String[]{" /", "  "}));//1
        System.out.println(a.regionsBySlashes(new String[]{"\\/", "/\\"}));//4
        System.out.println(a.regionsBySlashes(new String[]{"/\\", "\\/"}));//5
        System.out.println(a.regionsBySlashes(new String[]{"//", "/ "}));//3
    }
}
