package arland;

/**
 * @author xiangchaolei
 */
public class LongestPalindrome {

//    public String longestPalindrome(String s) {
//        if (s == null || s.length() < 2) {
//            return s;
//        }
//        int strLen = s.length();
//        int maxStart = 0;  //最长回文串的起点
//        int maxEnd = 0;    //最长回文串的终点
//        int maxLen = 1;  //最长回文串的长度
//
//        boolean[][] dp = new boolean[strLen][strLen];
//
//        for (int r = 1; r < strLen; r++) {
//            for (int l = 0; l < r; l++) {
//                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
//                    dp[l][r] = true;
//                    if (r - l + 1 > maxLen) {
//                        maxLen = r - l + 1;
//                        maxStart = l;
//                        maxEnd = r;
//
//                    }
//                }
//
//            }
//
//        }
//        return s.substring(maxStart, maxEnd + 1);
//
//    }

    public String longestPalindrome(String s) {
        int n = s.length();
        if(0==n){
            return "";
        }
        int[] dp = new int[n+1];
        dp[0] = 0;

        for (int i = 1; i <= n ; i++) {
            if(s.charAt(i-1)==s.charAt(i-dp[i-1]-1)){
                dp[i] = dp[i-1]+2;
            }
            else if(s.charAt(i-1)==s.charAt(i-dp[i-1])){
                dp[i] = dp[i-1]+1;
            }
            else{
                dp[i] = 1;
            }
        }
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i <=n ; i++) {
            if(max<dp[i]){
                max = dp[i];
                maxIndex = i-1;
            }
        }
        return s.substring(maxIndex-max,maxIndex);
    }


    public static void main(String[] args) {
        LongestPalindrome a = new LongestPalindrome();
//        System.out.println(a.longestPalindrome(""));//
//        System.out.println(a.longestPalindrome("a"));//a
//        System.out.println(a.longestPalindrome("aa"));//aa
//        System.out.println(a.longestPalindrome("ac"));//a
        System.out.println(a.longestPalindrome("babad"));//bab
        System.out.println(a.longestPalindrome("cbbd"));//bb
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
