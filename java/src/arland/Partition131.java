package arland;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiangchaolei
 */
public class Partition131 {

    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        //1
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        //2
        for (int i = 0; i < n-1; i++) {
            dp[i][i+1] = isP(s.substring(i, i+2));
        }

        for (int len = 2; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                if(dp[i+1][j-1]&&s.charAt(i)==s.charAt(j)){
                    dp[i][j] = true;
                }
                else{
                    dp[i][j] =false;
                }
            }
        }

//        print(dp);

        return innerPartition(s, 0, dp);
    }
    
    public List<List<String>> innerPartition(String s, int pos, boolean[][] dp){
        int n = s.length();
        List<List<String>> r = new ArrayList<>();
        if(n==pos){
            List<String> rr = new ArrayList<>();
            r.add(rr);
            return r;
        }

        for (int len = pos; len < n; len++) {
            String prefix = s.substring(pos, len+1);
            if(!dp[pos][len]){
                continue;
            }
            List<List<String>> rights = innerPartition(s, len+1, dp);
            for (int i = 0; i < rights.size(); i++) {
                List<String> right = rights.get(i);
                right.add(0, prefix);
                r.add(right);
            }
        }
        return r;
    }

    private boolean isP(String s){
        boolean r = true;
        for (int i = 0; i < s.length()/2; i++) {
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                r = false;
            }
        }
        return r;
    }

    private void print(List<List<String>> r){
        for (int i = 0; i < r.size(); i++) {
            List<String> rr = r.get(i);
            for (int i1 = 0; i1 < rr.size(); i1++) {
                System.out.print(rr.get(i1)+" , ");
            }
            System.out.println();
        }
    }

    private void print(boolean[][] b){
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.print(b[i][j] + " , ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // write your code here
        Partition131 a = new Partition131();
        List<List<String>> r = a.partition("aabb");
        a.print(r);
    }
}
