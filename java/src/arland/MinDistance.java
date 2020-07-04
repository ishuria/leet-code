package arland;

/**
 * @author xiangchaolei
 */
public class MinDistance {

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if(0 == m && 0 == n){
            return 0;
        }

        int[][] d = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            d[i][0] = i;
        }

        for (int j = 0; j < n + 1; j++) {
            d[0][j] = j;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    d[i][j] = 1 + Math.min(Math.min(d[i-1][j], d[i][j-1]), d[i-1][j-1] - 1);
                }
                else{
                    d[i][j] = 1 + Math.min(Math.min(d[i-1][j], d[i][j-1]), d[i-1][j-1]);
                }
            }
        }
        return d[m][n];
    }

    public static void main(String[] args) {
        // write your code here
        MinDistance a = new MinDistance();
        System.out.println(a.minDistance("horse", "ros"));
        System.out.println(a.minDistance("intention", "execution"));
        System.out.println(a.minDistance("", ""));
        System.out.println(a.minDistance("a", "a"));
        System.out.println(a.minDistance("a", "b"));
        System.out.println(a.minDistance("a", "ab"));
    }
}
