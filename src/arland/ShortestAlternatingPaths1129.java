package arland;

import java.util.Arrays;

/**
 * @author xiangchaolei
 */
public class ShortestAlternatingPaths1129 {

    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        if(n==0){
            return new int[0];
        }
        int[] x = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 1; i < n; i++) {
            //start node 0
            int min = Integer.MAX_VALUE>>1;
            //check red edges
            for (int j = 1; j < n; j++) {
                if(j==i){
                    continue;
                }
                if(hasEdge(0, j, red_edges)){
                    int length = dfs(j, i, red_edges, blue_edges, visited, true);
                    if(-1==length){
                        x[i] = -1;
                    }
                }
            }
            //check blue edges
            x[i] = dfs(0, i, red_edges, blue_edges, visited, false);
        }
        return x;
    }

    private int dfs(int source,
                        int target,
                        int[][] red_edges,
                        int[][] blue_edges,
                        boolean[] visited,
                        boolean lastRed){
        if(source==target){
            return 1;
        }
        return -1;
    }

    private boolean hasEdge(int source,
                            int target,
                            int[][] edges){
        for (int i = 0; i < edges.length; i++) {
            if(edges[i][0]==source&&edges[i][1]==target){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // write your code here
        ShortestAlternatingPaths1129 a = new ShortestAlternatingPaths1129();

        int n1 = 3;
        int[][] red_edges1 = {{0,1},{1,2}};
        int [][] blue_edges1 = {};
        //[0,1,-1]

        System.out.println(Arrays.toString(a.shortestAlternatingPaths(n1, red_edges1, blue_edges1)));
    }
}
