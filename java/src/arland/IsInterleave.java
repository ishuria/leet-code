package arland;

/**
 * @author xiangchaolei
 */
public class IsInterleave {

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), l = s3.length();

        if(m+n!=l){
            return false;
        }

        boolean[][] d = new boolean[m+1][n+1];

        d[0][0] = true;

        for (int i = 1; i <= m; i++) {
            if(s1.charAt(i-1) == s3.charAt(i-1)){
                d[i][0] = true;
            }
            else{
                break;
            }
        }

        for (int j = 1; j <= n; j++) {
            if(s2.charAt(j-1) == s3.charAt(j-1)){
                d[0][j] = true;
            }
            else{
                break;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                d[i][j] = (d[i-1][j]&&s3.charAt(i+j-1)==s1.charAt(i-1))
                        ||(d[i][j-1]&&s3.charAt(i+j-1)==s2.charAt(j-1));
            }
        }


        return d[m][n];
    }

    public static void main(String[] args) {
        // write your code here
        IsInterleave a = new IsInterleave();
        System.out.println(a.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(a.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}
