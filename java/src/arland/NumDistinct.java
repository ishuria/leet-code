package arland;

/**
 * @author xiangchaolei
 */
public class NumDistinct {

    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if(0 == m && 0 == n){
            return 0;
        }

        int[][] d = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            d[i][0] = 1;
        }

        for (int j = 1; j < n + 1; j++) {
            d[0][j] = 0;
        }


        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    //使用s的字符的路径数+丢弃s的字符的路径数
                    d[i][j] = d[i-1][j-1]+d[i-1][j];
                }
                else{
                    //丢弃s的字符
                    d[i][j] = d[i-1][j];
                }
            }
        }

        return d[m][n];
    }

    public static void main(String[] args) {
        // write your code here
        NumDistinct a = new NumDistinct();
        System.out.println(a.numDistinct("rabbbit", "rabbit"));
        System.out.println(a.numDistinct("babgbag", "bag"));
    }
}
