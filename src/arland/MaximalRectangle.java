package arland;

/**
 * @author xiangchaolei
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(0 == m){
            return 0;
        }
        int n = matrix[0].length;

        int[][] d = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(0 == i && 0 == j){
                    if('0' == matrix[i][j]){
                        d[i][j] = 0;
                    }
                    else{
                        d[i][j] = 1;
                    }
                }
                else if(0 == i){
                    if('0' == matrix[i][j]){
                        d[i][j] = d[i][j-1];
                    }
                    else{
                        d[i][j] = Math.max(d[i][j-1], calcMax(matrix, i, j));
                    }
                }
                else if(0 == j){
                    if('0' == matrix[i][j]){
                        d[i][j] = d[i-1][j];
                    }
                    else{
                        d[i][j] = Math.max(d[i-1][j], calcMax(matrix, i, j));
                    }
                }
                else{
                    if('0' == matrix[i][j]){
                        d[i][j] = Math.max(d[i-1][j], d[i][j-1]);
                    }
                    else{
                        d[i][j] = Math.max(Math.max(d[i-1][j], d[i][j-1]), calcMax(matrix, i, j));
                    }
                }
            }
        }
        return d[m-1][n-1];
    }

    private int calcMax(char[][] matrix, int i, int j){
        int max = 0;
        int bound = 0;
        for (int k = i; k >= 0 ; k--) {
            for (int l = j; l >= bound ; l--) {
                if(matrix[k][l] == '0'){
                    bound = l + 1;
                    break;
                }
                else{
                    if(max < (i - k + 1) * (j - l + 1) ){
                        max = (i - k + 1) * (j - l + 1);
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        // write your code here
        char[][] a1 = new char[][]{
                new char[]{'1','1','1','0','0'},
                new char[]{'1','1','1','0','1'},
                new char[]{'1','1','1','1','1'},
                new char[]{'1','1','0','1','0'}
        };

        char[][] a2 = new char[][]{
                new char[]{'0'},
        };

        char[][] a3 = new char[][]{
                new char[]{'1'},
        };

        char[][] a4 = new char[][]{
                new char[]{'0','0'},
        };

        char[][] a5 = new char[][]{
                new char[]{'1','1'},
        };

        char[][] a6 = new char[][]{
                new char[]{'1','0','1','1','1'},
                new char[]{'0','1','0','1','0'},
                new char[]{'1','1','0','1','1'},
                new char[]{'1','1','0','1','1'},
                new char[]{'0','1','1','1','1'},
        };

        char[][] a7 = new char[][]{
                new char[]{'0','1','1','1','1','1','1','0','1'},
        };

        char[][] a8 = new char[][]{
                new char[]{'1','0','1','1','1','1','0','1','1'},
                new char[]{'0','1','0','1','0','0','0','0','0'},
                new char[]{'0','0','0','0','1','0','1','1','0'},
                new char[]{'1','1','1','0','1','0','1','0','1'},
        };


        MaximalRectangle a = new MaximalRectangle();
        System.out.println(a.maximalRectangle(a1));
        System.out.println(a.maximalRectangle(a2));
        System.out.println(a.maximalRectangle(a3));
        System.out.println(a.maximalRectangle(a4));
        System.out.println(a.maximalRectangle(a5));
        System.out.println(a.maximalRectangle(a6));
        System.out.println(a.maximalRectangle(a7));
        System.out.println(a.maximalRectangle(a8));
    }
}
