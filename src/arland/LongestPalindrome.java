package arland;

/**
 * @author xiangchaolei
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int strLen = s.length();
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度

        boolean[][] dp = new boolean[strLen][strLen];

        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;

                    }
                }

            }

        }
        return s.substring(maxStart, maxEnd + 1);

    }


    public static void main(String[] args) {
//        System.out.println(isPalindrome("aa"));
//        System.out.println(isPalindrome("aba"));
//        System.out.println(isPalindrome("acba"));
//        System.out.println(isPalindrome("acbca"));
//        System.out.println(isPalindrome("acbbca"));
        LongestPalindrome a = new LongestPalindrome();
        System.out.println(a.longestPalindrome(""));
        System.out.println(a.longestPalindrome("a"));
        System.out.println(a.longestPalindrome("aa"));
        System.out.println(a.longestPalindrome("ac"));
        System.out.println(a.longestPalindrome("babad"));
        System.out.println(a.longestPalindrome("cbbd"));
    }

    private static boolean isPalindrome(String s){
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}
