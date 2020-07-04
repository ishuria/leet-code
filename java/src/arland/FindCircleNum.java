package arland;

/**
 * @author xiangchaolei
 */
public class FindCircleNum {


    public int findCircleNum(int[][] M) {
        int n = M.length;
        boolean[] visited = new boolean[n];
        int ret = 0;
        while(true){

            boolean finish = true;
            for (int i = 0; i < n; i++) {
                if(!visited[i]){
                    visit(M, i,visited);
                    ret++;
                    finish = false;
                }
            }
            if(finish)break;
        }
        return ret;
    }

    public void visit(int[][] M, int i, boolean[] visited){
        visited[i] = true;
        int n = M.length;
        for (int j = 0; j < n; j++) {
            if(M[i][j]==1&&!visited[j]){
                visit(M,j,visited);
            }
        }
    }


    public static void main(String[] args) {
        // write your code here

        FindCircleNum a = new FindCircleNum();

        int[][] a1 = {{1,1,0},
                {1,1,0},
                {0,0,1}};

        int[][] a2 = {{1,1,0},
                {1,1,1},
                {0,1,1}};

        System.out.println(a.findCircleNum(a1));
        System.out.println(a.findCircleNum(a2));
    }
}
