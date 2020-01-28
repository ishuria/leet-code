package arland;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiangchaolei
 */
public class WordBreak1 {

    //dp[i]代表0-i可以被划分
    //

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j]
                        && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        // write your code here
        WordBreak1 a = new WordBreak1();
        List<String> d1 = new ArrayList<>();
        d1.add("leet");
        d1.add("code");
        String s1 = "leetcode";


        List<String> d2 = new ArrayList<>();
        d2.add("apple");
        d2.add("pen");
        String s2 = "applepenapple";

        List<String> d3 = new ArrayList<>();
        d3.add("cats");
        d3.add("dog");
        d3.add("sand");
        d3.add("and");
        d3.add("cat");
        String s3 = "catsandog";

        System.out.println(a.wordBreak(s1, d1));
        System.out.println(a.wordBreak(s2, d2));
        System.out.println(a.wordBreak(s3, d3));
    }
}
