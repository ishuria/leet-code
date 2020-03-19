package arland;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xiangchaolei
 */
public class RespaceSpace {



    public int respace(String[] dictionary, String sentence) {
        int maxSize = 0;
        Set<String> s = new HashSet<>();
        for (int i = 0; i < dictionary.length; i++) {
            s.add(dictionary[i]);
            maxSize = Math.max(maxSize, dictionary[i].length());
        }
        int n = sentence.length();
        int[] dp = new int[n+1];
        for (int i = 0; i < n; i++) {
            int min = 150000;
            for (int j = i; j >= 0&&j>(i-maxSize); j--) {
                String sub = sentence.substring(j, i+1);
                System.out.println(sub);
                if(s.contains(sub)){
                    min = Math.min(min, dp[j]);
                }
                else{
                    min = Math.min(min, dp[i]+1);
                }
            }
            dp[i+1] = min;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(dp[i+1]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        // write your code here



        String[] dictionary = {"looked","just","like","her","brother"};
        String sentence = "jesslookedjustliketimherbrother";

        RespaceSpace a = new RespaceSpace();
        System.out.println(a.respace(dictionary, sentence));
    }
}
